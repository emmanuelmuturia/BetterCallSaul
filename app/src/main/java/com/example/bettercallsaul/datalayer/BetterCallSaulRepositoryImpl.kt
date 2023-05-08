package com.example.bettercallsaul.datalayer

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BetterCallSaulRepositoryImpl(private val betterCallSaulApiService: BetterCallSaulApiService, private val betterCallSaulDAO: BetterCallSaulDAO) : BetterCallSaulRepository {

    private val coroutineScope = CoroutineScope(context = Dispatchers.Main)

    private fun BetterCallSaulDTO.toEntity(): BetterCallSaulModel {
        return BetterCallSaulModel(
            characterId = characterId,
            charId = charId,
            characterName = characterName,
            characterBirthday = characterBirthday,
            characterImage = characterImage,
            characterStatus = characterStatus,
            characterActor = characterActor
        )
    }
    override suspend fun fetchCharacters(): List<BetterCallSaulModel> {
        return withContext(context = Dispatchers.IO) {
            val myResponse = betterCallSaulApiService.getCharacters()
            myResponse.map { it.toEntity() }
        }
    }

    override suspend fun displayCharacters(): Flow<List<BetterCallSaulModel>> {
        return withContext(context = Dispatchers.IO) {
            betterCallSaulDAO.getAllCharacters()
        }
    }

    override suspend fun insertCharacters(betterCallSaulList: List<BetterCallSaulModel>) {
        coroutineScope.launch {
            betterCallSaulDAO.insertAllCharacters(betterCallSaulCharacters = betterCallSaulList)
        }
    }

    override suspend fun getCharacters(): List<BetterCallSaulDTO> {
        return withContext(context = Dispatchers.IO) {
            betterCallSaulApiService.getCharacters()
        }
    }


}