package com.example.mvplogin.Repository

import android.util.Log
import com.example.mvplogin.ModelClass.Apibody
import com.example.mvplogin.DataClass.Data
import com.example.mvplogin.DataClass.Datas
import com.example.mvplogin.RetrofitSingleton
import com.example.mvplogin.InterFace.UserInterface
import com.example.mvplogin.RetrofitSingle
import retrofit2.Response


class UserRepo : UserInterface {



    override fun getUserLoginData(email: String, password: String, presenter: UserInterface.LoginPresenter) {

        val apibody = Apibody(email,password)
        var body = apibody
        var call = RetrofitSingleton.userApiInstance.getUsers(body)

        call.enqueue(object : retrofit2.Callback<Datas> {
            override fun onResponse(
                call: retrofit2.Call<Datas>,
                response: Response<Datas>
            ) {
                if (response.isSuccessful) {
                    val loginData = response.body()!!.data.login_details.token

                    presenter.loginData(loginData)
                }else{
                    presenter.loginData("error")
                }
            }

            override fun onFailure(call: retrofit2.Call<Datas>, t: Throwable) {
                Log.d("Network call failed", t.message.toString())
            }

        })
    }




}