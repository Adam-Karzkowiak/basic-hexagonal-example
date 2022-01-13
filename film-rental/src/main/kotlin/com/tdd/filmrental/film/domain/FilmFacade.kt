package com.tdd.filmrental.film.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

class FilmFacade(
    private val filmCreator: FilmCreator,
    private val filmRepository: FilmRepository
) {

    fun add(filmDto: FilmDto): Film {
        val film = filmCreator.from(filmDto)
        return filmRepository.save(film)
    }

    fun findAll(pageable: Pageable) = filmRepository.getAll(pageable)
        .map { film ->
            film.dto(film)
        }

    fun show(name: String): FilmDto {
        val film = filmRepository.getByName(name)
        return film.dto(film)
    }
}