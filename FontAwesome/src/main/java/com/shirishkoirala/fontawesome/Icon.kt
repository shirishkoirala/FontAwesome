package com.shirishkoirala.fontawesome

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.ShapeDrawable

class Icon(context: Context, private val iconData: IconData, size: Double, val color: Int) :
    ShapeDrawable() {
    private var textPaint: Paint = Paint()
    private var height = -1
    private var width = -1
    private var fontSize = size

    init {
        textPaint.isAntiAlias = true
        textPaint.isFakeBoldText = false
        textPaint.style = Paint.Style.FILL
        when (iconData.type) {
            FontType.brands -> {
                textPaint.typeface = Typeface.createFromAsset(context.assets, "fonts/brands.otf")
            }

            FontType.regular -> {
                textPaint.typeface = Typeface.createFromAsset(context.assets, "fonts/regular.otf")
            }

            FontType.solid -> {
                textPaint.typeface = Typeface.createFromAsset(context.assets, "fonts/solid.otf")
            }
        }

        textPaint.textAlign = Paint.Align.CENTER
        textPaint.color = color
        paint.color = Color.TRANSPARENT
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        val count = canvas.save()
        canvas.translate(bounds.left.toFloat(), bounds.top.toFloat())

        val width = if (width < 0) bounds.width() else width
        val height = if (height < 0) bounds.height() else height
        val fontSize = if (fontSize < 0) Math.min(width, height) else fontSize

        textPaint.textSize = fontSize.toFloat()
        canvas.drawText(
            iconData.unicode, (width / 2).toFloat(),
            height / 2 - (textPaint.descent() + textPaint.ascent()) / 2, textPaint
        )
        canvas.restoreToCount(count)
    }

    override fun setAlpha(alpha: Int) {
        textPaint.alpha = alpha
    }

    override fun setColorFilter(cf: ColorFilter?) {
        textPaint.colorFilter = cf
    }

    override fun getIntrinsicWidth(): Int {
        return width
    }

    override fun getIntrinsicHeight(): Int {
        return height
    }
}