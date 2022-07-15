package com.example.composetest.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.composetest.dao.PushDao
import com.example.composetest.data.PushData
import com.example.composetest.data.User

//@Database(entities = [User::class, PushData::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun userDao(): UserDao
//    abstract fun pushDao() : PushDao
//}

@Database(entities = [(PushData::class)], version = 1)
abstract class ProductRoomDatabase: RoomDatabase() {

    abstract fun productDao(): PushDao

    companion object {

        private var INSTANCE: ProductRoomDatabase? = null

        fun getInstance(context: Context): ProductRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProductRoomDatabase::class.java,
                        "product_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}


//@Database(entities = [PushData::class], version = 1)
//abstract class PushDatabase : RoomDatabase() {
//    abstract fun pushDao(): PushDao
//}
