package com.example.superheroapi.features.data.remote.api


fun SuperHeroApiModel.toModel(): SuperHeroe{
    return SuperHeroe(
        this.id,
        this.name,
        this.slug,
        this.images.md
    )
}