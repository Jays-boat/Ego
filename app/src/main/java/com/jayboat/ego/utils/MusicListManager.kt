package com.jayboat.ego.utils

import android.util.Log
import com.jayboat.ego.bean.SongList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val happyId = 2091355034L
const val excitingId = 93073411L
const val unhappyId = 772031667L
const val clamId = 102563603L

private const val happyTAG = "happyMusic"
private const val unhappyTAG = "unhappyMusic"
private const val clamTAG = "clamMusic"
private const val excitingTAG = "excitingMusic"
private const val TAG = "MusicManager"

var happyMusicList: SongList? = null
var excitingMusicList: SongList? = null
var unhappyMusicList: SongList? = null
var clamMusicList: SongList? = null

fun getList(id: Long) {
//  如果缓存里面有就先从缓存里面进行读取
    var list: SongList? = checkData(id)
    if (list != null) {
        putList(id, list, false)
        return
    }
    NetUtils.getMusicList(id, object : Callback<SongList> {
        override fun onResponse(call: Call<SongList>, response: Response<SongList>) {
            if (response.body() != null) {
                list = response.body()!!
                putList(id, list!!, true)
            } else {
                ToastUtils.show("内容获取有误，请重试:(")
                Log.v(TAG, response.errorBody()!!.toString() + "")
            }
        }

        override fun onFailure(call: Call<SongList>, t: Throwable) {
            ToastUtils.show("获取过程可能有点问题:(")
            Log.v(TAG, t.toString())
        }
    })
}

private fun checkData(id: Long): SongList? {
    return when (id) {
        happyId -> getBeanFromSP("happyMusic", SongList::class.java)
        unhappyId -> getBeanFromSP("unhappyMusic", SongList::class.java)
        clamId -> getBeanFromSP("clamMusic", SongList::class.java)
        excitingId -> getBeanFromSP("excitingMusic", SongList::class.java)
        else -> null
    }
}

private fun putList(id: Long, list: SongList, isNeedSave: Boolean) {
    when (id) {
        happyId -> {
            happyMusicList = list
            if (isNeedSave) {
                putBeanToSP(happyTAG, list)
            }
        }
        unhappyId -> {
            unhappyMusicList = list
            if (isNeedSave) {
                putBeanToSP(unhappyTAG, list)
            }
        }
        clamId -> {
            clamMusicList = list
            if (isNeedSave) {
                putBeanToSP(clamTAG, list)
            }
        }
        excitingId -> {
            excitingMusicList = list
            if (isNeedSave) {
                putBeanToSP(excitingTAG, list)
            }
        }
    }
}