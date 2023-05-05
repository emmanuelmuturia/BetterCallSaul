package com.example.bettercallsaul.datalayer

import retrofit2.http.GET
import retrofit2.http.Query

interface BetterCallSaulApiService {

    @GET("characters")
    suspend fun getCharacters(): List<BetterCallSaulDTO>

}