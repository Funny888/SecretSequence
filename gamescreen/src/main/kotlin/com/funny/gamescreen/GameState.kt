package com.funny.gamescreen

data class GameState(
    private val id: Int?

) {
    companion object {
        val EMPTY = GameState(null)
    }
}




