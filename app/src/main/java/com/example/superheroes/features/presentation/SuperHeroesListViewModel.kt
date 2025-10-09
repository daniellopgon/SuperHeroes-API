package com.example.superheroes.features.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroes.features.domain.ErrorApp
import com.example.superheroes.features.domain.GetAllSuperHeroesUseCase
import kotlinx.coroutines.launch

class SuperHeroesListViewModel(
    private val getAllSuperHeroesUseCase: GetAllSuperHeroesUseCase
) : ViewModel() {

    private val _superHeroes = MutableLiveData<List<SuperHeroeUiModel>>()
    val superHeroes: LiveData<List<SuperHeroeUiModel>> get() = _superHeroes

    private val _error = MutableLiveData<ErrorApp?>()
    val error: LiveData<ErrorApp?> get() = _error

    fun loadSuperHeroes() {
        viewModelScope.launch {
            val result = getAllSuperHeroesUseCase.fetch()

            result.fold(
                onSuccess = { superHeroesList ->
                    _superHeroes.value = superHeroesList.map { it.toUiModel() }
                    _error.value = null
                },
                onFailure = { exception ->
                    val error = when(exception) {
                        is ErrorApp.InternetConexionError -> ErrorApp.InternetConexionError
                        is ErrorApp.ServerErrorApp -> ErrorApp.ServerErrorApp
                        else -> ErrorApp.ServerErrorApp
                    }
                    _error.value = error
                    _superHeroes.value = emptyList()
                }
            )
        }
    }
}