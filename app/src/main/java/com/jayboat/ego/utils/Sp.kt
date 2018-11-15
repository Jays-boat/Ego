package com.jayboat.ego.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.jayboat.ego.App
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

val gson = Gson()

val defaultSp get() = App.getAppContext().sp("EgoDefault")

fun Context.sp(name: String): SharedPreferences = getSharedPreferences(name, Context.MODE_PRIVATE)

fun sp(name: String) = App.getAppContext().sp(name)

operator fun SharedPreferences.invoke(modify: SharedPreferences.Editor.() -> Unit) = edit().apply(modify).apply()

fun <T> getBeanFromSP(keyName: String, clazz: Class<T>, spName: String = "EgoDefault"): T? {
    try {
        return gson.fromJson(sp(spName).getString(keyName, null) ?: return null, clazz)
    } catch (e: Exception) {
        e.printStackTrace()
        return null
    }
}

fun <T> putBeanToSP(keyName: String, bean: T, spName: String = "EgoDefault") =
        sp(spName)() { putString(keyName, gson.toJson(bean)) }

fun <T> withSPCache(keyName: String, clazz: Class<T>, observable: () -> Observable<T>,
                    onGetBean: (T) -> Unit, fail: (Throwable) -> Unit = { it.printStackTrace() },
                    spName: String = "EgoDefault") =
        Observable.create<String> { it.onNext(sp(spName).getString(keyName, "") ?: "") }
                .doOnNext { json ->
                    observable()
                            .filter { gson.toJson(it) != json }
                            .doOnNext { putBeanToSP(keyName, it, spName) }
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(onGetBean, fail)
                }.map {
                    if (it.isNotBlank()) {
                        gson.fromJson(it, clazz)
                    } else {
                        null
                    }
                }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn { null }
                .subscribe({ it?.let(onGetBean) }, {
                    (it as? JsonSyntaxException) ?: (it as? NullPointerException) ?: fail(it)
                })
