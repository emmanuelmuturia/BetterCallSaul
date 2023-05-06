package com.example.bettercallsaul.datalayer

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BetterCallSaulDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCharacters(betterCallSaulCharacters: List<BetterCallSaulDTO>)

    @Query("SELECT * FROM betterCallSaulEntity")
    suspend fun getAllCharacters(): Flow<List<BetterCallSaulModel>>

}