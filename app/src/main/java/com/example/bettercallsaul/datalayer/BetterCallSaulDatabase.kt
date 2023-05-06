package com.example.bettercallsaul.datalayer

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [BetterCallSaulModel::class], version = 1)
// @TypeConverters(MyTypeConverter::class)
abstract class BetterCallSaulDatabase : RoomDatabase() {

    abstract fun betterCallSaulDAO(): BetterCallSaulDAO

    companion object {

        @Volatile
        private var instance: BetterCallSaulDatabase? = null

        fun getDatabase(context: Context) : BetterCallSaulDatabase {
            return  instance ?: synchronized(this) {
                Room.databaseBuilder(context = context, klass = BetterCallSaulDatabase::class.java, name = "betterCallSaulDatabase")
                    //.addTypeConverter(typeConverter = MyTypeConverter())
                    .build()
                    .also { instance = it }
            }
        }

    }

}