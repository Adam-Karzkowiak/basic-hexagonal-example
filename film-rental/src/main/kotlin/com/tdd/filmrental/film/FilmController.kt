package com.tdd.filmrental.film

import com.tdd.filmrental.film.domain.FilmFacade
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FilmController(private val filmFacade: FilmFacade) {

    @GetMapping("/films")
    fun getFilms(pageable: Pageable) = filmFacade.findAll(pageable)

    @GetMapping("/film/{name}")
    fun getFilm(@PathVariable name: String) = filmFacade.show(name)
}