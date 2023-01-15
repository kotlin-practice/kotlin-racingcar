package me.parker.kotlinracingcar.domain

import java.lang.IllegalArgumentException

class RacingCars(racingCarList: List<RacingCar>) {

    init {
        checkValidList(racingCarList)
    }

    private fun checkValidList(racingCarList: List<RacingCar>) {
        if (racingCarList.isEmpty()) {
            throw IllegalArgumentException("빈 리스트로는 생성할 수 없습니다!")
        }
    }
}