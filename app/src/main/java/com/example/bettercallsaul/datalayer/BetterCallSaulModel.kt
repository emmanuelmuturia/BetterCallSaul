package com.example.bettercallsaul.datalayer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import kotlinx.serialization.SerialName

@Entity(tableName = "betterCallSaulEntity")
data class BetterCallSaulModel(
    @ColumnInfo("_id")
    val characterId: String,
    @ColumnInfo("char_id")
    @PrimaryKey(autoGenerate = true)
    val charId: Int,
    @ColumnInfo("name")
    val characterName: String,
    @ColumnInfo("birthday")
    val characterBirthday: String,
    /*@ColumnInfo("occupation")
    val characterOccupation: List<String>,*/
    @ColumnInfo("img")
    val characterImage: String,
    @ColumnInfo("status")
    val characterStatus: String,
    @ColumnInfo("portrayed")
    val characterActor: String
    /*@ColumnInfo("nickname")
    val characterNickname: List<String>,
    @ColumnInfo("appearance")
    val characterAppearance: List<Int>*/
    /*@ColumnInfo("firstAppearance")
    val firstAppearance: List<String>,
    @ColumnInfo("lastAppearance")
    val lastAppearance: List<String>*/
)
