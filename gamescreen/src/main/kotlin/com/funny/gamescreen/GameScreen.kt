package com.funny.gamescreen

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.funny.local.ds.game.GameItem
import com.funny.local.ds.game.GameLine
import com.funny.local.ds.game.GameStoneVariant
import com.funny.utils.Coordinate
import kotlin.math.roundToInt

@Composable
fun GameScreen(
    state: GameState
) {
    Box(modifier = Modifier.fillMaxSize()) {
        var xOffset by remember { mutableFloatStateOf(0F) }
        var yOffset by remember { mutableFloatStateOf(0F) }
        val listStoneState = remember {
            mutableStateListOf(fullDateList()).flatten().toMutableStateList()
        }

        GameItem(
            stone = GameStoneVariant.WHITE, modifier = Modifier
                .offset {
                    IntOffset(
                        xOffset.roundToInt(),
                        yOffset.roundToInt()
                    )
                }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        xOffset += dragAmount.x
                        yOffset += dragAmount.y
                    }
                },
            Coordinate(xOffset.dp, yOffset.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth(1F)
                .padding(vertical = 200.dp)
        ) {
            val isChanged =
                (xOffset.dp > 105.dp && xOffset.dp < 125.dp) && (yOffset.dp > 710.dp && yOffset.dp < 730.dp)
            listStoneState[0] =
                listStoneState.first().copy(first = isChanged, third = GameStoneVariant.WHITE)
            GameLine(
                false,
                listStoneState
            )

            GameLine(
                true
            )
            GameLine(
                false
            )
        }
    }

    LaunchedEffect(key1 = Unit) {

    }
}

private fun fullDateList(): Collection<Triple<Boolean, Coordinate, GameStoneVariant>> {
    return listOf(
        Triple(
            false,
            Coordinate(435.dp, 810.dp),
            GameStoneVariant.NONE
        ),
        Triple(
            false,
            Coordinate(0.dp, 0.dp),
            GameStoneVariant.NONE
        ),
        Triple(
            false,
            Coordinate(0.dp, 0.dp),
            GameStoneVariant.NONE
        ),
        Triple(
            false,
            Coordinate(0.dp, 0.dp),
            GameStoneVariant.NONE
        ),
        Triple(
            false,
            Coordinate(0.dp, 0.dp),
            GameStoneVariant.NONE
        ),
        Triple(
            false,
            Coordinate(0.dp, 0.dp),
            GameStoneVariant.NONE
        ),
        Triple(
            false,
            Coordinate(0.dp, 0.dp),
            GameStoneVariant.NONE
        ),
        Triple(
            false,
            Coordinate(0.dp, 0.dp),
            GameStoneVariant.NONE
        ),
        Triple(
            false,
            Coordinate(0.dp, 0.dp),
            GameStoneVariant.NONE
        ),
        Triple(
            false,
            Coordinate(0.dp, 0.dp),
            GameStoneVariant.NONE
        )
    )
}

@Preview
@Composable
private fun Preview() {
    GameScreen(state = GameState.EMPTY)
}