package me.parker.kotlinracingcar.random

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeInRange

class RandomGeneratorTest : DescribeSpec({
    describe("RandomGenerator 클래스는") {
        context("getNumber(시작 숫자, 끝 숫자) 메서드를 호출하면") {
            val startRandomNumber = 0;
            val endRandomNumber = 9;

            it("시작 숫자 <= 결과 숫자 <= 끝 숫자의 조건을 만족하는 랜덤한 숫자를 반환한다.") {
                RandomGenerator.getNumber(startRandomNumber, endRandomNumber)
                    .shouldBeInRange(IntRange(startRandomNumber, endRandomNumber))
            }

            it("(100번 반복) 시작 숫자 <= 결과 숫자 <= 끝 숫자의 조건을 만족하는 랜덤한 숫자를 반환한다.") {
                for (i in 1..100) {
                    RandomGenerator.getNumber(startRandomNumber, endRandomNumber)
                        .shouldBeInRange(IntRange(startRandomNumber, endRandomNumber))
                }
            }
        }
    }
}) {}