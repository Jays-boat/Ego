package com.jayboat.ego.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.jayboat.ego.App

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
