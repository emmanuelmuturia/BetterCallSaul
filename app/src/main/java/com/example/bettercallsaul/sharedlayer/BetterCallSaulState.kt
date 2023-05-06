package com.example.bettercallsaul.sharedlayer

import com.example.bettercallsaul.datalayer.BetterCallSaulDTO
import com.example.bettercallsaul.datalayer.BetterCallSaulModel
import kotlinx.coroutines.flow.Flow

sealed interface BetterCallSaulState {

    data class Success(val characters: Flow<List<BetterCallSaulModel>>): BetterCallSaulState

    object Loading: BetterCallSaulState

    object Error: BetterCallSaulState

}