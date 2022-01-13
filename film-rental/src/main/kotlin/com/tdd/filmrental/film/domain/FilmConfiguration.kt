package com.tdd.filmrental.film.domain

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class FilmConfiguration {

    @Bean
    fun filmFacade(): FilmFacade {
        val filmRepository = InMemoryFilmRepository()
        val filmCreator = FilmCreator()
        return FilmFacade(
            filmCreator, filmRepository
        )
    }
}