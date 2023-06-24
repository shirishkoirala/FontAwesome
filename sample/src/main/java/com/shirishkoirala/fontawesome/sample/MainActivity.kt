package com.shirishkoirala.fontawesome.sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import com.shirishkoirala.fontawesome.ComposeIconView
import com.shirishkoirala.fontawesome.data.Icons
import com.shirishkoirala.fontawesome.sample.activities.ComposeActivity
import com.shirishkoirala.fontawesome.sample.activities.JavaActivity
import com.shirishkoirala.fontawesome.sample.activities.KotlinActivity
import com.shirishkoirala.fontawesome.sample.models.MenuItem
import com.shirishkoirala.fontawesome.sample.ui.theme.FontawesomeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FontawesomeTheme {
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
    val itemList = listOf(MenuItem(Icons.code_solid, "XML and Java") {
        context.startActivity(Intent(context, JavaActivity::class.java))
    }, MenuItem(Icons.code_solid, "XML and Kotlin") {
        context.startActivity(Intent(context, KotlinActivity::class.java))
    }, MenuItem(Icons.file_code_regular, "Compose and Kotlin") {
        context.startActivity(Intent(context, ComposeActivity::class.java))
    })
    LazyColumn(modifier = Modifier.padding(paddingValues = paddingValues)) {
        items(itemList) { item ->
            ClickableText(item)
        }
    }
}

@Composable
fun ClickableText(item: MenuItem) {
    Row(modifier = Modifier.clickable { item.onClick.invoke() }) {
        ComposeIconView(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            iconData = item.iconData,
        )
        Text(
            text = item.title,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        )
    }
}
