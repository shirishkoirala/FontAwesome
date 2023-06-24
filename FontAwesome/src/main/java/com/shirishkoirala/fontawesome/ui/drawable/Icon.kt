package com.shirishkoirala.fontawesome.ui.drawable

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.ShapeDrawable
import com.shirishkoirala.fontawesome.data.FontType
import com.shirishkoirala.fontawesome.data.IconData

class Icon(context: Context, private val iconData: IconData, val color: Int) :
    ShapeDrawable() {
    private var textPaint: Paint = Paint()
    private var height = -1
    private var width = -1

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
        width = bounds.width()
        height = bounds.height()

        textPaint.textSize = Math.min(width, height).toFloat()
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