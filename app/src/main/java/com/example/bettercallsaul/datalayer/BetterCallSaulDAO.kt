package com.example.bettercallsaul.datalayer

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BetterCallSaulDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCharacters(betterCallSaulCharacters: List<BetterCallSaulModel>)

    @Query("SELECT * FROM betterCallSaulEntity")
    fun getAllCharacters(): Flow<List<BetterCallSaulModel>>

}