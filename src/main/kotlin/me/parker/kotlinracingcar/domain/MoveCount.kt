package me.parker.kotlinracingcar.domain

import java.lang.IllegalArgumentException

class MoveCount(val value: Int) {
    init {
        checkValid(value)
    }

    private fun checkValid(value: Int) {
        if (value <= 0) {
            throw IllegalArgumentException("시도 횟수는 0 또는 0보다 작을 수 없습니다.")
        }
    }
}