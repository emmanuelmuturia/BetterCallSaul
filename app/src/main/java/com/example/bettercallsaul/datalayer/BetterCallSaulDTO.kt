package com.example.bettercallsaul.datalayer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BetterCallSaulDTO(
    @SerialName("char_id")
    val characterId: Int,
    @SerialName("name")
    val characterName: String,
    @SerialName("birthday")
    val characterBirthday: String,
    @SerialName("occupation")
    val characterOccupation: String,
    @SerialName("img")
    val characterImage: String,
    @SerialName("status")
    val characterStatus: String,
    @SerialName("nickname")
    val characterNickname: String,
    /*@SerialName("appearance")
    val characterAppearance: Array<Int> = null,*/
    @SerialName("portrayed")
    val characterActor: String
)
