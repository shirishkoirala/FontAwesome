package com.shirishkoirala.fontawesome

import android.content.Context
import android.content.res.Configuration
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.shirishkoirala.fontawesome.data.IconData
import com.shirishkoirala.fontawesome.data.Icons
import com.shirishkoirala.fontawesome.drawables.Icon


class IconView : AppCompatImageView {
    private var color: Int = Color.BLACK
    var iconData: IconData = Icons.font_awesome_brands
        set(value) {
            field = value
            invalidate()
            requestLayout()
        }
    private var iconName: String? = null
    private var attributeSet: AttributeSet? = null
    private var defStyleAttr: Int = 0
    private var icon: Icon? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        this.attributeSet = attributeSet
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context, attributeSet, defStyleAttr
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
            attributeSet, R.styleable.IconView, defStyleAttr, 0
        )

        color = attr.getColor(R.styleable.IconView_color, Color.WHITE)

        iconName = attr.getString(R.styleable.IconView_iconName)
        createDrawable()
        attr.recycle()
    }

    private fun createDrawable() {
        iconName?.let { iconName ->
            Icons::class.qualifiedName?.let { qualifiedName ->
                val clazz = Class.forName(qualifiedName)
                val field = clazz.getDeclaredField(iconName)
                field.isAccessible = true
                val iconData = field.get(null) as IconData
                icon = Icon(context = context, iconData = iconData, color = color)
            }
        }
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val nightModeFlags = context.resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK
        when (nightModeFlags) {
            Configuration.UI_MODE_NIGHT_YES -> {
                color = ContextCompat.getColor(context, android.R.color.primary_text_dark)
            }

            Configuration.UI_MODE_NIGHT_NO -> {
                color = ContextCompat.getColor(context, android.R.color.primary_text_light)
            }

            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                color = ContextCompat.getColor(context, android.R.color.primary_text_light)
            }
        }

        createDrawable()

        icon?.let {
            setImageDrawable(it)
        }
    }
}