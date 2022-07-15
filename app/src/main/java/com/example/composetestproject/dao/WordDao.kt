package com.example.composetest.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.composetest.data.Word

@Dao
interface WordDao {
    // 데이터베이스 변경사항 관찰
    /*
    데이터가 변경되면 일반적으로 UI에 업데이트된 데이터를 표시하는 등 몇가지 작업을 실행하는 것이 좋음
    데이터가 변경될 때 대응할 수 있도록 데이터 관찰이 필요함

    데이터 변경사항을 관찰하려면 coroutines의 Flow를 사용해야 한다. 메서드 설명에서 Flow 유형의 반환 값을 사용하면 Room은 데이터베이스가 업데이트될 때 Flow를 업데이트하는 데 필요한 모든 코드를 생성

    Flow는 값의 비동기 시퀀스
    Flow는 네트워크 요청이나 데이터베이스 호출, 기타 비동기 코드 등의 비동기 작업에서 값을 생성할 수 있는 값을 한번에 모두가 아니라 한 번에 하나씩 생성한다.
    API 전체에서 코루틴을 지원하므로 코루틴을 사용하여 흐름도 변환할 수 있음.

     */
//    @Query("SELECT * FROM word_table ORDER BY word ASC")
//    fun getAlphabetizedWords(): List<Word>
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insert(word: Word)
//
//    @Query("DELETE FROM word_table")
//    suspend fun deleteAll()

}