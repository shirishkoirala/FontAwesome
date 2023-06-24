package com.shirishkoirala.fontawesome.ui

import android.R
import androidx.annotation.ColorRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.shirishkoirala.fontawesome.data.Icons


@Composable
fun ComposeIconView(
    stringIcon: String = Icons.font_awesome_brands.unicode,
    size: Dp = Dp(24f),
    @ColorRes color: Int = if (isSystemInDarkTheme()) R.color.white else R.color.darker_gray,
    modifier: Modifier
) {
    AndroidView(factory = { context ->
        IconTextView(context)
    }, update = { view ->
        view.text = stringIcon
        view.textSize = size.value
        view.setTextColor(ContextCompat.getColor(view.context, color))
    }, modifier = modifier)
}

@Preview
@Composable
private fun Preview() {
    ComposeIconView(modifier = Modifier.padding(Dp(20f)))
}