package com.jayboat.ego.utils

import android.content.ContentValues
import com.jayboat.ego.App
import com.jayboat.ego.bean.SQLMusicBean
import com.jayboat.ego.bean.SongList
import com.jayboat.ego.net.Mood
import java.util.*

fun makeSqlMusicBean(music: SongList.ResultBean.TracksBean, category: String = "默认收藏", mood: Mood = Mood.HAPPY) =
        SQLMusicBean(music.id, music.name, music.album.picUrl, StringBuilder().let { sb ->
            music.artists.forEach { artist ->
                sb.append(artist.name).append("/")
            }
            sb.substring(0, sb.length - 1)
        }.toString(), Date(), category, mood)

fun saveLike(bean: SQLMusicBean, like: Boolean = true) {
    updateMusicState(bean, ContentValues().apply { put("like", 1.takeIf { like } ?: 0) })
}

fun saveStar(bean: SQLMusicBean, star: Boolean = true) {
    updateMusicState(bean, ContentValues().apply {
        put("star", 1.takeIf { star } ?: 0)
        put("star_date", bean.starDate.time)
        put("category", bean.category)
        put("mood", bean.mood.name)
    })
}

private fun updateMusicState(bean: SQLMusicBean, values: ContentValues) {
    App.getDatabase().apply {
        if (update("music_state", values, "id = ?", arrayOf(bean.id.toString())) == 0) {
            values.put("id", bean.id.toString())
            values.put("name", bean.name)
            values.put("img_url", bean.imgUrl)
            values.put("artists", bean.artistsName)
            insert("music_state", null, values)
        }
    }
}

fun isLikeMusic(id: Long) = selectMusicStatus(id,"like")

fun isStarMusic(id: Long) = selectMusicStatus(id, "star")

fun selectMusicStatus(id: Long, need: String): Boolean {
    val cursor = App.getDatabase().rawQuery("SELECT `like`,star FROM music_state WHERE id = ?", arrayOf(id.toString()))
    return if (cursor.moveToFirst()) {
        val r = cursor.getInt(cursor.getColumnIndex(need))
        cursor.close()
        r == 1
    } else {
        cursor.close()
        false
    }
}


fun selectLikes() = selectFromMusicStatus("`like`", arrayOf("1"))

fun selectStars() = selectFromMusicStatus("star", arrayOf("1"))

private fun selectFromMusicStatus(name: String, value: Array<String>): List<SQLMusicBean> {
    val resList = mutableListOf<SQLMusicBean>()
    val cursor = App.getDatabase().rawQuery(
            "SELECT * FROM music_state WHERE $name = ?", value)
    if (cursor.moveToFirst()) {
        do {
            resList.add(SQLMusicBean(
                    cursor.getLong(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("img_url")),
                    cursor.getString(cursor.getColumnIndex("artists")),
                    Date(cursor.getLong(cursor.getColumnIndex("star_date"))),
                    cursor.getString(cursor.getColumnIndex("category")),
                    Mood.valueOf(cursor.getString(cursor.getColumnIndex("mood")))
            ))
        } while (cursor.moveToNext())
    }
    cursor.close()
    return resList
}

fun saveCommend(bean: SQLMusicBean, commend: String) {
    val values = ContentValues()
    values.put("music_id", bean.id)
    values.put("commend", commend)

    App.getDatabase().apply {
        updateMusicState(bean, ContentValues().apply { put("name", bean.name) })
        insert("music_commend", null, values)
    }
}

fun delCommend(id: Int, commend: String) {
    App.getDatabase().execSQL("DELETE FROM music_commend WHERE music_id = ? AND commend = ?", arrayOf(id.toString(), commend))
}