package com.example.mvplogin.InterFace

import com.example.mvplogin.DataClass.DataX
import com.example.mvplogin.DataClass.Model

interface UserDataInterface {

    interface UserView{

        fun getUserDataFromPresenter(list: List<DataX>)

    }


        fun getUserData( token:String,presenter: UserDataPresenter)
        fun getUsersList() : List<DataX>

    interface UserDataPresenter{
        fun userDataNetworkCall(token:String)

        fun getUserList(): List<DataX>
        fun updateRecyclerView( list : List<DataX>)

    }
}