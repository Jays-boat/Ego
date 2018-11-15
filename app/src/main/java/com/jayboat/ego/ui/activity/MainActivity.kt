package com.jayboat.ego.ui.activity

import android.animation.ObjectAnimator
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.LinearInterpolator
import clamId
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.jayboat.ego.R
import com.jayboat.ego.bean.Lyric
import com.jayboat.ego.bean.SongList
import com.jayboat.ego.utils.NetUtils
import com.jayboat.ego.utils.ToastUtils
import com.jayboat.ego.utils.startMusicDetailActivity
import excitingId
import happyId
import invisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_buttons.*
import kotlinx.android.synthetic.main.include_disc.view.*
import kotlinx.android.synthetic.main.include_lyrics.view.*
import kotlinx.android.synthetic.main.include_toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import screenWidth
import unhappyId
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

//    这里拉取还有点问题（深夜写代码容易zz，明天看一下咋个改
    private val happyMusicList = getList(happyId)
    private val excitingMusicList = getList(excitingId)
    private val unhappyMusicList = getList(unhappyId)
    private val clamMusicList= getList(clamId)

    private val TAG = "MainActivity"

    private fun getList(id: Long): SongList? {
        var list : SongList? = null
        NetUtils.getMusicList(id, object : Callback<SongList> {
            override fun onResponse(call: Call<SongList>, response: Response<SongList>) {
                if (response.body() != null) {
                    list = response.body()!!
                    currentList = response.body()!!
                    initPosition()
                } else {
                    ToastUtils.show("内容获取有误，请重试:(")
                    Log.v(TAG, response.errorBody()!!.toString() + "")
                }
            }

            override fun onFailure(call: Call<SongList>, t: Throwable) {
                ToastUtils.show("获取过程可能有点问题:(")
                Log.v(TAG, t.toString())
            }
        })
        return list
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        initMusicList()
    }

//    改一下。。最开始显示歌词页面+正在加载中。。
    private fun initView() {
        (include as Toolbar).apply {
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
    }

    private fun initMusicList() {
//      如果当前在音乐控制器的地方有list的存储，就认为不需要第一次加载数据了，直接拿这个Controller的做显示
//      如果没有播放默认是最开始的
//      不过突然开始纠结这里的逻辑，例如这个Activity是否会被finish掉，就先没写了（理直气壮
        if (currentList == null) {
            currentList = happyMusicList
        }
    }

    private fun initPosition(){
        currentPosition = (Math.random() * currentList!!.result.trackCount).toInt()
        musicControlBinder?.setMusicList(currentList!!)
        musicControlBinder?.playMusic(currentPosition)
        val currentMusic = currentList!!.result.tracks[currentPosition]
        initMusicData(currentMusic)
    }

    private fun initMusicData(currentMusic: SongList.ResultBean.TracksBean) {
        Glide.with(this@MainActivity)
                .load(currentMusic.album.picUrl)
                .into(object : SimpleTarget<Drawable>() {
                    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                        discView.dim_playing.stateChanged(resource)
                    }
                })
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
                    if (response.body()!!.lrc != null){
                        lyricView.lrc_main.loadLrc(response.body()!!.lrc.lyric)
                    } else {
                        ToastUtils.show("暂时没有歌词呢:<")
                    }
                } else {
                    ToastUtils.show("暂未获取数据:>")
                    lyricView.lrc_main.setLabel("暂时没有歌词呢:(")
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
        initMusicList()
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
        if (currentList != null) {
            val currentMusic = currentList!!.result.tracks[currentPosition]
            initMusicData(currentMusic)
            musicControlBinder?.playMusic(currentPosition)
        } else {
            initMusicList()
        }
    }

    //      前往前一首歌
    private fun toPreviousMusic() {
        currentPosition -= 1
        if (currentList != null) {
            val currentMusic = currentList!!.result.tracks[currentPosition]
            initMusicData(currentMusic)
            musicControlBinder?.playMusic(currentPosition)
        } else {
            initMusicList()
        }
    }

    override fun onMusicStart() = Unit

    override fun onMusicPause() = Unit

    override fun onMusicStop() = Unit

    override fun onProgressUpdate(progress: Float) {
        lyricView.lrc_main.updateTime((musicControlBinder?.getDuration()!! * progress).toLong())
    }

    override fun onMusicSelect(pos: Int) = Unit

    override fun onMusicListChange() = Unit
}

