package com.jayboat.ego.utils

import android.content.ContentValues
import com.jayboat.ego.App

fun saveLike(id: Int, like: Boolean = true) {
    updateMusicState(id, "like", 1.takeIf { like } ?: 0)
}

fun saveStar(id: Int, star: Boolean = true) {
    updateMusicState(id, "star", 1.takeIf { star } ?: 0)
}

private fun updateMusicState(id: Int, name: String, value: Int) {
    val values = ContentValues()
    values.put(name, value)
    App.getDatabase().apply {
        if (update("music_state", values, "id = ?", arrayOf(id.toString())) == 0) {
            values.put("id", id.toString())
            insert("music_state", null, values)
        }
    }
}

fun saveCommend(id: Int, commend: String) {
    val values = ContentValues()
    values.put("music_id", id)
    values.put("commend", commend)
    App.getDatabase().insert(SQLHelper.NAME, null, values)
}

fun delCommend(id: Int, commend: String) {
    App.getDatabase().execSQL("DELETE FROM music_commend WHERE music_id = ? AND commend = ?", arrayOf(id.toString(), commend))
}