package com.shirishkoirala.fontawesome

import android.content.Context
import android.graphics.Canvas
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import com.shirishkoirala.fontawesome.data.FontType

class IconTextView : AppCompatTextView {
    var fontType: FontType = FontType.regular
        set(value) {
            field = value
            invalidate()
            requestLayout()
        }

    constructor(context: Context) : super(context) {
        createView(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        createView(context, attrs)
    }

    private fun createView(context: Context, attrs: AttributeSet?) {
        attrs?.let {
            val attr = context.theme.obtainStyledAttributes(
                it, R.styleable.IconTextView, 0, 0
            )
            fontType = when (attr.getInt(R.styleable.IconTextView_iconType, 0)) {
                0 -> FontType.regular
                1 -> FontType.solid
                2 -> FontType.brands
                else -> FontType.regular
            }
        }

        gravity = Gravity.CENTER
        typeface = getOtf(fontType)
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        typeface = getOtf(fontType)
    }

    private fun getOtf(fontType: FontType): Typeface {
        return when (fontType) {
            FontType.brands -> {
                Typeface.createFromAsset(context.assets, "fonts/brands.otf")
            }

            FontType.regular -> {
                Typeface.createFromAsset(context.assets, "fonts/regular.otf")
            }

            FontType.solid -> {
                Typeface.createFromAsset(context.assets, "fonts/solid.otf")
            }
        }
    }
}