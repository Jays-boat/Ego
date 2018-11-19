package com.jayboat.ego.net.service

import com.jayboat.ego.bean.Lyric
import com.jayboat.ego.bean.SongList
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoeApiService {
    @GET("playlist/detail")
    fun getSongList(@Query("id") albumListId: Long): Observable<SongList>

    @GET("/lyric")
    fun getLyric(@Query("id") musicId: Long): Observable<Lyric>
}