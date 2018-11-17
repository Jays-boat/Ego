package com.jayboat.ego.ui.activity

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.DrawerLayout
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.LinearInterpolator
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.jayboat.ego.R
import com.jayboat.ego.bean.Lyric
import com.jayboat.ego.bean.SongList
import com.jayboat.ego.ui.widget.STATE_PLAYING
import com.jayboat.ego.utils.*
import invisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_buttons.*
import kotlinx.android.synthetic.main.include_disc.*
import kotlinx.android.synthetic.main.include_disc.view.*
import kotlinx.android.synthetic.main.include_lyrics.view.*
import kotlinx.android.synthetic.main.include_toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import screenWidth
import visible

class MainActivity : BaseActivity() {

    private var x1 = 0f
    private var x2 = 0f
    private var isPicture = true
    private var isExpand = false
    private var currentPosition = 0
    private var currentList: SongList? = null
    //    index为0表示当前状态和对应的drawableId
    //    根据目前的进行更改……
    private val moods = mutableListOf("happy", "unhappy", "clam", "exciting")
    private val moodsRes = mutableListOf(R.drawable.ic_smile, R.drawable.ic_unhappy, R.drawable.ic_clam, R.drawable.ic_exciting)
    private val animator by lazy {
        ObjectAnimator.ofFloat(fl_container, "alpha", 1f, 0f, 1f)
                .apply {
                    duration = 2500
                    interpolator = LinearInterpolator()
                }
    }
    private val discView by lazy { View.inflate(this, R.layout.include_disc, null) }
    private val lyricView by lazy { View.inflate(this, R.layout.include_lyrics, null) }

    private val TAG = "MainActivity"

//  *注：假如说要从其他的页面跳转到本页播放需要更换currentList&&currentPosition*

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        initMusicList()
        initPosition()
    }

    private fun initView() {
        tb_common.apply {
            setNavigationIcon(R.drawable.ic_setting)
            setNavigationOnClickListener {
                if (!dl_main.isDrawerOpen(nv_setting)) {
                    dl_main.openDrawer(nv_setting)
                }
            }
        }
        dl_main.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        fl_container.addView(discView)
        fl_container.setOnClickListener { changeView() }

        discView.dim_playing.setBackgroundView(discView.sv_dic)
        discView.dim_playing.playDisk()

        ibtn_more.setOnClickListener {
            currentList ?: return@setOnClickListener
            startMusicDetailActivity(this@MainActivity, currentList!!.result, currentPosition)
        }

        iv_current.setOnClickListener { changeMood() }

//      todo：前往不同的页面
        nv_setting.setNavigationItemSelectedListener {
            when (it.title) {
                resources.getString(R.string.daily_recommend) -> {
                    startActivity(Intent(this@MainActivity, RecommendActivity::class.java))
                }
                resources.getString(R.string.setting) -> {
                }
                resources.getString(R.string.comments_plaza) -> {
                }
                resources.getString(R.string.my_collection) -> Unit
            }
            true
        }
    }

    private fun initMusicList() {
//      如果当前在音乐控制器的地方有list的存储，就认为不需要第一次加载数据了，直接拿这个Controller的做显示
//      如果没有播放默认是最开始的
//      不过突然开始纠结这里的逻辑，例如这个Activity是否会被finish掉，就先没写了（理直气壮
        if (currentList == null) {
            currentList = happyMusicList
        }
    }

    private fun initPosition() {
        currentPosition = (Math.random() * currentList!!.result.trackCount).toInt()
        musicControlBinder?.setMusicList(currentList!!)
        val currentMusic = currentList!!.result.tracks[currentPosition]
        initMusicData(currentMusic)
    }

    //  emmm..还没想好这个怎么本地怎么操作，drawable的sp好麻烦啊（
    private fun initMusicData(currentMusic: SongList.ResultBean.TracksBean) {
        lyricView.lrc_main.setLabel("加载歌词中...")
//        val music = getBeanFromSP(currentMusic.name,SimpleMusic::class.java,moods[0])
        Glide.with(this@MainActivity)
                .load(currentMusic.album.picUrl)
                .into(object : SimpleTarget<Drawable>() {
                    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                        discView.dim_playing.stateChanged(resource)
                    }
                })
        musicControlBinder?.playMusic(currentPosition)
        discView.tv_name_song.text = currentMusic.name
        var info = StringBuilder()
        repeat(currentMusic.artists.size) {
            info.append(currentMusic.artists[it].name)
            info.append("/")
        }
        info = StringBuilder(info.substring(0, info.length - 1))
        discView.tv_name_singer.text = info.toString()

        NetUtils.getLyric(currentMusic.id, object : Callback<Lyric> {
            override fun onFailure(call: Call<Lyric>, t: Throwable) {
                ToastUtils.show("暂未获取数据:>")
                lyricView.lrc_main.setLabel("暂时没有歌词呢:(")
            }

            override fun onResponse(call: Call<Lyric>, response: Response<Lyric>) {
                if (response.body() != null) {
                    if (response.body()!!.lrc != null) {
                        Log.i(TAG, response.body()!!.lrc.lyric)
                        lyricView.lrc_main.loadLrc(response.body()!!.lrc.lyric)
                    } else {
                        lyricView.lrc_main.loadLrc("暂无歌词:<")
                    }
                } else {
                    ToastUtils.show("暂未获取数据:>")
                    lyricView.lrc_main.loadLrc("暂时没有歌词呢:(")
                }
            }

        })
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
        when (index) {
            1 -> iv_bottom.setImageDrawable(ContextCompat.getDrawable(this, moodsRes[1]))
            2 -> iv_center.setImageDrawable(ContextCompat.getDrawable(this, moodsRes[2]))
            3 -> iv_top.setImageDrawable(ContextCompat.getDrawable(this, moodsRes[3]))
        }
        iv_current.setImageDrawable(ContextCompat.getDrawable(this, moodsRes[0]))
        currentList = when (moods[0]) {
            "happy" -> happyMusicList
            "unhappy" -> unhappyMusicList
            "clam" -> clamMusicList
            else -> excitingMusicList
        }
        changeMood()
        initMusicList()
        initPosition()
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
        currentPosition += 1
        if (currentPosition == currentList!!.result.trackCount) {
            currentPosition = 0
        }
        if (currentList != null) {
            val currentMusic = currentList!!.result.tracks[currentPosition]
            initMusicData(currentMusic)
        } else {
            initMusicList()
        }
    }

    //      前往前一首歌
    private fun toPreviousMusic() {
        currentPosition -= 1
        if (currentPosition == -1) {
            currentPosition = currentList!!.result.trackCount - 1
        }
        if (currentList != null) {
            val currentMusic = currentList!!.result.tracks[currentPosition]
            initMusicData(currentMusic)
        } else {
            initMusicList()
        }
    }

    override fun onMusicStart() = Unit

    override fun onMusicPause() {
        dim_playing.currentState = STATE_PLAYING
        discView.dim_playing.playDisk()
    }

    override fun onMusicStop() {
        discView.dim_playing.stopDisk()
    }

    override fun onProgressUpdate(progress: Float) {
        lyricView.lrc_main.updateTime((musicControlBinder?.getDuration()!! * progress).toLong())
        if (progress > 0.995) {
            toNextMusic()
        }
    }

    override fun onMusicSelect(pos: Int) = Unit

    override fun onMusicListChange() = Unit
}

