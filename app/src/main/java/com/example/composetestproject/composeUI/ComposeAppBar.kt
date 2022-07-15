package com.example.composetestproject.composeUI

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AppTopBar(activity: Activity?, title:String) {
    Row(modifier = Modifier
        .background(Color.White)
        .fillMaxWidth()
        .height(60.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
        AppBarTitle(title)
    }
    IconButton(onClick = { activity?.finish() }) {
        Icon(Icons.Default.KeyboardArrowLeft, "")
    }
}