package com.jayboat.ego.ui.activity

import android.os.Bundle
import com.jayboat.ego.R

import kotlinx.android.synthetic.main.activity_music_detail.*

class MusicDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_detail)
        setSupportActionBar(toolbar)

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
