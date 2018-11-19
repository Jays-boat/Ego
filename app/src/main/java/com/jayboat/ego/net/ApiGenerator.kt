package com.jayboat.ego.net

import com.jayboat.ego.net.service.EgoApiService
import com.jayboat.ego.net.service.MoeApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object ApiGenerator {

    private var moeRetrofit = Retrofit.Builder()
                .baseUrl("http://music.moe.tn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

    private var egoRetrofit = Retrofit.Builder()
                .baseUrl("http://ego.hosigus.tech/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

    fun getMoeApiService(): MoeApiService = moeRetrofit.create(MoeApiService::class.java)

    fun getEgoApiService(): EgoApiService = egoRetrofit.create(EgoApiService::class.java)

}