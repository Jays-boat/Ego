package com.jayboat.ego.ui.activity

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.widget.SeekBar
import com.bumptech.glide.Glide
import com.jayboat.ego.App
import com.jayboat.ego.R
import com.jayboat.ego.net.ApiGenerator
import com.jayboat.ego.net.Mood
import com.jayboat.ego.utils.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_music_detail.*
import kotlinx.android.synthetic.main.include_backbar.*
import safeSubscribeBy
import java.util.concurrent.TimeUnit

class MusicDetailActivity : BaseActivity() {

    private lateinit var mood: Mood

    private var curPos = 0

    private fun getMusicList() = mood.songList?.result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_detail)
        val tb = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(tb)
        title = ""
        tb.setNavigationOnClickListener { finish() }

        iv_download.setOnClickListener {
            ToastUtils.show("下载中...")
            AndroidSchedulers.mainThread().scheduleDirect({ ToastUtils.show("下载完成") }, 10, TimeUnit.SECONDS)
        }

        iv_play.setOnClickListener {
            if (musicControlBinder?.getStatus() == MyMediaPlayer.STATUS_PAUSE) {
                musicControlBinder?.play()
            } else {
                musicControlBinder?.pause()
            }
        }

        iv_move_back.setOnClickListener {
            musicControlBinder?.playMusic((if (curPos == 0) getMusicList()?.trackCount
                    ?: 1 else curPos) - 1)
        }
        iv_move_forward.setOnClickListener {
            musicControlBinder?.playMusic(if (curPos + 1 == getMusicList()?.trackCount) 0 else curPos + 1)
        }
        iv_like.setOnClickListener {_ ->
            getMusicList()?.tracks?.get(curPos)?.let {
                if (isLikeMusic(it.id)) {
                    saveLike(makeSqlMusicBean(it), false)
                    iv_like.setImageResource(R.drawable.ic_like_off)
                } else {
                    saveLike(makeSqlMusicBean(it), true)
                    iv_like.setImageResource(R.drawable.ic_like_on)
                }
            }
        }
        iv_star.setOnClickListener {_ ->
            getMusicList()?.tracks?.get(curPos)?.let {
                if (isStarMusic(it.id)) {
                    saveStar(makeSqlMusicBean(it), false)
                    iv_star.setImageResource(R.drawable.ic_star_off)
                } else {
                    saveStar(makeSqlMusicBean(it), true)
                    iv_star.setImageResource(R.drawable.ic_star_on)
                }
            }
        }

        bar_music.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    musicControlBinder?.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onServiceConnected() {
        mood = Mood.values()[intent.getIntExtra("moonPos", 0)]
        curPos = musicControlBinder?.getCurrentPostion() ?: 0
        initMusicInfo()
    }

    private fun initMusicInfo() {
        getMusicList()?.tracks?.get(curPos)?.let {
            bar_music.max = it.duration
            tv_max_time.text = formatTime(it.duration)

            toolbar_title.text = it.name
            tv_singer_name.text = StringBuilder().let { sb ->
                it.artists.forEach { artist ->
                    sb.append(artist.name).append("/")
                }
                sb.substring(0, sb.length - 1)
            }.toString()

            iv_like.setImageResource(if (isLikeMusic(it.id)) R.drawable.ic_like_on else R.drawable.ic_like_off)
            iv_star.setImageResource(if (isStarMusic(it.id)) R.drawable.ic_star_on else R.drawable.ic_star_off)

            Glide.with(App.getAppContext()).asBitmap().load(it.album.blurPicUrl).into(riv_music_img)
            ApiGenerator.getMoeApiService()
                    .getLyric(it.id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .safeSubscribeBy(onError = { e ->
                        Log.e("Music", e.toString())
                        ToastUtils.asyncShow("暂未获取数据:>")
                        lrc_detail.setLabel("暂时没有歌词呢:(")
                    }) { lyric ->
                        if (lyric.lrc != null) {
                            lrc_detail.loadLrc(lyric.lrc.lyric)
                        } else {
                            ToastUtils.show("暂时没有歌词呢:<")
                        }
                    }
        }
    }

    override fun onMusicStart() {
        iv_play.setImageResource(R.drawable.ic_play_running)
    }

    override fun onMusicPause() {
        iv_play.setImageResource(R.drawable.ic_play_pause)
    }

    override fun onMusicStop() {
        //todo
    }

    override fun onProgressUpdate(progress: Int) {
        bar_music.progress = progress
        lrc_detail.updateTime(progress.toLong())
        tv_cur_time.text = formatTime(progress)
    }

    override fun onMusicSelect(pos: Int) {
        curPos = pos
        initMusicInfo()
    }

    override fun onMusicListChange() {
        //todo 不可能改变啊
    }

    private fun formatTime(time: Int) = (time / 1000).let { "${it / 60}:${it % 60}" }
}
