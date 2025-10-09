package com.example.superheroes.features.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroApiService {
    @GET("all.json")
    suspend fun findAll(): Response<List<SuperHeroApiModel>>

    @GET("id/{id}.json")
    suspend fun findById(@Path("id") id: String): Response<SuperHeroApiModel>

}