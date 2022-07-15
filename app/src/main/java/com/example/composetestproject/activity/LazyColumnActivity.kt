package com.example.composetestproject.activity

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest.repository.DummyDataProvider
import com.example.composetest.repository.User
import com.example.composetestproject.activity.ui.theme.ComposeTestProjectTheme
import com.example.composetestproject.composeUI.AppTopBar

class LazyColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestProjectTheme() {
                ContentViewFirstActivity()
            }
        }
    }
}

@Composable
fun MyAppBar() {
    val context = LocalContext.current
    AppTopBar(context as Activity, "Lazy Columns")
}

@Composable
fun ContentViewFirstActivity() {
    // A surface container using the 'background' color from the theme
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(backgroundColor = Color.White,
            topBar = { MyAppBar() }
        ) {
            UserListView(users = DummyDataProvider.userList)
        }
    }
}


@Composable
fun UserListView(users: List<User>) {
    LazyColumn {
        items(users) { UserView(it) }
    }
}

@Composable
fun UserView(user: User) {
    val typography = MaterialTheme.typography
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column {
                Text(
                    text = user.name,
                    style = typography.subtitle1
                )
                Text(
                    text = user.description,
                    style = typography.body1
                )
            }
        }
    }
}


@Preview
@Composable
fun p(){
    ComposeTestProjectTheme {
        ContentViewFirstActivity()
    }
}

