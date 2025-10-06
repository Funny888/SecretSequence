package com.funny.gamescreen

import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.funny.local.ds.game.GameStoneVariant
import com.funny.utils.Coordinate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class GameScreenViewModel(
    // TODO: в планах сделать, что бы можно было игру доигрывать
    private val id: Int? = null
) : ViewModel() {

    private var _state = MutableStateFlow(startState())
    val state = _state.asStateFlow()


    fun changeStone(change: Triple<Boolean, Coordinate, GameStoneVariant>) {
        _state.update {
            it.copy(
                firstPlayerState = it.firstPlayerState.mapIndexed { index, triple ->
                    if (index == 0) {
                        triple.copy(
                            change.first,
                            change.second,
                            GameStoneVariant.WHITE
                        )
                    } else triple
                }.toMutableList()
            )
        }
    }

    private fun startState(): GameState {
        return GameState(
            firstPlayerState = emptyGameLine(startCoordinate = startLineFirstPlayer),
            randomLineState = randomGameLine(),
            secondPlayerState = emptyGameLine(startCoordinate = startLineSecondPlayer)
        )
    }

    private fun emptyGameLine(startCoordinate: Coordinate): MutableList<Triple<Boolean, Coordinate, GameStoneVariant>> {
        var xOffset = startCoordinate.coordinateX
        return List(SIZE_LINE) {
            Triple(
                first = false,
                second = Coordinate(
                    coordinateX = xOffset + SIZE_CELL,
                    coordinateY = startCoordinate.coordinateY
                ),
                third = GameStoneVariant.NONE
            )
        }.toMutableList()
    }

    private fun randomGameLine(): List<Triple<Boolean, Coordinate, GameStoneVariant>> {
        var xOffset = startRandomLine.coordinateX
        return List(SIZE_LINE) {
            val result = Random.nextBoolean()
            val idImage = if (result) GameStoneVariant.WHITE else GameStoneVariant.BLACK
            Triple(
                first = true,
                second = Coordinate(
                    coordinateX = xOffset + SIZE_CELL,
                    coordinateY = startRandomLine.coordinateY
                ),
                third = idImage
            )
        }
    }

    private companion object {
        private const val SIZE_LINE = 10
        private val SIZE_CELL = 40.dp
        private val START_LINE_Y = 30.dp
        private val startLineFirstPlayer = Coordinate(260.dp, START_LINE_Y)
        private val startRandomLine = Coordinate(460.dp, START_LINE_Y)
        private val startLineSecondPlayer = Coordinate(660.dp, START_LINE_Y)
    }
}