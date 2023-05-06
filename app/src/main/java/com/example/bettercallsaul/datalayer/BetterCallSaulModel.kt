package com.example.bettercallsaul.datalayer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter

@Entity(tableName = "betterCallSaulEntity")
data class BetterCallSaulModel(
    @ColumnInfo("char_id")
    @PrimaryKey(autoGenerate = true)
    val characterId: Int,
    @ColumnInfo("name")
    val characterName: String,
    @ColumnInfo("birthday")
    val characterBirthday: String,
    @ColumnInfo("occupation")
    val characterOccupation: String,
    @ColumnInfo("img")
    val characterImage: String,
    @ColumnInfo("status")
    val characterStatus: String,
    @ColumnInfo("nickname")
    val characterNickname: String,
    /*@ColumnInfo("appearance")
    val characterAppearance: Array<Int>,*/
    @ColumnInfo("portrayed")
    val characterActor: String
)


/*@ProvidedTypeConverter
class MyTypeConverter {
    @TypeConverter
    fun ArrayToString(characterAppearance: Array<Int>): String {
        return characterAppearance.toString()
    }
}*/
