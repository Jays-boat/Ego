package com.jayboat.ego.net

import com.jayboat.ego.bean.SongList

enum class Mood {
    HAPPY,UNHAPPY,CLAM,EXCITING;

    var songListId: Long = 0L
    var songList: SongList? = null
}