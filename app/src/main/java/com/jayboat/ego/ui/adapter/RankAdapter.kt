package com.jayboat.ego.ui.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jayboat.ego.R
import kotlinx.android.synthetic.main.recycle_item_rank.view.*

class RankAdapter(var rankList:MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_HEAD = -1
    private val TYPE_BODY = 0

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_HEAD else TYPE_BODY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_HEAD) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_item_rank_top, parent, false)
            RankViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_item_rank, parent, false)
            RankViewHolder(view)
        }
    }

    override fun getItemCount() = rankList.size + 1

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0) return
        else {
            holder.itemView.apply {
                tv_rank.text = "0$position"
                tv_rank_name.text = rankList[position - 1]
                tv_rank_singer.text = rankList[position - 1]
                setOnClickListener {
//                   点击了之后根据音乐的信息跳转播放
                }
            }
        }
    }

    private inner class RankViewHolder(view: View) : RecyclerView.ViewHolder(view)
}