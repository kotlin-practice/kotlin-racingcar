package me.parker.kotlinracingcar.random

import java.security.SecureRandom

class RandomGenerator {
    companion object {
        fun getNumber(startNumber: Int, enNumber: Int): Int {
            val random = SecureRandom()

            return random.nextInt((enNumber - startNumber) + 1) + startNumber
        }
    }

}