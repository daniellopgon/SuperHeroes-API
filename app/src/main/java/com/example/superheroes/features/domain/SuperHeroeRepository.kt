package com.example.superheroes.features.domain

interface SuperHeroeRepository {
    suspend fun fetch(): Result<List<SuperHeroe>>
    suspend fun getSuperHeroById(id: String): Result<SuperHeroe>
}