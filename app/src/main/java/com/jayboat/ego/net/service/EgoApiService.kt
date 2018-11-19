package com.jayboat.ego.net.service

import com.jayboat.ego.bean.BaseEgoBean
import com.jayboat.ego.bean.ID
import com.jayboat.ego.bean.Version
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface EgoApiService {
    @GET("getSongListID.php")
    fun getSongListID(@Query("type") type: String): Observable<BaseEgoBean<ID>>
    @GET("getLastVersion.php")
    fun getLastVersion(): Observable<BaseEgoBean<Version>>
}