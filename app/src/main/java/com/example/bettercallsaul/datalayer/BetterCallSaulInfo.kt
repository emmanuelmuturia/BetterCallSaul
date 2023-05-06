package com.example.bettercallsaul.datalayer

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName

data class BetterCallSaulInfo(
    val characterId: String,
    val charId: Int,
    val characterName: String,
    val characterBirthday: String,
    val characterOccupation: List<String>,
    val characterImage: String,
    val characterStatus: String,
    val characterNickname: List<String>,
    val characterAppearance: List<Int>,
    val firstAppearance: List<String>,
    val lastAppearance: List<String>,
    val characterActor: String
)
