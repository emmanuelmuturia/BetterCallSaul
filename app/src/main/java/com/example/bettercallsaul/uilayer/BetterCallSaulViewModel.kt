package com.example.bettercallsaul.uilayer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.bettercallsaul.datalayer.BetterCallSaulModel
import com.example.bettercallsaul.datalayer.BetterCallSaulModule
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
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

    /*private var _betterCallSaulUiState = MutableStateFlow<BetterCallSaulState>(BetterCallSaulState.Loading)
    val betterCallSaulUiState: StateFlow<BetterCallSaulState> = _betterCallSaulUiState.asStateFlow()*/

    private var _betterCallSaulOfflineState = MutableStateFlow<List<BetterCallSaulModel>>(emptyList())
    val betterCallSaulOfflineState: StateFlow<List<BetterCallSaulModel>> = _betterCallSaulOfflineState.asStateFlow()


    init {
        viewModelScope.launch {
            val getRoomData = repository.displayCharacters().collectLatest {
                if (it.isNotEmpty()) {
                    _betterCallSaulOfflineState.value = it
                } else if (it.isEmpty()) {
                    getBetterCallSaulCharacters()
                }
            }
        }
    }


    private fun getBetterCallSaulCharacters() {
        viewModelScope.launch {

            // _betterCallSaulUiState.update { BetterCallSaulState.Loading }

            try {
                val myCharacters = repository.fetchCharacters()
                dao.insertAllCharacters(betterCallSaulCharacters = myCharacters)
                repository.displayCharacters().collectLatest {
                    _betterCallSaulOfflineState.value = it
                }
                //_betterCallSaulUiState.update { BetterCallSaulState.Success(characters = repository.displayCharacters()) }
            } catch (e: IOException) {
                // _betterCallSaulUiState.update { BetterCallSaulState.Error }
            }

        }
    }

}