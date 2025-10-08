package com.example.superheroapi.features.domain

class GetAllSuperHeroesUseCase(val superHeroeRepository: SuperHeroeRepository) {
    fun fetch(): Result<List<SuperHeroe>> {
        return superHeroeRepository.fetch()
    }
}