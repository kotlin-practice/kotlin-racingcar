package me.parker.kotlinracingcar.domain

import java.lang.IllegalArgumentException

class RacingCars(private val racingCarList: List<RacingCar>) {

    init {
        checkValidList(racingCarList)
    }

    fun searchTheFurthestCars(): List<RacingCar> {
        val furthestPosition = furthestPosition();
        if (furthestPosition == 0) {
            return emptyList()
        }

        return racingCarList.filter { rc -> rc.position == furthestPosition }
    }

    private fun furthestPosition(): Int {
        return racingCarList.maxOf { rc -> rc.position }
    }

    private fun checkValidList(racingCarList: List<RacingCar>) {
        if (racingCarList.isEmpty()) {
            throw IllegalArgumentException("빈 리스트로는 생성할 수 없습니다!")
        }
    }
}