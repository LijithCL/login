package com.example.mvplogin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvplogin.AdapterClass.UserDataAdapter
import com.example.mvplogin.DataClass.DataX
import com.example.mvplogin.InterFace.UserDataInterface
import com.example.mvplogin.ModelClass.SessionManager
import com.example.mvplogin.Presenter.UserDataPresenter
import com.example.mvplogin.RoomDatabase.RoomAppDb
import com.example.mvplogin.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity(), UserDataInterface.UserView {
    var token:String?=""
    lateinit var binding : ActivityMain2Binding
    lateinit var presenter : UserDataPresenter
    private val userList = mutableListOf<DataX>()
    private lateinit var adapter: UserDataAdapter

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initLottieAnimation()

        binding.swipeRefresh.setOnRefreshListener {
            setupRecyclerView()
            checkInternetStatus()
            binding.swipeRefresh.setRefreshing(false);
        }

        presenter= UserDataPresenter(this)
        var session = SessionManager(context = this)
        val loginEmail = session.login_email
         token = session.token
//        binding.loggedDetails.text=loginEmail

        binding.btnLogout.setOnClickListener {

            session.logout()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(this,"Logout Success",Toast.LENGTH_SHORT).show()
        }

        setupRecyclerView()
        checkInternetStatus()

    }

    private fun initLottieAnimation() {
        binding.animationView.setAnimation("animation.json")
        binding.animationView.loop(true)
        binding.animationView.playAnimation()
    }

    private fun checkInternetStatus() {
        var isConnected :Boolean=ConnectionStatus.call(this)
        if(isConnected) {
            getUsersFromApi(token!!)
        }else{
            var App = RoomAppDb.getAppDatabase(this)
            var data = App?.registerDatabaseDao()?.getAllUser()
            adapter = data?.let { UserDataAdapter(this, it) }!!
            binding.recyclerView.adapter = adapter
           binding.animationView.visibility=View.GONE
        }
    }

    private fun getUsersFromApi(token:String) {
        presenter.userDataNetworkCall(token)

    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity2)
            setHasFixedSize(true)

        }
    }

   @SuppressLint("NotifyDataSetChanged")
   override fun getUserDataFromPresenter(list: List<DataX>) {
        //Toast.makeText(this,"$userData",Toast.LENGTH_LONG).show()
       userList.addAll(presenter.getUserList())
//        adapter = UserDataAdapter(this, userList)
//       adapter.notifyDataSetChanged()
//        binding.recyclerView.adapter = adapter
//       binding.recyclerView.clearOnChildAttachStateChangeListeners()
//       binding.progressBar.visibility=View.GONE
       val App = RoomAppDb.getAppDatabase(this)
       App?.registerDatabaseDao()?.deleteAll()
       App?.registerDatabaseDao()?.insert(list as MutableList<DataX>)
       var data = App?.registerDatabaseDao()?.getAllUser()
       adapter = data?.let { UserDataAdapter(this, it) }!!
       binding.recyclerView.adapter = adapter
      binding.animationView.visibility= View.GONE
   }
}