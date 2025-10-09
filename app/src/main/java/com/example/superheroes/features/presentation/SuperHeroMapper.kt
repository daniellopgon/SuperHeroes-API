package com.example.superheroes.features.presentation

import com.example.superheroes.features.domain.SuperHeroe

fun SuperHeroe.toUiModel(): SuperHeroeUiModel {
    return SuperHeroeUiModel(
        name = this.name,
        slug = this.slug
    )
}