package com.tdd.filmrental

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FilmRentalApplication

fun main(args: Array<String>) {
	runApplication<FilmRentalApplication>(*args)
}
