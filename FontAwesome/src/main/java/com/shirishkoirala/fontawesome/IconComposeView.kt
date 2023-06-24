package com.shirishkoirala.fontawesome

import android.R
import androidx.annotation.ColorRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.shirishkoirala.fontawesome.data.IconData
import com.shirishkoirala.fontawesome.data.Icons


@Composable
fun IconComposeView(
    modifier: Modifier = Modifier,
    iconData: IconData = Icons.java_brands,
    size: Dp = Dp(24f),
    @ColorRes color: Int = if (isSystemInDarkTheme()) R.color.white else R.color.black,
) {
    AndroidView(factory = { context ->
        IconTextView(context)
    }, update = { view ->
        view.text = iconData.unicode
        view.textSize = size.value
        view.fontType = iconData.type
        view.setTextColor(ContextCompat.getColor(view.context, color))
    }, modifier = modifier)
}

@Preview
@Composable
private fun Preview() {
    IconComposeView(modifier = Modifier.padding(20.dp))
}