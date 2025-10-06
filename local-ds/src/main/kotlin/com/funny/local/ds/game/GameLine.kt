package com.funny.local.ds.game

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.funny.utils.Coordinate

private const val SIZE_LINE = 10
private val SIZE_CELL = 40.dp

@Composable
fun GameLine(
    stateItemsStone: List<Triple<Boolean, Coordinate, GameStoneVariant>> = emptyList()
) {
    var coordinate by remember { mutableStateOf(Coordinate(0.dp, 0.dp)) }
    Row(
        modifier =
            Modifier
                .padding(vertical = SIZE_CELL)
                .onGloballyPositioned { position ->
                    coordinate = Coordinate(
                        coordinateX = position.positionInRoot().x.dp,
                        coordinateY = position.positionInRoot().y.dp
                    )
                }) {
        if (stateItemsStone.isEmpty().not()
            && stateItemsStone.size == SIZE_LINE
        ) {
            buildLine(
                stateItemsStone = stateItemsStone,
                coordinate = coordinate,
            )
        }
    }
}

@Composable
private fun buildLine(
    stateItemsStone: List<Triple<Boolean, Coordinate, GameStoneVariant>> = emptyList(),
    coordinate: Coordinate,
) {
    var xOffset = coordinate.coordinateX
    repeat(stateItemsStone.size) {
        GameItem(
            stone = stateItemsStone[it].third,
            coordinate = if (it != 0) {
                xOffset += SIZE_CELL
                coordinate.copy(coordinateX = xOffset)
            } else {
                coordinate
            }
        )
    }
}

@Preview
@Composable
private fun Preview() {
    GameLine(listOf())
}