package com.example.bettercallsaul.uilayer

import androidx.compose.runtime.Composable
import com.example.bettercallsaul.sharedlayer.BetterCallSaulState

@Composable
fun HomeScreen(betterCallSaulState: BetterCallSaulState) {

    when(betterCallSaulState) {

        is BetterCallSaulState.Error -> ErrorScreen()
        is BetterCallSaulState.Loading -> LoadingScreen()
        is BetterCallSaulState.Success -> SuccessScreen()

    }

}