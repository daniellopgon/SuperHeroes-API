package com.example.superheroapi.features.data.remote.api


class SuperHeroesDataRepository(
    private val apiRemoteDataSource: SuperHeroesApiRemoteDataSource
) : SuperHeroeRepository {

    override fun fetch(): Result<List<SuperHeroe>> {
        val result = apiRemoteDataSource.getSuperHeroes()
        return result.fold(
            onSuccess = { apiModels ->
                val superheroes = apiModels.map { it.toModel() }
                Result.success(superheroes)
            },
            onFailure = { error ->
                Result.failure(error)
            }
        )
    }

    override fun getSuperHeroById(id: String): Result<SuperHeroe> {
        val result = apiRemoteDataSource.getSuperHeroById(id)
        return result.fold(
            onSuccess = { apiModel ->
                Result.success(apiModel.toModel())
            },
            onFailure = { error ->
                Result.failure(error)
            }
        )
    }
}