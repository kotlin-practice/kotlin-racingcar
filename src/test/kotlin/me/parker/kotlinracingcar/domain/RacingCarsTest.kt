package me.parker.kotlinracingcar.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import java.lang.Exception
import java.lang.IllegalArgumentException

class RacingCarsTest : DescribeSpec({
    describe("경주 자동차들 객체 생성") {
        context("정상적으로 생성된 RacingCar 객체 리스트가 주어지면") {
            it("예외없이 RacingCars 객체를 생성하고 반환한다.") {
                val racingCarList: List<RacingCar> = CarNameTest.normalNames
                    .map { name -> RacingCar(name) }
                    .toList()

                shouldNotThrow<Exception> {
                    RacingCars(racingCarList)
                }
            }
        }

        context("빈 RacingCar 객체 리스트가 주어지면") {
            it("생성할 수 없다는 예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    RacingCars(listOf())
                }
            }
        }
    }

    describe("경주 자동차들 중에서 가장 멀리 이동한 자동차들(0 ~ N개) 구하기") {

    }
}) {
}