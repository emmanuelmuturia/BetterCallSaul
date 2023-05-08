package com.example.bettercallsaul.datalayer

import kotlinx.coroutines.flow.Flow

interface BetterCallSaulRepository {

    suspend fun fetchCharacters(): List<BetterCallSaulModel>

    suspend fun displayCharacters(): Flow<List<BetterCallSaulModel>>

    suspend fun insertCharacters(betterCallSaulList: List<BetterCallSaulModel>)

    suspend fun getCharacters(): List<BetterCallSaulDTO>

}