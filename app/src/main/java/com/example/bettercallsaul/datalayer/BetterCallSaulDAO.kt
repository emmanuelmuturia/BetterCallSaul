package com.example.bettercallsaul.datalayer

import androidx.room.Dao
import androidx.room.Upsert

@Dao
interface BetterCallSaulDAO {

    @Upsert
    suspend fun upsertAllCharacters(betterCallSaulCharacters: List<BetterCallSaulModel>)

}