package com.jayboat.ego.ui.activity

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MotionEvent
import android.view.View
import android.view.animation.LinearInterpolator
import com.jayboat.ego.R
import invisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_buttons.*
import kotlinx.android.synthetic.main.include_disc.view.*
import kotlinx.android.synthetic.main.include_toolbar.*
import screenWidth
import visible

class MainActivity : AppCompatActivity() {

    private var x1 = 0f
    private var x2 = 0f
    private var isPicture = true
    private var isExpand = false
    private val moods = mutableListOf("happy", "unhappy", "clam", "sad")
    private val moodsRes = mutableListOf(R.drawable.ic_smile, R.drawable.ic_unhappy, R.drawable.ic_clam, R.drawable.ic_sad)
    private val animator by lazy {
        ObjectAnimator.ofFloat(fl_container, "alpha", 1f, 0f, 1f)
                .apply {
                    duration = 2500
                    interpolator = LinearInterpolator()
                }
    }
    private val discView by lazy { View.inflate(this, R.layout.include_disc, null) }
    private val lyricView by lazy { View.inflate(this, R.layout.include_lyrics, null) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }


    private fun initView() {
        (include as Toolbar).apply {
            setNavigationIcon(R.drawable.ic_setting)
            setNavigationOnClickListener {
                if (!dl_main.isDrawerOpen(nv_setting)) {
                    dl_main.openDrawer(nv_setting)
                }
            }
        }

        fl_container.addView(discView)
        fl_container.setOnClickListener {
            changeView()
        }

        discView.dim_playing.apply {
            setBackgroundView(discView.sv_dic)
            playDisk()
        }

        discView.tv_name_song.text = "Changes"
        discView.tv_name_singer.text = "魂音泉"

        dl_main.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        ibtn_more.setOnClickListener {
            //        todo:页面跳转，内容详情页面
        }

        iv_current.setOnClickListener {
            changeMood()
        }
    }

    private fun changeMood() {
        if (isExpand) {
            iv_bg.invisible()
            iv_bottom.invisible()
            iv_center.invisible()
            iv_top.invisible()
            isExpand = false
        } else {
            iv_bg.visible()
            iv_bottom.visible()
            iv_center.visible()
            iv_top.visible()
            isExpand = true
            iv_bottom.setOnClickListener { changeData(1) }
            iv_center.setOnClickListener { changeData(2) }
            iv_top.setOnClickListener { changeData(3) }
        }
    }

    private fun changeData(index: Int) {
        val temp = moods[index]
        moods[index] = moods[0]
        moods[0] = temp
        val tempRes = moodsRes[index]
        moodsRes[index] = moodsRes[0]
        moodsRes[0] = tempRes
        when(index){
            1 -> iv_bottom.setImageDrawable(ContextCompat.getDrawable(this,moodsRes[1]))
            2 -> iv_center.setImageDrawable(ContextCompat.getDrawable(this,moodsRes[2]))
            3 -> iv_top.setImageDrawable(ContextCompat.getDrawable(this,moodsRes[3]))
        }
        iv_current.setImageDrawable(ContextCompat.getDrawable(this,moodsRes[0]))
    }

    private fun changeView() {
        var isUpdate = false
        if (!isPicture) {
            isPicture = true
            tv_title.text = " "
            animator.apply {
                addUpdateListener {
                    if ((it.animatedValue as Float) < 0.02 && !isUpdate) {
                        isUpdate = true
                        fl_container.removeAllViews()
                        fl_container.addView(discView)
                    }
                }
                start()
            }

        } else {
            isPicture = false
            tv_title.text = discView.tv_name_song.text
            animator.apply {
                addUpdateListener {
                    if ((it.animatedValue as Float) < 0.02 && !isUpdate) {
                        isUpdate = true
                        fl_container.removeAllViews()
                        fl_container.addView(lyricView)
                    }
                }
                start()
            }
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (!isPicture)
            return super.dispatchTouchEvent(ev)

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
                    return true
                }
                x2 - x1 > screenWidth / 3f -> {
                    toPreviousMusic()
                    return true
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    //      前往下一首歌
    private fun toNextMusic() {
        discView.dim_playing.stateChanged(R.drawable.ic_disc_src1)
        discView.tv_name_song.text = "DayDream"
        discView.tv_name_singer.text = "魂音泉"
    }

    //      前往前一首歌
    private fun toPreviousMusic() {
        discView.dim_playing.stateChanged(R.drawable.ic_disk_src)
        discView.tv_name_song.text = "Changes"
        discView.tv_name_singer.text = "魂音泉"
    }
}

