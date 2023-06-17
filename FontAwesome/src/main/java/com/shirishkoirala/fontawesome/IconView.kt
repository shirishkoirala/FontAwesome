package com.shirishkoirala.fontawesome

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet


class IconView(context: Context, attrs: AttributeSet) :
    androidx.appcompat.widget.AppCompatImageView(context, attrs) {
    private var color: Int = Color.WHITE
    private var iconString: String? = Icons.font_awesome
    private var iconDrawable: IconDrawable? = null

    init {
        val attr = context.theme.obtainStyledAttributes(attrs, R.styleable.IconView, 0, 0)
        iconString = attr.getString(R.styleable.IconView_iconString)
        color = attr.getColor(R.styleable.IconView_color, Color.WHITE)

        iconString?.let {
            iconDrawable = IconDrawable(context, it, color)
        }
        attr.recycle()
    }

    fun setColor(color: Int) {
        this.color = color
        invalidate()
        requestLayout()
    }

    fun setIcon(icon: String) {
        iconString = icon
        iconString?.let {
            iconDrawable = IconDrawable(context, it, color)
        }
        invalidate()
        requestLayout()
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        setImageDrawable(iconDrawable)
    }


}