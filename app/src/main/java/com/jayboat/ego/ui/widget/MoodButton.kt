package com.jayboat.ego.ui.widget

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View.MeasureSpec.EXACTLY
import com.jayboat.ego.R
import invisible
import kotlinx.android.synthetic.main.include_buttons.view.*
import screenHeight
import screenWidth
import visible

val moods = mutableListOf("happy", "unhappy", "clam", "exciting")

class MoodButtons : ConstraintLayout {

    private var isExpand = false
    private lateinit var listener: OnCurrentMoodListener
    private val moodsRes = mutableListOf(R.drawable.ic_smile, R.drawable.ic_unhappy, R.drawable.ic_clam, R.drawable.ic_exciting)

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attr: AttributeSet?) : this(context, attr, 0)
    constructor(context: Context, attr: AttributeSet?, defStyleInt: Int) : super(context, attr, defStyleInt) {
        LayoutInflater.from(context).inflate(R.layout.include_buttons, this, true)
        iv_current.setOnClickListener {
            changeMood()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.makeMeasureSpec((55 / 375.0 * screenWidth).toInt(), EXACTLY)
        val height = MeasureSpec.makeMeasureSpec((225 / 667.0 * screenHeight).toInt(), EXACTLY)
        super.onMeasure(width, height)
    }

    private fun changeMood() {
        if (isExpand) {
            iv_center.invisible()
            iv_bottom.invisible()
            iv_top.invisible()
            iv_bg.invisible()
            isExpand = false
        } else {
            iv_center.visible()
            iv_bottom.visible()
            iv_top.visible()
            iv_bg.visible()
            isExpand = true
            iv_bottom.setOnClickListener { changeData(1) }
            iv_center.setOnClickListener { changeData(2) }
            iv_top.setOnClickListener { changeData(3) }
        }
    }

    private fun changeData(index: Int) {
        val temp = moods[index]
        moods[index] = moods[0]
        moods[0] = temp
        val tempRes = moodsRes[index]
        moodsRes[index] = moodsRes[0]
        moodsRes[0] = tempRes
        when (index) {
            1 -> iv_bottom.setImageDrawable(ContextCompat.getDrawable(context, moodsRes[1]))
            2 -> iv_center.setImageDrawable(ContextCompat.getDrawable(context, moodsRes[2]))
            3 -> iv_top.setImageDrawable(ContextCompat.getDrawable(context, moodsRes[3]))
        }
        this.iv_current.setImageDrawable(ContextCompat.getDrawable(context, moodsRes[0]))
        listener.currentMood(moods[0])
        changeMood()
    }

    fun changeToHappy() {
        repeat(4) { i ->
            if (moods[i] == "happy") {
                changeData(i)
                changeMood()
            }
        }
    }

    fun addListener(listener: OnCurrentMoodListener) {
        this.listener = listener
    }

    interface OnCurrentMoodListener {
        fun currentMood(mood: String)
    }
}
