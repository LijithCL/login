package com.example.mvplogin.DataClass

data class Datas(
    //val token: String
    val `data`: Data,
    val message: String,
    val statusCode: Int,
    val success: Boolean

)
data class Data(

    val login_details: LoginDetails,

)
data class LoginDetails(
    val created_at: String,
    val first_name: String,
    val last_name: String,
    val phone: String,
    val token: String,
    val updated_at: String,
    val username: String
)