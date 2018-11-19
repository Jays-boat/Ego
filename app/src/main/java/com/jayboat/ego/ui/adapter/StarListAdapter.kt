package com.jayboat.ego.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.jayboat.ego.App
import com.jayboat.ego.R
import com.jayboat.ego.bean.SQLMusicBean
import kotlinx.android.synthetic.main.item_star_rv_music.view.*

class StarListAdapter(private val musicList: List<SQLMusicBean>, private val onMusicSelect: (id: SQLMusicBean) -> Unit)
    : RecyclerView.Adapter<StarListAdapter.ViewHolder>() {

    private val g = Glide.with(App.getAppContext())
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
            ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_star_rv_music, p0, false))

    override fun getItemCount() = musicList.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val m = musicList[p1]
        p0.itemView.apply {
            g.load(m.imgUrl).into(riv_music_img)
            tv_music_name.text = m.name
            tv_singer_name.text = m.artistsName
            setOnClickListener {
                onMusicSelect(musicList[p1])
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}