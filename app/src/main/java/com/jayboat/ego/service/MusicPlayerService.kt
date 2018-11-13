package com.jayboat.ego.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.jayboat.ego.App
import com.jayboat.ego.bean.SongList
import com.jayboat.ego.utils.MyMediaPlayer
import java.io.IOException

/**
 * Created by Hosigus on 2018/7/27.
 */
class MusicPlayerService : Service() {

    private var playingMusicIndicator = 0

    private val mMediaPlayer by lazy {
        val temp = MyMediaPlayer()
        temp.onStartListener = {
            for (listener in listeners) {
                listener.onMusicStart()
            }
        }
        temp.onPauseListener = {
            for (listener in listeners) {
                listener.onMusicPause()
            }
        }
        temp.onStopListener = {
            for (listener in listeners) {
                listener.onMusicStop()
            }
        }
        temp.onProgressUpdateListener = {
            for (listener in listeners) {
                listener.onProgressUpdate(it)
            }
        }
        return@lazy temp
    }

    private val mMusicControlBinder by lazy { MusicControlBinder() }

    private val listeners by lazy{ mutableListOf<MusicPlayerListener>()}

    private var mMusicList: SongList.ResultBean? = null

    override fun onBind(intent: Intent?): IBinder {
        return mMusicControlBinder
    }

    override fun onDestroy() {
        mMediaPlayer.release()
        super.onDestroy()
    }

    inner class MusicControlBinder : Binder() {

        fun pause() {
            mMediaPlayer.pause()
        }

        fun play() {
            if (mMediaPlayer.isPause()) {
                mMediaPlayer.start()
            } else {
                playMusic(playingMusicIndicator)
            }
        }

        fun stop() {
            mMediaPlayer.stop()
        }

        fun seekTo(pos: Float) {
            mMediaPlayer.pause()
            mMediaPlayer.seekTo((pos * getDuration()).toInt())
            mMediaPlayer.start()
        }

        fun setMusicList(musicList: SongList) {
            mMusicList = musicList.result
            mMediaPlayer.reset()
            playingMusicIndicator = 0
            for (listener in listeners) {
                listener.onMusicListChange()
            }
        }

        fun playMusic(pos: Int) {
            if (pos < mMusicList!!.trackCount) {
                playingMusicIndicator = pos
                try {
                    mMediaPlayer.reset()
                    mMediaPlayer.setDataSource(App.getProxy().getProxyUrl(
                            "http://music.163.com/song/media/outer/url?id=${mMusicList!!.tracks[pos].id}.mp3"))
                    mMediaPlayer.prepare()
                    mMediaPlayer.seekTo(0)
                    mMediaPlayer.start()
                    for (listener in listeners) {
                        listener.onMusicSelect(pos)
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }

        fun addListener(listener: MusicPlayerListener) {
            listeners.add(listener)
        }

        fun removeListener(listener: MusicPlayerListener) {
            listeners.remove(listener)
        }

        fun getMusicList() = mMusicList

        fun getDuration() = mMediaPlayer.duration

        fun getStatus() = mMediaPlayer.getFlag()
    }

    interface MusicPlayerListener {
        fun onMusicStart()
        fun onMusicPause()
        fun onMusicStop()
        fun onProgressUpdate(progress: Float)
        fun onMusicSelect(pos: Int)
        fun onMusicListChange()
    }
}