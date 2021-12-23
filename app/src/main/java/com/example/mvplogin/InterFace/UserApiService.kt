package com.example.mvplogin.InterFace

import com.example.mvplogin.DataClass.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface UserApiService {
    @GET("v1/viewlotlist")//https://rma.staging.kenyanut.com/api/v1/viewlotlist?search={search}&offset=0


    fun getDetails(@Header("Authorization") token: String): Call<Model>
}