package com.example.bettercallsaul.sharedlayer

import com.example.bettercallsaul.datalayer.BetterCallSaulDTO
import com.example.bettercallsaul.datalayer.BetterCallSaulModel
import kotlinx.coroutines.flow.Flow

sealed interface BetterCallSaulState {

    // val characters: Flow<List<BetterCallSaulModel>>
    object Success: BetterCallSaulState

    object Loading: BetterCallSaulState

    object Error: BetterCallSaulState

}
