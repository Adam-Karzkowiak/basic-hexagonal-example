package com.tdd.filmrental.film.domain

import spock.lang.Specification
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

class FilmSpec extends Specification {
    FilmFacade facade = new FilmConfiguration().filmFacade()

    FilmDto lalaLand = createFilmDto("La la land", FilmTypeDto.NEW)
    FilmDto dune = createFilmDto("Dune", FilmTypeDto.NEW)

    def 'should add film'() {
        when: "we add a film"
        facade.add(lalaLand)

        then: "system has this film"
        facade.show(lalaLand.name) == lalaLand
    }

    def 'should list films'() {
        given: "we add a film"
        facade.add(lalaLand)
        facade.add(dune)

        when: "we ask for all films"
        Page<FilmDto> foundFilms = facade.findAll(PageRequest.of(0, 10))

        then: "system should return the films we have added"
        foundFilms.contains(lalaLand)
        foundFilms.contains(dune)
    }

    static private FilmDto createFilmDto(String title, FilmTypeDto type) {
        return new FilmDto(title, type)
    }
}