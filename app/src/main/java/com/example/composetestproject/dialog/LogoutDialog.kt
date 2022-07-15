package com.example.composetest

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.composetestproject.activity.ui.theme.ComposeTestProjectTheme
import com.example.composetestproject.composeUI.AppBarTitle
import com.example.composetestproject.composeUI.ListItemTitle


@Composable
fun LogoutDialog(setShowDialog: (Boolean) -> Unit, setValue: (String) -> Unit) {

    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(10.dp)
            ) {
                Column(modifier = Modifier.padding(15.dp)) {

                    AppBarTitle("로그아웃")

                    Spacer(modifier = Modifier.height(30.dp))

                    ListItemTitle("로그아웃하시겠습니까?")

                    Spacer(modifier = Modifier.height(40.dp))

                    Row(horizontalArrangement = Arrangement.Center) {
                        Box(Modifier.weight(1f)) {

                            Button(
                                onClick = {
                                    setValue("취소")
                                    setShowDialog(false)
                                },
                                shape = RoundedCornerShape(50.dp),
                                modifier = Modifier
                                    .height(50.dp)
                                    .fillMaxWidth()
                                    .padding(5.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color(
                                        255,
                                        255,
                                        255,
                                        255
                                    )
                                ),
                            ) {
                                Text(text = "취소")
                            }
                        }
                        Box(Modifier.weight(1f)) {
                            Button(
                                onClick = {
                                    setValue("확인")
                                    setShowDialog(false)
                                },
                                shape = RoundedCornerShape(50.dp),
                                modifier = Modifier
                                    .height(50.dp)
                                    .fillMaxWidth()
                                    .padding(5.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color(0, 0, 0, 255)
                                ),
                            ) {
                                Text(
                                    text = "확인", style = TextStyle(
                                        color = Color(
                                            255,
                                            255,
                                            255,
                                            255
                                        )
                                    )
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview55() {
    ComposeTestProjectTheme() {
        Scaffold {
            Dialog(onDismissRequest = { }) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = Color.White
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Column(modifier = Modifier.padding(15.dp)) {

                            AppBarTitle("로그아웃")

                            Spacer(modifier = Modifier.height(30.dp))

                            ListItemTitle("로그아웃하시겠습니까?")

                            Spacer(modifier = Modifier.height(40.dp))

                            Row(horizontalArrangement = Arrangement.Center) {
                                Box(Modifier.weight(1f)) {

                                    Button(
                                        onClick = {
                                            Log.d("취소 클릭", "취소")
                                        },
                                        shape = RoundedCornerShape(50.dp),
                                        modifier = Modifier
                                            .height(50.dp)
                                            .fillMaxWidth()
                                            .padding(5.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            backgroundColor = Color(
                                                255,
                                                255,
                                                255,
                                                255
                                            )
                                        ),
                                    ) {
                                        Text(text = "취소")
                                    }
                                }
                                Box(Modifier.weight(1f)) {
                                    Button(
                                        onClick = {
                                            Log.d("확인 클릭", "확인")
                                        },
                                        shape = RoundedCornerShape(50.dp),
                                        modifier = Modifier
                                            .height(50.dp)
                                            .fillMaxWidth()
                                            .padding(5.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            backgroundColor = Color(0, 0, 0, 255)
                                        ),
                                    ) {
                                        Text(
                                            text = "확인", style = TextStyle(
                                                color = Color(
                                                    255,
                                                    255,
                                                    255,
                                                    255
                                                )
                                            )
                                        )
                                    }
                                }
                            }

                        }
                    }
                }
            }

        }

    }
}