package com.jayboat.ego.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.jayboat.ego.R
import com.jayboat.ego.utils.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        getList(happyId)
        getList(unhappyId)
        getList(clamId)
        getList(excitingId)
        Handler().postDelayed({
            startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
            finish()
        }, 3000)
    }
}
