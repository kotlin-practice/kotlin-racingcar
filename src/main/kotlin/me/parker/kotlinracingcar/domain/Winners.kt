package me.parker.kotlinracingcar.domain

class Winners(racingCars: RacingCars) {
    val wonRacingCars: List<RacingCar>

    init {
        wonRacingCars = racingCars.searchTheFurthestCars()
    }

    override fun toString(): String {
        return "Winners(wonRacingCars=$wonRacingCars)"
    }
}