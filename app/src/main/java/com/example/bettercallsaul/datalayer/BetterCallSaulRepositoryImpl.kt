package com.example.bettercallsaul.datalayer

import kotlinx.coroutines.flow.Flow

class BetterCallSaulRepositoryImpl(private val betterCallSaulApiService: BetterCallSaulApiService) : BetterCallSaulRepository {



    /*override suspend fun displayCharacters(): Flow<List<BetterCallSaulModel>> {
        return betterCallSaulDAO.getAllCharacters()
    }

    *//*override suspend fun getAllCharacters() {
        val characters = betterCallSaulApiService.getCharacters()
        return betterCallSaulDAO.insertAllCharacters(betterCallSaulCharacters = characters.map { it.toBetterCallSaulModel() })
    }*/

    override suspend fun getCharacters(): List<BetterCallSaulDTO> {
        return betterCallSaulApiService.getCharacters()
    }
}