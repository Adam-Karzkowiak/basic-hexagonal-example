package com.tdd.filmrental.film.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.Repository;

interface FilmRepository : Repository<Film, String> {
    fun save(film: Film): Film
    fun getAll(pageable: Pageable): Page<Film>
    fun getByName(name: String): Film
}