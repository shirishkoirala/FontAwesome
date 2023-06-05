package com.shirishkoirala.fontawesome

import android.content.Context
import android.util.AttributeSet
class IconView(context: Context) : androidx.appcompat.widget.AppCompatImageView(context) {
    constructor(context: Context, attrs: AttributeSet?) : this(context) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : this(context, attrs) {
        init(context, attrs)
    }

    fun init(context: Context, attributeSet: AttributeSet?) {
        val attr = context.obtainStyledAttributes(attributeSet, R.styleable.FontAwesomeIconView, 0, 0)
//        mColorNormal = attr.getColor(
//            R.styleable.FloatingActionButton_fab_colorNormal,
//            getColor(R.color.holo_blue_dark)
//        )
//        mColorPressed = attr.getColor(
//            R.styleable.FloatingActionButton_fab_colorPressed,
//            getColor(R.color.holo_blue_light)
//        )
//        mColorDisabled = attr.getColor(
//            R.styleable.FloatingActionButton_fab_colorDisabled,
//            getColor(R.color.darker_gray)
//        )
//        mSize = attr.getInt(
//            R.styleable.FloatingActionButton_fab_size,
//            com.talk5.audio.views.floatingactionbutton.FloatingActionButton.SIZE_NORMAL
//        )
//        mIcon = attr.getResourceId(R.styleable.FloatingActionButton_fab_icon, 0)
//        mTitle = attr.getString(R.styleable.FloatingActionButton_fab_title)
//        mStrokeVisible = attr.getBoolean(R.styleable.FloatingActionButton_fab_stroke_visible, true)
//        attr.recycle()
//        updateCircleSize()
//        mShadowRadius = getDimension(R.dimen.fab_shadow_radius)
//        mShadowOffset = getDimension(R.dimen.fab_shadow_offset)
//        updateDrawableSize()
//        updateBackground()

    }
}