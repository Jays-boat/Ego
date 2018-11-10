package com.jayboat.ego.ui.activity

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import com.jayboat.ego.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_toolbar.*
import screenWidth

class MainActivity : AppCompatActivity() {

    private var x1 = 0f
    private var x2 = 0f
    private var isPicture = true
    private var isExpand = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }


    private fun initView() {
        ibtn_right_icon.apply {
            setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_setting))
            setOnClickListener {
                if (!dl_main.isDrawerOpen(nv_setting)) {
                    dl_main.openDrawer(nv_setting)
                }
            }
        }

        dim_playing.apply {
            setBackgroundView(sv_dic)
            dim_playing.playDisk()
            setOnClickListener {
//              进行操作之后还要显示歌词页面..
                isPicture = if (isPicture) {
                    disappear()
                    false
                } else {
                    show()
                    true
                }
            }
        }

        tv_name_song.text = "Changes"
        tv_name_singer.text = "魂音泉"

        dl_main.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            //当手指按下的时候
            x1 = ev.x
        }
        if (ev.action == MotionEvent.ACTION_UP) {
            //当手指离开的时候
            x2 = ev.x
            when {
                x1 - x2 > screenWidth / 3f -> {
                    toNextMusic()
//                    Toast.makeText(this@MainActivity, "向左滑", Toast.LENGTH_SHORT).show()
                }
                x2 - x1 > screenWidth / 3f -> {
                    toPreviousMusic()
//                    Toast.makeText(this@MainActivity, "向右滑", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    private fun toNextMusic() {
        dim_playing.stateChanged()
//      前往下一首歌
    }

    private fun toPreviousMusic() {
        dim_playing.stateChanged()
//      前往前一首歌
    }
}

