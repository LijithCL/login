package com.example.mvplogin.Presenter

import com.example.mvplogin.DataClass.DataX
import com.example.mvplogin.DataClass.Model
import com.example.mvplogin.InterFace.UserDataInterface
import com.example.mvplogin.Repository.DetailRepo

class UserDataPresenter(userDataView: UserDataInterface.UserView) : UserDataInterface.UserDataPresenter  {
    private var view: UserDataInterface.UserView = userDataView
    private val model: UserDataInterface = DetailRepo()

    override fun userDataNetworkCall(token :String) {
        model.getUserData(token,this)
    }

    override fun getUserList(): List<DataX> {
        return model.getUsersList()
    }
    override fun updateRecyclerView(list : List<DataX>) {
        view.getUserDataFromPresenter(list)
    }
}