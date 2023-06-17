package com.shirishkoirala.fontawesome.sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shirishkoirala.fontawesome.sample.activities.ComposeActivity
import com.shirishkoirala.fontawesome.sample.activities.JavaActivity
import com.shirishkoirala.fontawesome.sample.activities.KotlinActivity
import com.shirishkoirala.fontawesome.sample.ui.theme.FontawesomeTheme

class MainActivity : ComponentActivity() {
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
                        ClickableList(this, it)
                    }
                }
            }
        }
    }
}

@Composable
fun ClickableList(context: Context, paddingValues: PaddingValues) {
    val itemList = listOf(
        "Example using XML and Java",
        "Example using XML and Kotlin",
        "Example using Jetpack Compose and Kotlin"
    )
    LazyColumn(modifier = Modifier.padding(paddingValues = paddingValues)) {
        items(itemList) { item ->
            ClickableText(item, onClick = {
                if (itemList.indexOf(item) == 0) {
                    context.startActivity(Intent(context, JavaActivity::class.java))
                } else if (itemList.indexOf(item) == 1) {
                    context.startActivity(Intent(context, KotlinActivity::class.java))
                } else {
                    context.startActivity(Intent(context, ComposeActivity::class.java))
                }
            })
        }
    }
}

@Composable
fun ClickableText(text: String, onClick: () -> Unit) {
    Text(text = text, modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick.invoke() }
        .padding(16.dp))
}
