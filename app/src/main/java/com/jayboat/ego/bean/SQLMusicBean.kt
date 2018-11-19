package com.jayboat.ego.bean

import com.jayboat.ego.net.Mood
import java.util.*

data class SQLMusicBean(
        val id: Long,
        var name: String,
        var imgUrl: String,
        var artistsName: String,
        var starDate: Date = Date(),
        var category: String = "",
        var mood: Mood = Mood.HAPPY
)