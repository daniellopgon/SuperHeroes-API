package com.example.superheroes.features.data.remote.api

import com.example.superheroes.features.domain.SuperHeroe

fun SuperHeroApiModel.toModel(): SuperHeroe {
    return SuperHeroe(
        this.id,
        this.name,
        this.slug,
        this.images.md
    )
}