package com.example.mvplogin

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.mvplogin.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    lateinit var binding : ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            initLottieAnimation()
        }

    }

    private fun initLottieAnimation() {
        binding.animationView.setAnimation("animation.json")
//        binding.animationView.loop(true)
        binding.animationView.playAnimation()
        val mp =  MediaPlayer.create(this, R.raw.msn);
        mp.start()



    }
}