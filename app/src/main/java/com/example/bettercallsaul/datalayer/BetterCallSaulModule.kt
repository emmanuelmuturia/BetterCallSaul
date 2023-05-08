package com.example.bettercallsaul.datalayer

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BetterCallSaulModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {

        val json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }

        return Retrofit.Builder()
            .baseUrl("https://bettercallsaul-api.onrender.com/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

    }


    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): BetterCallSaulApiService {
        return retrofit.create(BetterCallSaulApiService::class.java)
    }


    @Provides
    @Singleton
    fun providesRoomDatabase(@ApplicationContext context: Context): BetterCallSaulDatabase {
        return BetterCallSaulDatabase.getDatabase(context = context)
    }


    @Provides
    @Singleton
    fun providesDAO(betterCallSaulDatabase: BetterCallSaulDatabase): BetterCallSaulDAO {
        return betterCallSaulDatabase.betterCallSaulDAO()
    }

    @Provides
    @Singleton
    fun providesRepository(betterCallSaulApiService: BetterCallSaulApiService): BetterCallSaulRepositoryImpl {
        return BetterCallSaulRepositoryImpl(betterCallSaulApiService = betterCallSaulApiService)
    }

}