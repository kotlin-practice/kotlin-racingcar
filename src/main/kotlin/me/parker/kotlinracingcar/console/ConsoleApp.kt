package me.parker.kotlinracingcar.console

import me.parker.kotlinracingcar.domain.CarNames
import me.parker.kotlinracingcar.domain.MoveCount
import me.parker.kotlinracingcar.domain.RacingCar
import me.parker.kotlinracingcar.domain.RacingCars

fun main(args: Array<String>) {
    println(">> 자동차 경주 게임 <<")
    println("경주 자동차 이름을 입력해주세요! (이름 규칙: 5자 이하 알파벳만, 여러 대는 ,(쉼표)로 구분해주세요!)")
    print("입력 > ")
    val inputNames = readln()
    println("입력 결과: $inputNames")

    println()

    println("경주 자동차들이 이동할 수 있는 기회를 몇 번 줄 것인지 입력해주세요! (자연수만 입력)")
    print("입력 > ")
    val inputMoveCount: Int = readln().toInt()
    println("입력 결과: $inputMoveCount")

    println(">> 자동차 경주 시작!! <<")
    println(">  자동차 경주중...")
    val racingCars = RacingCars(CarNames(inputNames).carNamesList.map { carName ->
        RacingCar(carName)
    })
    racingCars.race(MoveCount(inputMoveCount))

    println(">> 자동차 경주 결과 <<")
    racingCars.racingCarList.forEach {
            racingCar ->
        print(racingCar.carName.toString().padEnd(7, ' ') + ": ")
        println("-".repeat(racingCar.position))
    }
    print("우승자: ${racingCars.searchTheFurthestCars()}")
}