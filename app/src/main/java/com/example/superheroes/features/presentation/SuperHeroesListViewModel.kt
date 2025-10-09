package com.example.superheroes.features.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroes.features.domain.GetAllSuperHeroesUseCase
import com.example.superheroes.features.domain.GetSuperHeroeByIdUseCase
import kotlinx.coroutines.launch

class SuperHeroesListViewModel(
    val getAllSuperHeroesUseCase: GetAllSuperHeroesUseCase,
    val getSuperHeroByIdUseCase: GetSuperHeroeByIdUseCase
) : ViewModel() {

    fun loadSuperHeroes() {
        viewModelScope.launch {
            val superHeroes = getAllSuperHeroesUseCase.fetch()
            Log.d("@dev", "superHeroes = $superHeroes")
        }
    }

    fun loadSuperHeroeById(id: String) {
        viewModelScope.launch {
            val superheroe = getSuperHeroByIdUseCase.getSuperHeroeById(id)
            Log.d("@dev", "superHeroe = $superheroe")
        }
    }
}