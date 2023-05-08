package com.example.bettercallsaul.datalayer

import com.example.bettercallsaul.sharedlayer.BetterCallSaulState
import kotlinx.coroutines.flow.Flow

interface BetterCallSaulRepository {

    /*suspend fun displayCharacters(): Flow<List<BetterCallSaulModel>>

    suspend fun getAllCharacters()*/

    suspend fun getCharacters(): List<BetterCallSaulDTO>

}