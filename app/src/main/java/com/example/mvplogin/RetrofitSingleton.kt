package com.example.mvplogin

import com.example.mvplogin.InterFace.UserApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitSingleton {

    private const val BASE_URL = "https://rma.staging.kenyanut.com/api/"

    private fun getRetrofitInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userApiInstance : UserApi by lazy {
        getRetrofitInstance().create(UserApi::class.java)
    }
}