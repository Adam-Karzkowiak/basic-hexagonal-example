package com.tdd.filmrental.film.domain

class FilmCreator {
    internal fun from(filmDto: FilmDto) = Film(
        name = filmDto.name,
        filmType = FilmType.valueOf(filmDto.filmTypeDto.name)
    )
}