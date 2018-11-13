package com.jayboat.ego.ui.activity

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import com.jayboat.ego.service.MusicPlayerService

/**
 * Created by Hosigus on 2018/7/28.
 */
@SuppressLint("Registered")
abstract class BaseActivity : AppCompatActivity(), MusicPlayerService.MusicPlayerListener {
    protected var musicControlBinder: MusicPlayerService.MusicControlBinder? = null

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