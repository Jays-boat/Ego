package com.jayboat.ego.ui.activity

import android.os.Bundle
import com.jayboat.ego.R

class RecommendActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)
    }

    override fun onMusicStart() = Unit
    override fun onMusicPause() = Unit
    override fun onMusicStop() = Unit
    override fun onProgressUpdate(progress: Float) = Unit
    override fun onMusicSelect(pos: Int) = Unit
    override fun onMusicListChange() = Unit
}
