package com.example.bettercallsaul.datalayer

import androidx.room.TypeConverter

class MyTypeConverter {

    @TypeConverter
    fun fromStringList(value: List<String>): String {
        return value.toString()
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        val myList = mutableListOf<String>()
        myList.add(value)
        return myList
    }

    @TypeConverter
    fun fromIntList(value: List<Int>): Int {
        return value.toString().toInt()
    }

    @TypeConverter
    fun toIntList(value: Int): List<Int> {
        val myList = mutableListOf<Int>()
        myList.add(value)
        return myList
    }

}