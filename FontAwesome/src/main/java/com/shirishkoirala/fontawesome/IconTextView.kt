package com.shirishkoirala.fontawesome

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView

class IconTextView : AppCompatTextView {

    constructor(context: Context) : super(context) {
        createView(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        createView(context)
    }

    private fun createView(context: Context) {
        gravity = Gravity.CENTER
        typeface = Typeface.createFromAsset(context.assets, "fonts/solid.otf")
    }
}