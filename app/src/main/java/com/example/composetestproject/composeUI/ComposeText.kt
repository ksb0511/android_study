package com.example.composetestproject.composeUI

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun ListItemTitle(name: String) {
    Text(
        text = name,
        style = TextStyle(color = Color.Gray, fontSize = 14.sp),
    )
}

@Composable
fun ButtonText(name: String){
    Text(
        text = name,
        style = TextStyle(color = Color.DarkGray, fontSize = 14.sp, background = Color.White),
    )
}

@Composable
fun AppBarTitle(title:String){
    Text(
        text = title,
        style = TextStyle(
            fontWeight = FontWeight(FontWeight.ExtraBold.weight),
            fontSize = 17.sp
        )
    )
}

@Composable
fun HomeButton(click: () -> Unit, text: String){
    Button(onClick = { click }) {
        Text(text = text)
    }
}