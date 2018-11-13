package com.jayboat.ego.bean

data class MusicStatus(
        var id: Int = -1,
        var isLike: Boolean = false,
        var isCollected: Boolean = false,
        var isDownloaded: Boolean = false,
        val commentList: MutableList<String> = mutableListOf()
)