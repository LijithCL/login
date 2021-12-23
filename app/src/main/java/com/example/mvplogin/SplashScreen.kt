package com.example.mvplogin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mvplogin.ModelClass.SessionManager
import com.example.mvplogin.databinding.ActivitySplashScreenBinding


class SplashScreen : AppCompatActivity() {

    lateinit var bindingSplashScreen : ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSplashScreen = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(bindingSplashScreen.root)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val session = SessionManager(context = this)
            val loginStatus = session.appOpenStatus

            if (loginStatus){
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
                finish()
            }else {
                val intent = Intent(this@SplashScreen, MainActivity::class.java)
                startActivity(intent)

                finish()
            }
        }, 3000)

    }//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvcm1hLnByb2R1Y3Rpb24ua2VueWFudXQuY29tIiwiYXVkIjoiaHR0cHM6XC9cL3JtYS5wcm9kdWN0aW9uLmtlbnlhbnV0LmNvbSIsImlhdCI6MTYzODQ0MTE3NSwibmJmIjoxNjM4NDQxMTc1LCJleHAiOjE2Mzg0NTkxNzUsImp0aSI6IjhYby1tWmV6WjBiaGZkcExvYXpMZU51SzdFc0xEa0VlIn0.tB8BXqsI6kCrzcPqaLWIncZ3K3vso1o6ahNXv41kz2c
}//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvcm1hLnByb2R1Y3Rpb24ua2VueWFudXQuY29tIiwiYXVkIjoiaHR0cHM6XC9cL3JtYS5wcm9kdWN0aW9uLmtlbnlhbnV0LmNvbSIsImlhdCI6MTYzODQ0MTcxMiwibmJmIjoxNjM4NDQxNzEyLCJleHAiOjE2Mzg0NTk3MTIsImp0aSI6IjhYby1tWmV6WjBiaGZkcExvYXpMZU51SzdFc0xEa0VlIn0.RxaQj26QG3Laob8R6ck9xHosKRoZgQLm1117NJqU8jw
//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvcm1hLnByb2R1Y3Rpb24ua2VueWFudXQuY29tIiwiYXVkIjoiaHR0cHM6XC9cL3JtYS5wcm9kdWN0aW9uLmtlbnlhbnV0LmNvbSIsImlhdCI6MTYzODQ0MjM3MCwibmJmIjoxNjM4NDQyMzcwLCJleHAiOjE2Mzg0NjAzNzAsImp0aSI6IjhYby1tWmV6WjBiaGZkcExvYXpMZU51SzdFc0xEa0VlIn0.93_CTJ7UZDN-2svoecpffU-3nW_EarS2IjkdOS4NtW0
