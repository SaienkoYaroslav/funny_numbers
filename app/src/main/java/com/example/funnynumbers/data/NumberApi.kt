package com.example.funnynumbers.data

import com.example.funnynumbers.data.db.NumberEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface NumberApi {
    @GET("{id}?json")
    suspend fun getNumberById(@Path("id") id: Int): NumberEntity

    @GET("random/math?json")
    suspend fun getRandomNumber(): NumberEntity
}