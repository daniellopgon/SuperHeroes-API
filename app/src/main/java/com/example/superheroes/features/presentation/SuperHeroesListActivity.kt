package com.example.superheroes.features.presentation

import SuperHeroAdapter
import SuperHeroesDataRepository
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroes.R
import com.example.superheroes.core.api.ApiClient
import com.example.superheroes.features.data.remote.api.SuperHeroesApiRemoteDataSource
import com.example.superheroes.features.domain.GetAllSuperHeroesUseCase
import com.example.superheroes.features.domain.GetSuperHeroeByIdUseCase

class SuperHeroesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val recyclerView = findViewById<RecyclerView>(R.id.SuperHeroes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SuperHeroAdapter(listaSuperHeroes)

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val apiClient: ApiClient = ApiClient()
        val api = SuperHeroesApiRemoteDataSource(apiClient)
        val dataRepository = SuperHeroesDataRepository(api)
        val getAllSuperHeroesUseCase = GetAllSuperHeroesUseCase(dataRepository)
        val getSuperHeroeByIdUseCase = GetSuperHeroeByIdUseCase(dataRepository)
        val viewModel = SuperHeroesListViewModel(getAllSuperHeroesUseCase,getSuperHeroeByIdUseCase)

        viewModel.loadSuperHeroes()
        viewModel.loadSuperHeroeById("1")
    }
}