package com.funny.gamescreen

import com.funny.local.ds.game.GameStoneVariant
import com.funny.utils.Coordinate

data class GameState(
    val firstPlayerState: MutableList<Triple<Boolean, Coordinate, GameStoneVariant>>,
    val randomLineState: List<Triple<Boolean, Coordinate, GameStoneVariant>>,
    val secondPlayerState: MutableList<Triple<Boolean, Coordinate, GameStoneVariant>>
)




