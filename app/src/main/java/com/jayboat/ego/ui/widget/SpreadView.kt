package com.jayboat.ego.ui.widget

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import screenWidth

/*
 * Create by Cchanges on 2018/11/7
 */
class SpreadView : View {

    private var currentState = STATE_STOP
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private lateinit var background: Bitmap
    private lateinit var animator: ObjectAnimator
    private val TAG = "SpreadView"

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initPaint()
        initBackground()
        initAnimator()
    }

    private fun initPaint() {
        paint.apply {
            color = Color.parseColor("#C0D2F0")
            style = Paint.Style.STROKE
            strokeWidth = 2f
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMeasure = View.MeasureSpec.makeMeasureSpec(discSize.toInt(), MeasureSpec.EXACTLY)
        val heightMeasure = View.MeasureSpec.makeMeasureSpec(discSize.toInt(), MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasure, heightMeasure)
    }

    private fun initBackground() {
        background = Bitmap.createBitmap(discSize.toInt(), discSize.toInt(), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(background)
        canvas.drawCircle(discSize /2f, discSize/2f, picSize / 2f, paint)
    }

    private fun initAnimator() {
        val alphaValues = PropertyValuesHolder.ofFloat("alpha", 0f)
        val scaleXValues = PropertyValuesHolder.ofFloat("scaleX", screenWidth / discSize * 0.8f)
        val scaleYValues = PropertyValuesHolder.ofFloat("scaleY", screenWidth / discSize * 0.8f)
        animator = ObjectAnimator.ofPropertyValuesHolder(this, alphaValues, scaleXValues, scaleYValues)
        animator.apply {
            duration = 1000
            interpolator = LinearInterpolator()
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.RESTART
        }
    }

    fun stateChanged() {
        when (currentState) {
            STATE_STOP -> {
                animator.start()//动画开始
                currentState = STATE_PLAYING
            }
            STATE_PAUSE -> {
                animator.resume()//动画重新开始
                currentState = STATE_PLAYING
            }
            STATE_PLAYING -> {
                animator.pause()//动画暂停
                currentState = STATE_PAUSE
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(background, 0f, 0f, null)
    }

    fun disappear(){
        ObjectAnimator.ofFloat(this,"alpha",1f,0f)
                .apply {
                    duration = 1500
                    start()
                }
        this.visibility = GONE
    }

    fun show(){
        this.visibility = View.VISIBLE
        ObjectAnimator.ofFloat(this,"alpha",0f,1f)
                .apply {
                    duration = 1500
                    start()
                }
    }
}