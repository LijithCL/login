package com.example.mvplogin.InterFace

interface UserInterface {

    interface UserView {
        fun getLoginData(loginData: String)
    }

        fun getUserLoginData(email: String, password: String, presenter: LoginPresenter)



    interface LoginPresenter{
        fun loginNetworkCall(email:String, password:String)
        fun loginData(loginData:String)

    }

}
