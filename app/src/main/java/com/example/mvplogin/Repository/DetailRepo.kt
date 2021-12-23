package com.example.mvplogin.Repository

import android.util.Log
import com.example.mvplogin.DataClass.DataX
import com.example.mvplogin.DataClass.Model
import com.example.mvplogin.InterFace.UserDataInterface
import com.example.mvplogin.MainActivity2
import com.example.mvplogin.RetrofitSingle
import com.example.mvplogin.RoomDatabase.RoomAppDb
import retrofit2.Response

class DetailRepo : UserDataInterface {

    var userList = mutableListOf<DataX>()

    override fun getUserData(token:String, presenter: UserDataInterface.UserDataPresenter) {
        Log.e("token", token)
        var call = RetrofitSingle.userApiInstance.getDetails("Bearer $token")
        call.enqueue(object : retrofit2.Callback<Model> {
            override fun onResponse(
                call: retrofit2.Call<Model>,
                response: Response<Model>
            ) {
                if (response.isSuccessful) {
                    Log.e("Detail API success", response.body()!!.statusCode.toString())
                  val userData = response.body()!!.data
//                    userList.clear()
//                    userList.addAll(userData)
                    presenter.updateRecyclerView(response.body()!!.data)

                }else{
                    //Log.e("Network call failed", response?.body()!!.message.toString())
                    //val userData = response.body()!!.message
                    //presenter.loginDatas(userData.toString())
                }
            }

            override fun onFailure(call: retrofit2.Call<Model>, t: Throwable) {
                Log.e("Detial API failed", t.message.toString())
            }

        })
    }
    override fun getUsersList(): List<DataX> = userList

}