package com.tdd.filmrental.film.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

internal class InMemoryFilmRepository : FilmRepository {

    private val filmsToRent = mutableListOf<Film>()

    override fun save(film: Film): Film {
        filmsToRent.add(film)
        return film
    }

    override fun getAll(pageable: Pageable): Page<Film> {
        return PageImpl(filmsToRent, pageable, filmsToRent.size.toLong())
    }

    override fun getByName(name: String): Film {
        return filmsToRent.find {
            it.name == name
        }!!
    }
}