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
import kotlin.random.Random

@Composable
fun GameLine(
    isRandom: Boolean = false,
    stateItemsStone: List<Triple<Boolean, Coordinate, GameStoneVariant>> = emptyList()
) {
    var coordinate by remember { mutableStateOf(Coordinate(0.dp, 0.dp)) }
    Row(
        modifier =
            Modifier
                .padding(vertical = 40.dp)
                .onGloballyPositioned { position ->
                    coordinate = Coordinate(
                        coordinateX = position.positionInRoot().x.dp,
                        coordinateY = position.positionInRoot().y.dp
                    )
                }) {
        var xOffset = coordinate.coordinateX
        repeat(10) {
            val result = Random.nextInt(2)
            val idImage = if (result == 0) GameStoneVariant.WHITE else GameStoneVariant.BLACK
            GameItem(
                stone = if (isRandom) {
                    idImage
                } else {
                    if (stateItemsStone.isNullOrEmpty().not()
                        && stateItemsStone.size == 10
                        && stateItemsStone[it].first
                    ) {
                        stateItemsStone[it].third
                    } else {
                        GameStoneVariant.NONE
                    }
                },
                coordinate = if (it != 0) {
                    xOffset += 40.dp
                    coordinate.copy(coordinateX = xOffset)
                } else {
                    coordinate
                }
            )

        }
    }
}

@Preview
@Composable
private fun Preview() {
    GameLine(true)
}