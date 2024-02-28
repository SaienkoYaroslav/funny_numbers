package com.example.funnynumbers.data

import com.example.funnynumbers.domain.model.MyNumber
import retrofit2.http.GET
import retrofit2.http.Path

interface NumberApi {
    @GET("{id}?json")
    suspend fun getNumberById(@Path("id") id: Int): MyNumber

    @GET("random/math?json")
    suspend fun getRandomNumber(): MyNumber
}