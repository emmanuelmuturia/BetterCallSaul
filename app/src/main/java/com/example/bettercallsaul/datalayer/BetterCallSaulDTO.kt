package com.example.bettercallsaul.datalayer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BetterCallSaulDTO(
    @SerialName("_id")
    val characterId: String,
    @SerialName("char_id")
    val charId: Int,
    @SerialName("name")
    val characterName: String,
    @SerialName("birthday")
    val characterBirthday: String,
    /*@SerialName("occupation")
    val characterOccupation: List<String>,*/
    @SerialName("img")
    val characterImage: String,
    @SerialName("status")
    val characterStatus: String,
    @SerialName("portrayed")
    val characterActor: String,
    /*@SerialName("nickname")
    val characterNickname: List<String>,
    @SerialName("appearance")
    val characterAppearance: List<Int>*/
    /*@SerialName("firstAppearance")
    val firstAppearance: List<String>,
    @SerialName("lastAppearance")
    val lastAppearance: List<String>*/
)
