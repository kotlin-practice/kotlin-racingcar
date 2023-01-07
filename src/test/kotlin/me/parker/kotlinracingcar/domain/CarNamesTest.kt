package me.parker.kotlinracingcar.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize

class CarNamesTest : DescribeSpec({
    describe("CarNames 객체(일급컬렉션) 생성") {
        context("5자 이하의 알파벳만 포함된 이름과 쉼표로 구분된 문자열이 주어지면") {
            it("정상적으로 CarNames 객체가 생성되고 반환한다.") {
                shouldNotThrow<Exception> {
                    CarNames(normalNames)
                    CarNames(normalNamesIncludingSpace)
                }
            }
            it("정상적으로 CarNames 객체가 생성되고 반환하고, 내부 자동차 이름 리스트에도 정상적으로 저장된다.") {
                CarNames(normalNames).carNamesList
                    .shouldHaveSize(7)

            }
        }
        context("입력 문자열에 공백 또는 NULL이 주어지면") {
            shouldThrow<IllegalArgumentException> {
                CarNames(emptyNames)
            }
        }
        context("입력 문자열에 쉼표 사이사이 공백이 주어진 경우") {
            namesIncludeEmpty.forAll {
                shouldThrow<IllegalArgumentException> {
                    CarNames(it)
                }
            }
        }
        context("입력 문자열 이름에 잘못된 자동차 이름이 포함된 경우") {
            namesIncludeInvalidName.forAll {
                shouldThrow<IllegalArgumentException> {
                    CarNames(it)
                }
            }
        }
    }
}) {
    companion object {
        const val normalNames = "mike,tom,a,aaa,abc,MIKE,BBBBB"
        const val normalNamesIncludingSpace = "mike, tom, a, aaa, abc, MIKE, BBBBB"

        const val emptyNames = ""

        val namesIncludeEmpty = listOf("mike,,karl,park", ",,,", ",,mike,karl,park", "mike,karl,park,,")
        val namesIncludeInvalidName = listOf("mike,karl,parker", "aaaaaaa,bb,c", "mike,123", "mike,누구누구")
    }
}