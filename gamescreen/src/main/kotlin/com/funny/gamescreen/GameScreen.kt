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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    viewModel: GameScreenViewModel,
) {
    val state = viewModel.state.collectAsState().value
    Box(modifier = Modifier.fillMaxSize()) {
        var xOffset by remember { mutableFloatStateOf(0F) }
        var yOffset by remember { mutableFloatStateOf(0F) }
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

            if (isChanged) {
                viewModel.changeStone(
                    state.firstPlayerState.first().copy(
                        first = isChanged,
                        third = GameStoneVariant.WHITE
                    )
                )
            }

            GameLine(stateItemsStone = state.firstPlayerState)
            GameLine(stateItemsStone = state.randomLineState)
            GameLine(stateItemsStone = state.secondPlayerState)
        }
    }

    LaunchedEffect(key1 = Unit) {

    }
}

@Preview
@Composable
private fun Preview() {
    GameScreen(
        viewModel = GameScreenViewModel()
    )
}