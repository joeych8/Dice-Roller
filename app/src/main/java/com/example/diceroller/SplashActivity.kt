package com.example.diceroller

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT = 3000L //Duration on splashActivity (2 sec)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            val activityIntent = Intent(this, MainActivity::class.java)
            activityIntent.flags or Intent.FLAG_ACTIVITY_NO_HISTORY
            startActivity(activityIntent)
            finish()
        }, SPLASH_TIME_OUT)
    }
}