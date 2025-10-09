package com.example.superheroes.features.domain

sealed class ErrorApp: Throwable() {

    object InternetConexionError : ErrorApp()

    object ServerErrorApp : ErrorApp()

}