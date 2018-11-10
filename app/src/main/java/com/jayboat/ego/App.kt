package com.jayboat.ego

import android.app.Application
import android.content.Context

/*
 * Create by Cchanges on 2018/11/10
 */

lateinit var appContext: Context
    private set

class App : Application() {
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        appContext = base
    }
}