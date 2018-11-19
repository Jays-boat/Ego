package com.jayboat.ego.utils

import com.jayboat.ego.bean.SongList
import com.jayboat.ego.net.ApiGenerator
import com.jayboat.ego.net.Mood
import io.reactivex.schedulers.Schedulers
import safeSubscribeBy

fun prepareSongList(onEnd: () -> Unit) {
    Schedulers.newThread().scheduleDirect {
        val ego = ApiGenerator.getEgoApiService()
        val moe = ApiGenerator.getMoeApiService()
        Mood.values().forEach {
            ego.getSongListID(it.name.toLowerCase())
                    .subscribeOn(Schedulers.io())
                    .safeSubscribeBy { bean ->
                        it.songListId = bean.data?.id ?: 2091355034L
                        it.songList = getBeanFromSP("song", SongList::class.java, it.name + it.songListId)
                        if (it.songList == null) {
                            moe.getSongList(it.songListId).safeSubscribeBy { r ->
                                if (r == null) {
                                    ToastUtils.asyncShow("服务器地址已更换，请更新到最新版本")
                                    return@safeSubscribeBy
                                }
                                it.songList = r
                            }
                        }
                        if (it == Mood.HAPPY) {
                            onEnd()
                        }
                    }
        }
    }
}

fun checkUpdate() {
    ApiGenerator.getEgoApiService().getLastVersion().subscribeOn(Schedulers.io()).subscribe {

    }
}