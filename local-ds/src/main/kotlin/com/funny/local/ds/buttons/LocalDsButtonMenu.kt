package com.funny.local.ds.buttons

import android.graphics.Color
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.funny.local.ds.R
import com.funny.local.ds.theme.AppTheme

@Composable
fun LocalDsButtonMenu(
    isEnabled: Boolean = true,
    text: String = "",
    @DrawableRes image: Int? = null,
    modifier: Modifier = Modifier.size(200.dp, 50.dp),
    action: () -> Unit
) {
    AppTheme {
        Button(
            onClick = action,
            enabled = isEnabled,
            elevation = ButtonDefaults.elevation(4.dp),
            colors = ButtonDefaults.buttonColors(),
            shape = Shapes(
                small = RoundedCornerShape(18.dp),
                medium = RoundedCornerShape(18.dp),
                large = RoundedCornerShape(18.dp),
                ).small,
            modifier = modifier.padding(vertical = 8.dp),
        ) {
            Row {
                if (image != null) {
                    Image(
                        painter = painterResource(image),
                        contentDescription = "image",
                        modifier = Modifier.weight(0.2F)
                    )
                }
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1.8F)
                        .align(Alignment.CenterVertically)
                        .padding(start = 4.dp)
                )
            }
        }
    }
}

@Composable
@Preview(backgroundColor = Color.BLUE.toLong(), showBackground = true)
private fun Preview() {
    LocalDsButtonMenu(
        text = "Test",
        image = R.drawable.yin_and_yang_symbol
    ) { }
}