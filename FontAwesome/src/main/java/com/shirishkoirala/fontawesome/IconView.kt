package com.shirishkoirala.fontawesome

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView


class IconView :
    AppCompatImageView {
    private var color: Int = Color.WHITE
    private var iconString: String? = Icons.font_awesome
    private var iconDrawable: IconDrawable? = null
    private var attributeSet: AttributeSet? = null
    private var defStyleAttr: Int = 0

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        this.attributeSet = attributeSet
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        this.attributeSet = attributeSet
        this.defStyleAttr = defStyleAttr
        init()
    }

    init {
        init()
    }

    private fun init() {
        val attr = context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.IconView,
            defStyleAttr,
            0
        )
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