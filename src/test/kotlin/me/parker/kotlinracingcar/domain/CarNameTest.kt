package me.parker.kotlinracingcar.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import java.lang.IllegalArgumentException

class CarNameTest : DescribeSpec({
    describe("CarName 객체 생성") {
        context("5자 이하의 알파벳만 포함된 문자열이 주어지면") {
            it("정상적으로 CarName 객체가 생성되고 반환한다.") {
                normalNames.forAll {
                    shouldNotThrow<Exception> {
                        CarName(it)
                    }
                }
            }
        }

        context("5자보다 큰 크기의 문자열이 주어지면") {
            it("IllegalArgumentException 예외를 던진다.") {
                namesBiggerThanSize.forAll {
                    shouldThrow<IllegalArgumentException> {
                        CarName(it)
                    }
                }
            }
        }

        context("알파벳이 아닌 문자가 포함된 문자열이 주어지면") {
            it("IllegalArgumentException 예외를 던진다.") {
                namesIncludingNotAlphabet.forAll {
                    shouldThrow<IllegalArgumentException> {
                        CarName(it)
                    }
                }
            }
        }
    }
}) {
    companion object {
        val normalNames = listOf("mike", "tom", "a", "aaa", "abc", "MIKE", "BBBBB")
        val namesBiggerThanSize = listOf("aaaaaa", "bbbbbbbbbb")
        val namesIncludingNotAlphabet = listOf("a1", "1b", "1234", "홍길동", "mike1", "a#")
    }
}