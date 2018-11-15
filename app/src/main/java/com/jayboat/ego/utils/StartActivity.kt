package com.jayboat.ego.utils

import android.content.Context
import android.content.Intent
import com.jayboat.ego.bean.SongList
import com.jayboat.ego.ui.activity.MusicDetailActivity

fun startMusicDetailActivity(context: Context, musicList: SongList.ResultBean, pos: Int) {
    context.startActivity(
            Intent(context, MusicDetailActivity::class.java)
                    .putExtra("musicList", musicList)
                    .putExtra("pos", pos)
    )
}