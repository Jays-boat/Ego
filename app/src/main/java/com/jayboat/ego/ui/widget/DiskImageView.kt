package com.jayboat.ego.ui.widget

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.view.View
import android.view.View.MeasureSpec.EXACTLY
import android.view.animation.LinearInterpolator
import com.jayboat.ego.R
import screenWidth

/*
 * Create by Cchanges on 2018/11/6
 */
const val STATE_PLAYING = 1
const val STATE_PAUSE = 2
const val STATE_STOP = 3

class DiskImageView : AppCompatImageView {

    var currentState = STATE_STOP
    private var disk: Bitmap
    private lateinit var backgroundView: SpreadView
    private lateinit var upPicture: Drawable
    private lateinit var animator: ObjectAnimator
    private val TAG = "DiskImageView"

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initAttrs(attrs)
        initAnimator()
        disk = initDisc()
    }

    private fun initAttrs(attrs: AttributeSet?) {
        val array = context.obtainStyledAttributes(attrs, R.styleable.DiskImageView)
        val resId = array.getResourceId(R.styleable.DiskImageView_div_src, -1)
        upPicture = if (resId == -1) {
            ContextCompat.getDrawable(context, R.drawable.ic_default_bottom_music_icon)!!
        } else {
            ContextCompat.getDrawable(context, resId)!!
        }
        array.recycle()
    }

    private fun initAnimator() {
        animator = ObjectAnimator.ofFloat(this, "rotation", 0f, 360f)
        animator.apply {
            duration = 10000
            interpolator = LinearInterpolator()
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.RESTART
        }
    }

    private fun initDisc(): Bitmap {
        val cropBitmap: Bitmap
        val tempBitmap: Bitmap
        val up = (upPicture as BitmapDrawable).bitmap
        val bmpHeight = up.height
        val bmpWidth = up.width
        var cropLength: Int
        val x: Int
        val y: Int
        val diameter = picSize.toInt()
        val mStrokeWidth = (discSize - picSize) / 2f

        when {
            bmpHeight > bmpWidth -> {
                cropLength = bmpWidth
                x = 0
                y = (bmpHeight - bmpWidth) / 2
                tempBitmap = Bitmap.createBitmap(up, x, y, cropLength, cropLength)
            }
            bmpHeight < bmpWidth -> {
                cropLength = bmpHeight
                x = (bmpWidth - bmpHeight) / 2
                y = 0
                tempBitmap = Bitmap.createBitmap(up, x, y, cropLength, cropLength)
            }
            else -> tempBitmap = up
        }

        cropBitmap = if (tempBitmap.width != diameter || tempBitmap.height != diameter) {
            Bitmap.createScaledBitmap(tempBitmap, diameter, diameter, true)
        } else {
            tempBitmap
        }

        cropLength = cropBitmap.height
        val output = Bitmap.createBitmap((cropLength + mStrokeWidth * 2).toInt(), (cropLength + mStrokeWidth * 2).toInt(), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            shader = BitmapShader(cropBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        }

        canvas.drawCircle(((cropLength + mStrokeWidth * 2) / 2f), ((cropLength + mStrokeWidth * 2) / 2f), (cropLength / 2f - mStrokeWidth / 2f), paint)

        val mBackgroundPaint = Paint().apply {
            isAntiAlias = true
            style = Paint.Style.STROKE
            color = Color.parseColor("#C0D2F0")
            strokeWidth = mStrokeWidth
        }
        canvas.drawCircle(((cropLength + mStrokeWidth * 2) / 2f), ((cropLength + mStrokeWidth * 2) / 2f), (cropLength / 2f), mBackgroundPaint)
        return output
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMeasure = View.MeasureSpec.makeMeasureSpec(discSize.toInt(), EXACTLY)
        val heightMeasure = View.MeasureSpec.makeMeasureSpec(discSize.toInt(), EXACTLY)
        super.onMeasure(widthMeasure, heightMeasure)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val left = if (width - discSize <= 0) 0 else ((width - discSize) / 2).toInt()
        val top = if (height - discSize <= 0) 0 else ((height - discSize) / 2).toInt()
        canvas.drawBitmap(disk, left.toFloat(), top.toFloat(), null)
    }

    private fun setUpPicture(drawable: Drawable) {
        upPicture = drawable
        disk = initDisc()
        postInvalidate()
    }

    fun setBackgroundView(background: SpreadView) {
        backgroundView = background
    }

    fun stateChanged(drawableRes:Drawable) {
        var isUpdate = false
        ObjectAnimator.ofFloat(this, "alpha", 1f, 0f, 1f)
                .apply {
                    duration = 1500
                    interpolator = LinearInterpolator()
                    repeatCount = 0
                    start()
                    addUpdateListener { it ->
                        if ((it.animatedValue as Float) < 0.2 && !isUpdate) {
                            setUpPicture(drawableRes)
                            isUpdate = true
                        }
                    }
                }
    }

    fun playDisk() {
        when (currentState) {
            STATE_STOP -> {
                animator.start()//动画开始
                currentState = STATE_PLAYING
                backgroundView.stateChanged()
            }
            STATE_PAUSE -> {
                animator.resume()//动画重新开始
                currentState = STATE_PLAYING
                backgroundView.stateChanged()
            }
            STATE_PLAYING -> {
                animator.pause()//动画暂停
                currentState = STATE_PAUSE
                backgroundView.stateChanged()
            }
        }
    }

    fun stopDisk() {
        animator.end()
        currentState = STATE_STOP
    }

}

val picSize: Float
    get() = (220.0 / 375.0 * screenWidth).toFloat()

val discSize: Float
    get() = (225.0 / 375.0 * screenWidth).toFloat()

