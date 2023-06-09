package com.shirishkoirala.fontawesome

import android.content.Context
import android.util.AttributeSet


class IconView : androidx.appcompat.widget.AppCompatImageView {
    private var isDrawable = false

    constructor(context: Context, attrs: AttributeSet?) : super(context) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(context, attrs)
    }

    private fun init(context: Context, attributeSet: AttributeSet?) {
        val attr = context.obtainStyledAttributes(attributeSet, R.styleable.IconView, 0, 0)
        val iconString: String? = attr.getString(R.styleable.IconView_android_src)
        iconString?.let {
            setBackgroundDrawable(IconDrawable(getContext(), it))
        }
        attr.recycle()
    }
}