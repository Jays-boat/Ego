package com.jayboat.ego.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jayboat.ego.R
import com.jayboat.ego.ui.adapter.RankAdapter
import kotlinx.android.synthetic.main.activity_music_rank.*
import kotlinx.android.synthetic.main.include_toolbar.*

class MusicRankActivity : BaseActivity() {

    private lateinit var mAdapter: RankAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_rank)
        tb_common.apply {
            setNavigationIcon(R.drawable.ic_back)
            setNavigationOnClickListener {
                finish()
            }
        }

//      获取日推名单的list，填充之后交给rv复现
        var rankList = mutableListOf<String>()
        mAdapter = RankAdapter(rankList)
        rv_rank.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@MusicRankActivity)
        }
    }


    override fun onMusicStart() = Unit
    override fun onMusicPause() = Unit
    override fun onMusicStop() = Unit
    override fun onProgressUpdate(progress: Float) = Unit
    override fun onMusicSelect(pos: Int) = Unit
    override fun onMusicListChange() = Unit
}
