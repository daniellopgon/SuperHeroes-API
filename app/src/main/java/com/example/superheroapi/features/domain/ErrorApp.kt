package com.example.superheroapi.features.domain

sealed class ErrorApp: Throwable() {

    object InternetConexionError : ErrorApp()

    object ServerErrorApp : ErrorApp()

}