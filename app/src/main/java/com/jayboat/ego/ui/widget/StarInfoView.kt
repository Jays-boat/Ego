package com.jayboat.ego.ui.widget

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import com.jayboat.ego.R
import com.jayboat.ego.net.Mood
import gone
import kotlinx.android.synthetic.main.view_star_info.view.*
import visible
import java.util.*

class StarInfoView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    init {
        LayoutInflater.from(context).inflate(R.layout.view_star_info, this, true)
        tv_cancel.setOnClickListener {
            gone()
        }
    }

    fun show(mood: Mood, end: (String) -> Unit) {
        visible()
        tv_date.text = Calendar.getInstance().let {
            "${it.get(Calendar.YEAR)}.${it.get(Calendar.MONTH)}.${it.get(Calendar.DAY_OF_MONTH)}"
        }
        iv_mood.setImageResource(
                when (mood) {
                    Mood.UNHAPPY -> R.drawable.ic_unhappy
                    Mood.CLAM -> R.drawable.ic_clam
                    Mood.EXCITING -> R.drawable.ic_exciting
                    Mood.HAPPY -> R.drawable.ic_smile
                }
        )
        tv_confirm.setOnClickListener {
            val input = input.editText?.text.toString()
            if (input.isBlank()) {
                end("默认收藏")
            } else {
                end(input)
            }
            gone()
        }
        tv_skip.setOnClickListener {
            end("默认收藏")
            gone()
        }
    }
}