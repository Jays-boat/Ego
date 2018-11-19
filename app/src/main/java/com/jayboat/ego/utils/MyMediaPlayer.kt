package com.jayboat.ego.utils

import android.media.MediaPlayer
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

/**
 * Created by Hosigus on 2018/7/27.
 */
class MyMediaPlayer : MediaPlayer() {
    companion object {
        const val STATUS_PLAYING = 0
        const val STATUS_PAUSE = 1
        const val STATUS_STOP = 2
    }

    private var playStatusFlag = STATUS_STOP

    var onStartListener: (() -> Unit)? = null
    var onPauseListener: (() -> Unit)? = null
    var onStopListener: (() -> Unit)? = null
    var onProgressUpdateListener: ((progress: Int) -> Unit)? = null

    private val updateProgressRunnable = object :Runnable{
        override fun run() {
            if (isPlaying && onProgressUpdateListener != null) {
                onProgressUpdateListener!!.invoke(currentPosition)
                AndroidSchedulers.mainThread().scheduleDirect(this, 500, TimeUnit.MILLISECONDS)
            }
        }
    }

    override fun start() {
        super.start()
        playStatusFlag = STATUS_PLAYING
        onStartListener?.invoke()
        if (onProgressUpdateListener != null) {
            AndroidSchedulers.mainThread().scheduleDirect(updateProgressRunnable)
        }
    }

    override fun pause() {
        super.pause()
        playStatusFlag = STATUS_PAUSE
        onPauseListener?.invoke()
    }

    override fun stop() {
        super.stop()
        playStatusFlag = STATUS_STOP
        onStopListener?.invoke()
    }

    override fun reset() {
        super.reset()
        playStatusFlag = STATUS_STOP
    }

    fun isPause() = playStatusFlag == STATUS_PAUSE

    fun isStop() = playStatusFlag == STATUS_STOP

    fun getFlag() = playStatusFlag
}