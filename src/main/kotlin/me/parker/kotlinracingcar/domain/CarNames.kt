package me.parker.kotlinracingcar.domain

class CarNames {
    companion object {
        const val COMMA: String = ",";
    }
    val carNamesList: List<String>;

    constructor(carNames: String) {
        this.carNamesList = convertToNameList(carNames);
    }

    private fun convertToNameList(carNames: String): List<String> {
        return carNames.split(COMMA)
    }
}