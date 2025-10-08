package com.example.superheroapi.features.domain

class GetSuperHeroeByIdUseCase(val superHeroeRepository: SuperHeroeRepository) {

    fun getSuperHeroeById(id: String): Result<SuperHeroe> {
        return superHeroeRepository.getSuperHeroById(id)
    }

}