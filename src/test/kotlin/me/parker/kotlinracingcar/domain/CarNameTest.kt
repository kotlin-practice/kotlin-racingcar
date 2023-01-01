package me.parker.kotlinracingcar.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll

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
    }
}) {
    companion object {
        val normalNames = listOf("mike", "tom", "a", "aaa", "abc", "MIKE", "BBBBB")
    }
}