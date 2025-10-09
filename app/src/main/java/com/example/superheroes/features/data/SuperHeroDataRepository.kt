import com.example.superheroes.features.data.remote.api.SuperHeroesApiRemoteDataSource
import com.example.superheroes.features.data.remote.api.toModel
import com.example.superheroes.features.domain.SuperHeroe
import com.example.superheroes.features.domain.SuperHeroeRepository

class SuperHeroesDataRepository(
    private val apiRemoteDataSource: SuperHeroesApiRemoteDataSource
) : SuperHeroeRepository {

    override suspend fun fetch(): Result<List<SuperHeroe>> {
        return apiRemoteDataSource.getSuperHeroes().map { apiModelsList ->
            apiModelsList.map { apiModel -> apiModel.toModel() }
        }
    }

    override suspend fun getSuperHeroById(id: String): Result<SuperHeroe> {
        return apiRemoteDataSource.getSuperHeroById(id).map { apiModel ->
            apiModel.toModel()
        }
    }
}