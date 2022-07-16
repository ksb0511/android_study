package com.example.composetestproject.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetestproject.activity.ui.theme.ComposeTestProjectTheme

// 수정
// 수정2
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    val context = LocalContext.current

    ComposeTestProjectTheme() {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Button(onClick = {
                    context.startActivity(Intent(context, LazyColumnActivity::class.java))
                }) {
                    Text(text = "Lazy Column")
                }
                Button(onClick = {
                    context.startActivity(Intent(context, SettingActivity::class.java))
                }) {
                    Text(text = "설정창")
                }
                Button(onClick = {
                    context.startActivity(Intent(context, RoomActivity::class.java))
                }) {
                    Text(text = "Room")
                }
                Button(onClick = {
                    context.startActivity(Intent(context, PagingActivity::class.java))
                }) {
                    Text(text = "Paging")
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview00() {
    ComposeTestProjectTheme {
        HomeScreen()
    }
}