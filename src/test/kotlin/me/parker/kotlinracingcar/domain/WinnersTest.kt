package me.parker.kotlinracingcar.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldHaveSize
import java.lang.Exception

class WinnersTest : DescribeSpec({
    describe("Winner 객체 생성") {
        context("정상적인 RacingCars 객체가 주어지면") {
            val racingCarList: List<RacingCar> = CarNameTest.normalNames
                .map { name -> RacingCar(CarName(name)) }
                .toList()

            val numToGo = 5
            racingCarList[2].move(numToGo);racingCarList[2].move(numToGo)
            racingCarList[3].move(numToGo)

            val racingCars = RacingCars(racingCarList)

            it("예외없이 Winner 객체를 생성한다.") {
                shouldNotThrow<Exception> {
                    Winners(racingCars)
                }
            }

            it("정상적으로 생성된 Winner 객체는 우승자가 되는 RacingCar 리스트를 갖는다.") {
                val winners = Winners(racingCars)

                winners.wonRacingCars.shouldHaveSize(1)
            }
        }
    }
}) {
}