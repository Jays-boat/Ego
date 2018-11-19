package com.jayboat.ego.bean

import com.google.gson.annotations.SerializedName

data class ID(@SerializedName("id")
                val id: Long = 0)
data class Version(@SerializedName("version")
                   val version: String)