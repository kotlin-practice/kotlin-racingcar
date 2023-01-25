package me.parker.kotlinracingcar.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.collections.shouldNotBeEmpty
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

    describe("경주 자동차들 경주 경기하기") {
        context("race(MoveCount) 메서드를 호출하면") {
            it("경주 결과는 객체 내부의 레이싱 자동차 리스트에 기록된다.") {
                val racingCarList: List<RacingCar> = CarNameTest.normalNames
                    .map { name -> RacingCar(name) }
                    .toList()

                val racingCars = RacingCars(racingCarList)
                val moveCount = MoveCount(10)

                racingCars.searchTheFurthestCars().shouldBeEmpty()
                racingCars.race(moveCount)
                racingCars.searchTheFurthestCars().shouldNotBeEmpty()
            }
        }
    }

    describe("경주 자동차들 중에서 가장 멀리 이동한 자동차들(0 ~ N개) 구하기") {
        context("searchTheFurthestCars 메서드를 호출하면") {
            val numToGo = 5
            val racingCarList: List<RacingCar> = CarNameTest.normalNames
                .map { name -> RacingCar(name) }
                .toList()

            it("모든 경주 자동차가 제자리(거리 == 0)인 경우, 빈 리스트를 반환한다.") {
                val racingCars = RacingCars(racingCarList)

                racingCars.searchTheFurthestCars().shouldBeEmpty()
            }

            it("가장 멀리 이동한 경주 자동차가 1개인 경우, 경주 자동차가 1개인 리스트를 반환한다.") {
                racingCarList[2].move(numToGo);racingCarList[2].move(numToGo)
                racingCarList[3].move(numToGo)
                val racingCars = RacingCars(racingCarList)

                racingCars.searchTheFurthestCars().shouldHaveSize(1)
            }

            it("가장 멀리 이동한 경주 자동차가 2개 이상인 경우, 경주 자동차가 해당 개수만큼 있는 리스트를 반환한다.") {
                racingCarList[5].move(numToGo);racingCarList[5].move(numToGo)
                racingCarList[0].move(numToGo)
                val racingCars = RacingCars(racingCarList)

                racingCars.searchTheFurthestCars().shouldHaveSize(2)
            }
        }
    }
}) {
}