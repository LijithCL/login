package com.example.mvplogin

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvplogin.InterFace.UserInterface
import com.example.mvplogin.ModelClass.SessionManager
import com.example.mvplogin.Presenter.LoginPresenter
import com.example.mvplogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), UserInterface.UserView {

    lateinit var binding :ActivityMainBinding
    lateinit var presenter : LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter= LoginPresenter(this)

        binding.passwordToggle.setOnClickListener {
            if(binding.txtLoginPassword.transformationMethod.equals(PasswordTransformationMethod.getInstance())) {
                binding.txtLoginPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.txtLoginPassword.setSelection(binding.txtLoginPassword.length())
            }else{
                binding.txtLoginPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.txtLoginPassword.setSelection(binding.txtLoginPassword.length())
            }
        }

        binding.progressBar.visibility=View.GONE

        binding.btnLogin.setOnClickListener {

            if (binding.txtLoginEmail.text.toString().equals("") && binding.txtLoginPassword.text.toString().equals("")) {
                Toast.makeText(this, "Please Enter Details", Toast.LENGTH_SHORT).show()
            } else {
                binding.btnLogin.visibility=View.GONE
                binding.progressBar.visibility=View.VISIBLE
                getLoginFromApi(binding.txtLoginEmail.text.toString(),binding.txtLoginPassword.text.toString())
            }
        }

    }

    private fun getLoginFromApi(email: String, password: String) {
        presenter.loginNetworkCall(email, password)
    }

    override fun getLoginData(userData: String) {
      if(userData != "") {
            val session = SessionManager(context = this)
            SessionManager(context = this).appOpenStatus=true
            session.login_email = binding.txtLoginEmail.text.toString()
            session.login_password = binding.txtLoginPassword.text.toString()
            session.token = userData
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()

       } else{
            Toast.makeText(this, "Please Enter Valid Details", Toast.LENGTH_SHORT).show()
            binding.btnLogin.visibility=View.VISIBLE
            binding.progressBar.visibility=View.GONE
       }
    }


}