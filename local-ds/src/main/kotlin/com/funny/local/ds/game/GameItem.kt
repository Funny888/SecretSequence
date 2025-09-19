package com.funny.local.ds.game


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.funny.local.ds.R
import com.funny.utils.Coordinate

@Composable
fun GameItem(
    stone: GameStoneVariant,
    modifier: Modifier = Modifier,
    coordinate: Coordinate

) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.size(35.dp)) {
        Image(
            painter = painterResource(id = getImageStone(stone)),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
        Log.d("teeest coordinate", "coordinate GameLine: ${coordinate.coordinateX} ${coordinate.coordinateY}")
    }
}

private fun getImageStone(gameStoneVariant: GameStoneVariant): Int = when (gameStoneVariant) {
    GameStoneVariant.WHITE -> R.drawable.white_stone
    GameStoneVariant.BLACK -> R.drawable.black_stone
    GameStoneVariant.NONE -> R.drawable.empty_area
}

class GameItemsPreviewParameterProvider : PreviewParameterProvider<Int> {
    override val values = sequenceOf(
        R.drawable.white_stone,
        R.drawable.black_stone,
        R.drawable.empty_area
    )
}

enum class GameStoneVariant {
    WHITE,
    BLACK,
    NONE
}

@Preview
@Composable
private fun Preview(
    @PreviewParameter(GameItemsPreviewParameterProvider::class) item: Int
) {
    GameItem(GameStoneVariant.BLACK, coordinate = Coordinate(0.dp, 0.dp))
}