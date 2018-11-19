package com.jayboat.ego.utils

import android.content.Context
import android.content.Intent
import com.jayboat.ego.ui.activity.MusicDetailActivity
import com.jayboat.ego.ui.activity.StarListActivity

fun startMusicDetailActivity(context: Context, moonPos: Int) =
        context.startActivity(
                Intent(context, MusicDetailActivity::class.java)
                        .putExtra("moonPos", moonPos)
        )


fun startStarListActivity(context: Context, moonPos: Int) =
        context.startActivity(Intent(context, StarListActivity::class.java)
                .putExtra("moonPos", moonPos))

