package com.tdd.filmrental.film.domain

data class Film(
    val name: String,
    val filmType: FilmType
) {

    fun dto(film: Film) = FilmDto(
        name = film.name,
        filmTypeDto = FilmTypeDto.valueOf(film.filmType.name)
    )


}

enum class FilmType {
    NEW, OLD
}

