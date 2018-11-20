package com.jayboat.ego.ui.activity

import android.animation.Animator
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.jayboat.ego.R
import com.jayboat.ego.bean.Lyric
import com.jayboat.ego.bean.SongList
import com.jayboat.ego.net.Mood
import com.jayboat.ego.ui.widget.MoodButtons
import com.jayboat.ego.ui.widget.STATE_PLAYING
import com.jayboat.ego.ui.widget.moods
import com.jayboat.ego.utils.NetUtils
import com.jayboat.ego.utils.ToastUtils
import com.jayboat.ego.utils.startMusicDetailActivity
import com.jayboat.ego.utils.startStarListActivity
import gone
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_card.view.*
import kotlinx.android.synthetic.main.include_disc.view.*
import kotlinx.android.synthetic.main.include_lyrics.view.*
import kotlinx.android.synthetic.main.include_toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import screenHeight
import screenWidth

class MainActivity : BaseActivity(), MoodButtons.OnCurrentMoodListener{

    private var x1 = 0f
    private var x2 = 0f
    private var isPicture = true
    private var isCommendShow = false
    private var isDialogShow = false
    private var showTime = 0.0
    private var unhappyTimes = 0
    private var currentPosition = 0
    private var currentList: SongList? = null
    override val needSlide: Boolean
        get() = false
    //    index为0表示当前状态和对应的drawableId
    //    根据目前的进行更改……
    private val animator by lazy {
        ObjectAnimator.ofFloat(fl_container, "alpha", 1f, 0f, 1f)
                .apply {
                    duration = 1500
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
        findViewById<Toolbar>(R.id.tb_common).apply {
            setNavigationIcon(R.drawable.ic_setting)
            setNavigationOnClickListener {
                if (!this@MainActivity.dl_main.isDrawerOpen(this@MainActivity.nv_setting)) {
                    this@MainActivity.dl_main.openDrawer(this@MainActivity.nv_setting)
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
            startMusicDetailActivity(this@MainActivity, Mood.valueOf(moods[0].toUpperCase()).ordinal)
        }

        btn_moods.apply {
            addListener(this@MainActivity)
            setOnClickListener {
                Log.i(TAG,"Touched")
            }
        }

//      todo：前往不同的页面
        nv_setting.setNavigationItemSelectedListener {
            when (it.title) {
                resources.getString(R.string.daily_recommend) -> {
//                    startActivity(Intent(this@MainActivity, RecommendActivity::class.java))
                }
                resources.getString(R.string.setting) -> {
                }
                resources.getString(R.string.comments_plaza) -> {
                }
                resources.getString(R.string.my_collection) -> startStarListActivity(this@MainActivity, Mood.valueOf(moods[0].toUpperCase()).ordinal)
            }
            true
        }
    }

    private fun initMusicList() {
        if (currentList == null) {
            currentList = Mood.HAPPY.songList
        }
    }

    private fun initPosition() {
        currentList?.let {
            currentPosition = (Math.random() * (it.result?.trackCount ?: 0)).toInt()
            musicControlBinder?.setMusicList(it)
            initMusicData(it.result.tracks[currentPosition])
        }
    }


    private fun initMusicData(currentMusic: SongList.ResultBean.TracksBean) {
        lyricView.lrc_main.setLabel("加载歌词中...")
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

    override fun currentMood(mood: String) {
        currentList = when (mood) {
            "happy" -> Mood.HAPPY.songList
            "unhappy" -> Mood.UNHAPPY.songList
            "clam" -> Mood.CLAM.songList
            else -> Mood.EXCITING.songList
        }
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

    override fun onMusicStart() {
        Log.i(TAG,"mood:${moods[0]}")
        isCommendShow = (Math.random() + 0.5).toInt() == 1
        if (isCommendShow) {
            showTime = Math.random() * 0.01 + 0.03
        }
        if (unhappyTimes > 2 && Mood.valueOf(moods[0].toUpperCase()) == Mood.UNHAPPY && !isDialogShow) {
            val view = View.inflate(this, R.layout.include_card, null).apply {
                tv_card_text.text = "还是很沮丧吗？来点开心的吧！"
                btn_card_sure.setOnClickListener {
                    repeat(4) { i ->
                        if (moods[i] == "happy") {
                            btn_moods.changeToHappy()
                            this@MainActivity.dl_main.removeView(this)
                        }
                    }
                }
                btn_card_cancel.setOnClickListener {
                    this@MainActivity.dl_main.removeView(this)
                }
            }
            val param = FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                setMargins((45/375.0 * screenWidth).toInt(),
                        (440/667.0 * screenHeight).toInt(),
                        (45/375.0 * screenWidth).toInt(),
                        (100/667.0 * screenHeight).toInt())
            }
            this@MainActivity.dl_main.addView(view, param)
            isDialogShow = true
        }
        if (Mood.valueOf(moods[0].toUpperCase()) == Mood.UNHAPPY) {
            unhappyTimes += 1
        }
    }

    override fun onMusicPause() {
        discView.dim_playing.currentState = STATE_PLAYING
        discView.dim_playing.playDisk()
    }

    override fun onMusicStop() {
        discView.dim_playing.stopDisk()
    }

    @SuppressLint("SetTextI18n")
    override fun onProgressUpdate(progress: Int) {
        lyricView.lrc_main.updateTime(progress.toLong())
        var view: View? = null
        if (progress.toDouble() > 0.995 * (musicControlBinder?.getDuration() ?: 1)) {
            toNextMusic()
        }
        if (isCommendShow && progress.toDouble() > showTime * (musicControlBinder?.getDuration()
                        ?: 1)) {
            val time = (Math.random() * 10 + 2).toInt()
            view = View.inflate(this, R.layout.include_card, null).apply {
                btn_card_cancel.gone()
                btn_card_sure.gone()
                tv_card_text.text = "在${time}分钟前，有人发表了评论"
                ObjectAnimator.ofFloat(this, "alpha", 1f, 0f).apply {
                    duration = 5000
                    start()
                    addListener(object : Animator.AnimatorListener {
                        override fun onAnimationEnd(animation: Animator?) = this@MainActivity.dl_main.removeView(view)
                        override fun onAnimationRepeat(animation: Animator?) = Unit
                        override fun onAnimationCancel(animation: Animator?) = Unit
                        override fun onAnimationStart(animation: Animator?) = Unit
                    })
                }
            }
            val param = FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                setMargins((45/375.0 * screenWidth).toInt(),
                        (37/667.0 * screenHeight).toInt(),
                        (45/375.0 * screenWidth).toInt(),
                        (557/667.0 * screenHeight).toInt())
            }
            this@MainActivity.dl_main.addView(view, param)
            isCommendShow = false
        }
    }

    override fun onMusicSelect(pos: Int) {
        if (currentPosition == pos) return
        currentPosition = pos
        currentList?.let {
            initMusicData(it.result.tracks[currentPosition])
        }
    }

    override fun onMusicListChange() = Unit
}

