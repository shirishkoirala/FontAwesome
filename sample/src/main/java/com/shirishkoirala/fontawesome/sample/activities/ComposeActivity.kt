package com.shirishkoirala.fontawesome.sample.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.shirishkoirala.fontawesome.ui.ComposeIconView
import com.shirishkoirala.fontawesome.sample.R
import com.shirishkoirala.fontawesome.sample.ui.theme.FontawesomeTheme

class ComposeActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FontawesomeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(topBar = {
                        TopAppBar(title = { Text(text = "My App") })
                    }) {
                        ComposeIconView(
                            modifier = Modifier.padding(it),
                            size = Dp(35f)
                        )
                    }
                }
            }
        }
    }
}

