package me.parker.kotlinracingcar.domain

import me.parker.kotlinracingcar.random.RandomGenerator

class RacingCars(val racingCarList: List<RacingCar>) {
    companion object {
        const val START_RANDOM_NUMBER = 0
        const val END_RANDOM_NUMBER = 9
    }

    init {
        checkValidList(racingCarList)
    }

    fun race(moveCount: MoveCount) {
        for (i in 1..moveCount.value) {
            racingCarList.forEach { racingCar ->
                val randomNumber = RandomGenerator.getNumber(START_RANDOM_NUMBER, END_RANDOM_NUMBER)
                racingCar.move(randomNumber)
            }
        }
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

    override fun toString(): String {
        return "RacingCars(racingCarList=$racingCarList)"
    }
}