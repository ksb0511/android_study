package com.example.composetestproject.activity

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.LogoutDialog
import com.example.composetestproject.activity.ui.theme.ComposeTestProjectTheme
import com.example.composetestproject.composeUI.AppTopBar
import com.example.composetestproject.composeUI.ButtonText
import com.example.composetestproject.composeUI.ListItemTitle

class SettingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestProjectTheme() {
                SettingContentView()
            }
        }
    }
}

@Composable
fun SettingContentView() {

    val activity = (LocalContext.current as? Activity)
    val appVersion = "2.0.5"

    Surface(color = MaterialTheme.colors.background) {
        Scaffold(backgroundColor = Color.White,
            topBar = { AppTopBar(activity, "설정") }
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                SettingAlarm("알림 설정")
                VersionInformation("버전 정보", appVersion)// 버전 정보는 받아서
                CacheCoockie("캐시/쿠키")

                Divider()
                LogOut()
                Explanation()
            }

        }
    }
}

@Composable
fun Explanation() {
    Box(
        modifier = Modifier
            .background(color = Color(243, 243, 243, 255))
            .fillMaxHeight()
            .fillMaxWidth()

    ) {
        Text(
            text = "알림이 오지 않을 경우, 기기의 설정>알림>Carrot앱 알림 허용 여부를 확인해주세요.",
            style = TextStyle(fontSize = 13.sp, color = Color.Gray),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxHeight()
        )
    }


}

@Composable
fun LogOut() {
    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value)
        LogoutDialog(setShowDialog = {
            showDialog.value = it
        }) {
            Log.i("ShowDialog", "ShowDialog : $it")
        }


    TextButton(onClick = {
        showDialog.value = true
    }, modifier = Modifier.padding(13.dp)) {
        ButtonText("로그아웃")
    }
}


@Composable
fun Divider() {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .height(1.dp)
            .padding(top = 70.dp, bottom = 30.dp)
    )
}

@Composable
fun SettingAlarm(name: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        ListItemTitle(name = name)
        Spacer(Modifier.weight(1f))
        AlarmOnOff()
    }
}

@Composable
fun VersionInformation(name: String, version: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        ListItemTitle(name = name)
        Box(modifier = Modifier.width(50.dp))
        Text(
            text = version,
            style = TextStyle(color = Color.Black, fontSize = 15.sp),
        )
    }
}


@Composable
fun CacheCoockie(name: String) {
    val mContext = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        ListItemTitle(name = name)
        Spacer(Modifier.weight(1f))

        TextButton(
            onClick = {
                Toast.makeText(mContext, "삭제 클릭", Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(
                    255,
                    255,
                    255,
                    255
                )
            ),
            modifier = Modifier
                .height(30.dp)
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(15.dp)
                )
        ) {
            Text(
                text = "삭제",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.ExtraBold
                )
            )
        }
    }
}


@Composable
fun AlarmOnOff() {
    val mContext = LocalContext.current

    var mCheckedState by remember { mutableStateOf(false) }

    Switch(
        checked = mCheckedState, onCheckedChange = {
            mCheckedState = it
            Toast.makeText(mContext, mCheckedState.toString(), Toast.LENGTH_SHORT).show()
        }, colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            uncheckedThumbColor = Color.White,
            checkedTrackColor = Color(255, 87, 34, 255),
            uncheckedTrackColor = Color.Gray,
            checkedTrackAlpha = 1.0f,
            uncheckedTrackAlpha = 1.0f
        )
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeTestProjectTheme {
        SettingContentView()

    }
}
