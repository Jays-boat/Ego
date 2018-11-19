package com.jayboat.ego.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jayboat.ego.R
import com.jayboat.ego.utils.checkUpdate
import com.jayboat.ego.utils.prepareSongList
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        prepareSongList{
            AndroidSchedulers.mainThread().scheduleDirect {
                startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
                finish()
            }
        }
        checkUpdate()
    }

}
