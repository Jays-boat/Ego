package com.jayboat.ego.ui.adapter

import android.support.v7.widget.RecyclerView
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.jayboat.ego.R
import com.jayboat.ego.bean.SQLMusicBean
import kotlinx.android.synthetic.main.item_star_music.view.*
import kotlinx.android.synthetic.main.item_star_rv.view.*
import kotlinx.android.synthetic.main.item_star_title.view.*

class StarListAdapter(dataList: List<SQLMusicBean>, private val onMusicSelect: (id: SQLMusicBean) -> Unit)
    : RecyclerView.Adapter<StarListAdapter.ViewHolder>() {
    private class ListData(
            val date: String,
            val stars: Map<String, List<SQLMusicBean>>
    )

    private val comparator = Comparator<String> { s1, s2 ->
        if (s1 == "默认收藏") {
            return@Comparator 1
        } else if (s2 == "默认收藏") {
            return@Comparator -1
        }
        return@Comparator s1.compareTo(s2)
    }

    private val musicList: List<ListData> =
            dataList.groupBy { DateFormat.format("yyyy.MM.dd", it.starDate).toString() }
                    .map {
                        ListData(
                                it.key,
                                it.value.groupBy { d -> d.category }
                                        .toSortedMap(comparator)
                        )
                    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
            ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_star_rv, p0, false))

    override fun getItemCount() = musicList.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        musicList[p1].apply {
            p0.itemView.initView(date, stars)
        }
    }

    private fun View.initView(date: String, stars: Map<String, List<SQLMusicBean>>) {
        ll_container.apply {
            if (childCount > 1) {
                val view = getChildAt(0)
                removeAllViews()
                addView(view)
            }
        }

        tv_date.text = date
        val inflater = LayoutInflater.from(context)
        val g = Glide.with(context)

        stars.forEach { (describe, list) ->
            ll_container.addView(inflater.inflate(R.layout.item_star_title, ll_container, false).apply {
                tv_describe.text = describe
            })
            list.forEach {
                ll_container.addView(inflater.inflate(R.layout.item_star_music, ll_container, false).apply {
                    g.load(it.imgUrl).into(riv_music_img)
                    tv_music_name.text = it.name
                    tv_singer_name.text = it.artistsName
                    setOnClickListener { _ ->
                        onMusicSelect(it)
                    }
                })
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}