package com.jayboat.ego.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.jayboat.ego.R
import com.jayboat.ego.bean.SQLMusicBean
import com.jayboat.ego.bean.SongList
import com.jayboat.ego.net.Mood
import com.jayboat.ego.ui.adapter.StarListAdapter
import com.jayboat.ego.utils.selectStars
import com.jayboat.ego.utils.startMusicDetailActivity
import kotlinx.android.synthetic.main.activity_star_list.*
import kotlinx.android.synthetic.main.include_backbar.*
import kotlinx.android.synthetic.main.include_buttons.*

class StarListActivity : BaseActivity() {

    private val onMusicSelect: (SQLMusicBean) -> Unit = {
        musicControlBinder?.apply {
            //todo 播放单独音乐的逻辑有问题，没整，顶替一个名字算了
            val pos = ((getMusicList()?.trackCount ?: 0) * Math.random()).toInt()
            getMusicList()?.tracks?.get(pos)?.apply {
                id = id
                name = it.name
                artists.clear()
                artists.add(SongList.ResultBean.TracksBean.ArtistsBeanX().let { singer ->
                    singer.name = it.artistsName
                    singer
                })
                album.blurPicUrl = it.imgUrl
            }
            playMusic(pos)
        }
    }

    private var moodPos = intent.getIntExtra("moonPos", 0)

    private val musicMap = selectStars().groupBy { it.mood }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_star_list)

        val tb = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(tb)
        title = ""
        tb.setNavigationOnClickListener { finish() }
        toolbar_title.text = "我的收藏"

        rv_star_main.layoutManager = LinearLayoutManager(this)
        rv_star_main.adapter = StarListAdapter(musicMap[Mood.values()[moodPos]]
                ?: listOf(), onMusicSelect)
        iv_more.setOnClickListener {
            startMusicDetailActivity(this@StarListActivity, moodPos)
        }
        iv_current.setOnClickListener {
            //todo 心情
            //换了心情回调: changeMood(pos: Int)//pos是Mood类的
        }
    }

    private fun changeMood(pos: Int) {
        moodPos = pos
        rv_star_main.adapter = StarListAdapter(musicMap[Mood.values()[moodPos]]
                ?: listOf(), onMusicSelect)
    }
}
