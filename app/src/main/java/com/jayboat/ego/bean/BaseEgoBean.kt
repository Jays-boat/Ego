package com.jayboat.ego.bean

import com.google.gson.annotations.SerializedName

data class BaseEgoBean<T>(@SerializedName("data")
                          val data: T? = null,
                          @SerializedName("message")
                          val message: String = "",
                          @SerializedName("status")
                          val status: Int = 200)