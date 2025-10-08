package com.example.superheroapi.features.data.remote.api

import com.example.superheroapi.features.domain.SuperHeroe

fun SuperHeroApiModel.toModel(): SuperHeroe {
    return SuperHeroe(
        this.id,
        this.name,
        this.slug,
        this.images.md
    )
}