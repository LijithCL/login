package com.example.mvplogin.Presenter

import com.example.mvplogin.InterFace.UserInterface
import com.example.mvplogin.Repository.DetailRepo
import com.example.mvplogin.Repository.UserRepo

class LoginPresenter(mView: UserInterface.UserView) : UserInterface.LoginPresenter {


    private var view: UserInterface.UserView = mView

    private val model: UserInterface = UserRepo()


    override fun loginNetworkCall(email: String, password: String) {
        model.getUserLoginData(email, password,this)
    }
    override fun loginData(loginData: String) {
        view.getLoginData(loginData)
    }







}