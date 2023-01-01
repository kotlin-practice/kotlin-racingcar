package me.parker.kotlinracingcar.domain

import java.lang.IllegalArgumentException

class CarName(val name: String) {

    init {
        checkValidName(name)
    }

    private fun checkValidName(inputName: String) {
        if (inputName.length > 5) {
            throw IllegalArgumentException("자동차 이름의 길이는 5자를 넘을 수 없습니다.")
        }
    }

    override fun toString(): String {
        return "CarName(name='$name')"
    }
}