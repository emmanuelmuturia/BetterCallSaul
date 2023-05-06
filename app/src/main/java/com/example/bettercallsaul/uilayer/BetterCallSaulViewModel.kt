package com.example.bettercallsaul.uilayer

import android.app.Application
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.bettercallsaul.datalayer.BetterCallSaulModel
import com.example.bettercallsaul.datalayer.BetterCallSaulModule
import com.example.bettercallsaul.sharedlayer.BetterCallSaulState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class BetterCallSaulViewModel @Inject constructor(application: Application) : AndroidViewModel(application = application) {

    private val database = BetterCallSaulModule.providesRoomDatabase(context = application)
    private val dao = BetterCallSaulModule.providesDAO(betterCallSaulDatabase = database)
    private val retrofit = BetterCallSaulModule.providesRetrofit()
    private val apiService = BetterCallSaulModule.providesApiService(retrofit = retrofit)
    private val repository = BetterCallSaulModule.providesRepository(betterCallSaulApiService = apiService, betterCallSaulDAO = dao)

    private var _betterCallSaulState = MutableStateFlow<BetterCallSaulModel?>(null)
    val betterCallSaulState: StateFlow<BetterCallSaulModel?> = _betterCallSaulState.asStateFlow()

    private var _betterCallSaulUiState = MutableStateFlow<BetterCallSaulState>(BetterCallSaulState.Loading)
    val betterCallSaulUiState: StateFlow<BetterCallSaulState> = _betterCallSaulUiState.asStateFlow()


    init {
        getBetterCallSaulCharacters()
    }


    fun getBetterCallSaulCharacters() {
        viewModelScope.launch {

            _betterCallSaulUiState.update { BetterCallSaulState.Loading }

            try {
                repository.getAllCharacters()
                _betterCallSaulUiState.update { BetterCallSaulState.Success(characters = repository.displayCharacters()) }
            } catch (e: IOException) {
                _betterCallSaulUiState.update { BetterCallSaulState.Error }
            }

        }
    }

}