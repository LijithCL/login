package com.example.mvplogin.ModelClass

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class SessionManager  @SuppressLint("CommitPrefEdits") constructor( private val context: Context) {

    private val pref: SharedPreferences
    private val editor: SharedPreferences.Editor

   /*App open status*/
        var appOpenStatus: Boolean
       get() = pref.getBoolean(APP_OPEN_STATUS, false)
        set(value) {
            editor.putBoolean(APP_OPEN_STATUS, value).apply()
        }

    //Login Email
    var login_email: String?
        get() = pref.getString(LOGINEMAIL, "")
        set(value) {
            editor.putString(LOGINEMAIL, value).apply()
        }

    //Login Password
    var login_password: String?
        get() = pref.getString(LOGINPASSWORD, "")
        set(value) {
            editor.putString(LOGINPASSWORD, value).apply()
        }
    //token
    var token: String?
        get() = pref.getString(TOKEN, "")
        set(value) {
            editor.putString(TOKEN, value).apply()
        }

    companion object {

        private const val PREF_NAME = "Ecommerce_Session"
        const val APP_OPEN_STATUS="app_open_status"
        val LOGINEMAIL="login_email"
        val LOGINPASSWORD="login_password"
        val TOKEN="Token"
    }


   init {
       // Shared pref mode
        val PRIVATE_MODE = 0
        pref = context.getSharedPreferences(
            PREF_NAME,
            PRIVATE_MODE
        )
       editor = pref.edit()
        }

    fun logout(){
      editor.clear()
      editor.commit()
  }
}
