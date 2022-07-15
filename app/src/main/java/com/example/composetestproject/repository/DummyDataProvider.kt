package com.example.composetest.repository

data class User(
    val name : String = "이름",
    val description: String = "LazyColumn 연습용",
)

object DummyDataProvider {
    val userList = List(10000){ User() }
}

/*
리스트 숫자를 늘릴 시에 나타나는 이슈
- OutOfMemoryError는 비트맵을 처리하는 동안 Android에서 발생하는 가장 일반적인 문제
- 이 오류는 메모리 공간ㄱ이 부족하여 객체를 할당할 수 없고 가비지 수집기가 일부 공간을 해제할 수 없는 경우 JVM에서 발생
-> 매니페스트 파일에 엔티티를 추가할 수 있으며 android:hardwareAccelerated="false"일부 android:largeHeap="true"환경에서는 작동합니다.
 */