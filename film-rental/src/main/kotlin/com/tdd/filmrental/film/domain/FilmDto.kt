package com.tdd.filmrental.film.domain

data class FilmDto(
    val name: String,
    val filmTypeDto: FilmTypeDto
)

enum class FilmTypeDto {
    NEW, OLD
}