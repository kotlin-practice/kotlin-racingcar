package me.parker.kotlinracingcar.domain

class RacingCar(val carName: CarName) {
    var position: Int

    init {
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

    override fun toString(): String {
        return "RacingCar(carName=$carName, position=$position)"
    }
}