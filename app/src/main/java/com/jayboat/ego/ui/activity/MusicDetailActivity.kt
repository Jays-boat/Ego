package com.jayboat.ego.ui.activity

import android.os.Bundle
import android.view.Menu
import com.bumptech.glide.Glide
import com.jayboat.ego.R
import com.jayboat.ego.bean.SongList
import com.jayboat.ego.utils.ToastUtils
import io.reactivex.android.schedulers.AndroidSchedulers

import kotlinx.android.synthetic.main.activity_music_detail.*
import java.util.concurrent.TimeUnit

class MusicDetailActivity : BaseActivity() {

    private lateinit var musicList: SongList.ResultBean

    private var curPos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_detail)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { finish() }

        curPos = intent.getIntExtra("pos", 0)

        iv_download.setOnClickListener {
            ToastUtils.show("下载中...")
            AndroidSchedulers.mainThread().scheduleDirect({ ToastUtils.show("下载完成") }, 10, TimeUnit.SECONDS)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onServiceConnected() {
        musicList = intent.getSerializableExtra("musicList") as SongList.ResultBean
        onMusicSelectChange()
    }

    private fun onMusicSelectChange() {
        musicList.tracks[curPos].let {
            tv_music_name.text = it.name
            tv_singer_name.text = StringBuilder().let { sb ->
                it.artists.forEach { artist ->
                    sb.append(artist.name).append("/")
                }
                sb.substring(0, sb.length - 1)
            }.toString()
            Glide.with(this).asBitmap().load(it.album.blurPicUrl).into(riv_music_img)
        }
    }

    override fun onMusicStart() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMusicPause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMusicStop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProgressUpdate(progress: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMusicSelect(pos: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMusicListChange() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
