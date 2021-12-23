package com.example.mvplogin

import com.example.mvplogin.InterFace.UserApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingle {

    private const val BASE_URL = "https://rma.staging.kenyanut.com/api/"

    private fun getRetrofitInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userApiInstance : UserApiService by lazy {
        getRetrofitInstance().create(UserApiService::class.java)
    }
}