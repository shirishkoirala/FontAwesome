package com.shirishkoirala.fontawesome

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.ShapeDrawable


class IconDrawable(context: Context, string: String) : ShapeDrawable() {
    private var textPaint: Paint = Paint()
    private var text: String = string
    private var height = -1
    private var width = -1
    private var fontSize = -1
    private var context: Context

    init {
        this.context = context
        textPaint.isAntiAlias = true
        textPaint.isFakeBoldText = false
        textPaint.style = Paint.Style.FILL
        textPaint.typeface = Typeface.createFromAsset(context.assets, "font/solid.otf")
        textPaint.textAlign = Paint.Align.CENTER
        textPaint.color = Color.WHITE
        paint.color = Color.TRANSPARENT
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        val r = bounds

        val count = canvas.save()
        canvas.translate(r.left.toFloat(), r.top.toFloat())

        val width = if (width < 0) r.width() else width
        val height = if (height < 0) r.height() else height
        val fontSize = if (fontSize < 0) Math.min(width, height) else fontSize

        textPaint.textSize = fontSize.toFloat()
        canvas.drawText(
            text, (width / 2).toFloat(),
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