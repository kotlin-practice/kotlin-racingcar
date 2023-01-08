package me.parker.kotlinracingcar.domain

class Car(carName: String) {
    val carName: CarName

    var position: Int

    init {
        this.carName = CarName(carName)
        this.position = 0
    }

    fun move(moveNumber: Int) {
        this.position = when {
            canMoveForward(moveNumber) -> this.position + 1
            else -> if (this.position > 0) this.position - 1 else 0
        }
    }

    private fun canMoveForward(moveNumber: Int): Boolean {
        return moveNumber >= 4;
    }

}