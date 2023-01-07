package me.parker.kotlinracingcar.domain

import java.lang.IllegalArgumentException

class CarNames(carNames: String) {
    companion object {
        const val COMMA: String = ","
    }

    val carNamesList: List<CarName>

    init {
        this.carNamesList = convertToNameList(carNames)
    }

    private fun convertToNameList(carNames: String): List<CarName> {
        if (carNames.isEmpty()) {
            throw IllegalArgumentException("자동차 이름 입력 문자열은 비어있을 수 없습니다.")
        }

        val carNamesWithoutSpace = carNames.replace(" ", "");

        return carNamesWithoutSpace.split(COMMA).map { CarName(it) }.toList()
    }

    override fun toString(): String {
        return "CarNames(carNamesList=$carNamesList)"
    }


}