package com.shirishkoirala.fontawesome.sample.models

import com.shirishkoirala.fontawesome.data.IconData

data class MenuItem(val iconData: IconData, val title: String, val onClick: () -> Unit)
