package me.parker.kotlinracingcar.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe

class RacingCarTest : DescribeSpec({
    describe("경주 자동차 객체 생성") {
        context("유효한 자동차 이름 객체(CarName)가 주어지면") {
            it("예외없이 자동차 객체를 생성하고 반환한다.") {
                CarNameTest.normalNames.forAll {
                    shouldNotThrow<Exception> {
                        RacingCar(CarName(it))
                    }
                }
            }
            it("자동차는 최초 생성시 이동거리는 0으로 초기화된다.") {
                CarNameTest.normalNames.forAll {
                    RacingCar(CarName(it)).position.shouldBe(0)
                }
            }
        }
    }
    describe("경주 자동차 이동하기") {
        context("4 이상 숫자가 주어지면") {
            it("현재 위치(position)에서 1 증가한다.") {
                val racingCar = RacingCar(CarName("mike"))
                moveForwards.forAll {
                    val currentPosition = racingCar.position
                    racingCar.move(it)
                    racingCar.position.shouldBeGreaterThan(currentPosition)
                    racingCar.position.shouldBe(currentPosition + 1)
                }
            }
        }
        context("3 이하 숫자가 주어지면") {
            it("현재 위치(position)에서 1 감소한다.") {
                val racingCar = RacingCar(CarName("mike"))
                racingCar.move(5)
                racingCar.move(5)
                racingCar.move(5)
                racingCar.move(5)
                racingCar.move(5)

                moveBackwards.forAll {
                    val currentPosition = racingCar.position
                    racingCar.move(it)
                    racingCar.position.shouldBeLessThan(currentPosition)
                    racingCar.position.shouldBe(currentPosition - 1)
                }
            }
            it("현재 위치가 0인 경우는 그대로 0이 된다.") {
                val racingCar = RacingCar(CarName("mike"))
                racingCar.position.shouldBe(0)
                racingCar.move(0)
                racingCar.position.shouldBe(0)
            }
        }
    }
}) {
    companion object {
        val moveForwards = listOf(4, 5, 6, 7, 8, 9)
        val moveBackwards = listOf(0, 1, 2, 3)
    }
}