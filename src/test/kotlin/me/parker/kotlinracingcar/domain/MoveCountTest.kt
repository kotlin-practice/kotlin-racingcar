package me.parker.kotlinracingcar.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual

class MoveCountTest : DescribeSpec({
    describe("MoveCount 객체 생성") {
        context("자연수가 주어지면") {
            it("MoveCount 객체가 정상적으로 생성되고 이를 반환한다.") {
                naturalNumbers.forAll {
                    shouldNotThrow<Exception> {
                        MoveCount(it)
                    }
                    MoveCount(it).value.shouldBeGreaterThanOrEqual(0)
                }
            }
        }
        context("숫자 0이 주어지면") {
            it("IllegalArgumentException 예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    MoveCount(0)
                }
            }
        }
        context("0보다 작은 숫자가 주어지면") {
            it("IllegalArgumentException 예외를 던진다.") {
                negativeNumbers.forAll {
                    shouldThrow<IllegalArgumentException> {
                        MoveCount(it)
                    }
                }
            }
        }
    }
}) {
    companion object {
        val naturalNumbers = listOf(1, 2, 3, 10, 100, 5000)
        val negativeNumbers = listOf(-1, -10, -100);
    }
}