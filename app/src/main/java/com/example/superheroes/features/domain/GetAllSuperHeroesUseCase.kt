package com.example.superheroes.features.domain

class GetAllSuperHeroesUseCase(val superHeroeRepository: SuperHeroeRepository) {
    suspend fun fetch(): Result<List<SuperHeroe>> {
        return superHeroeRepository.fetch()
    }
}