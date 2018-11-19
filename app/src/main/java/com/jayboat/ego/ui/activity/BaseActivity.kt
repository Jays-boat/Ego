package com.jayboat.ego.ui.activity

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import com.jayboat.ego.service.MusicPlayerService
import com.r0adkll.slidr.Slidr

/**
 * Created by Hosigus on 2018/7/28.
 */
@SuppressLint("Registered")
abstract class BaseActivity : AppCompatActivity(), MusicPlayerService.MusicPlayerListener {
    protected var musicControlBinder: MusicPlayerService.MusicControlBinder? = null
    protected open val needSlide: Boolean = true

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            musicControlBinder?.removeListener(this@BaseActivity)
            musicControlBinder = null
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            musicControlBinder = service as MusicPlayerService.MusicControlBinder
            musicControlBinder?.addListener(this@BaseActivity)
            onServiceConnected()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (needSlide) {
            Slidr.attach(this)
        }
    }

    override fun onStart() {
        super.onStart()
        musicControlBinder ?: bindService()
    }

    override fun onDestroy() {
        unbindService()
        super.onDestroy()
    }

    private fun bindService() {
        startService(Intent(this, MusicPlayerService::class.java))
        bindService(Intent(this, MusicPlayerService::class.java), serviceConnection, BIND_AUTO_CREATE)
    }

    private fun unbindService() {
        unbindService(serviceConnection)
    }

    protected open fun onServiceConnected() {

    }

}