package com.funny.local.ds.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text


@Composable
fun LocalDsText(
    text: String,
    fontSize: TextUnit = 16.sp,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        letterSpacing = TextUnit(2F, TextUnitType.Sp),
        lineHeight = TextUnit(1.2F, TextUnitType.Em),
        fontSize = fontSize,
        modifier = modifier,
    )
}

@Composable
@Preview
private fun Preview() {
    LocalDsText("Test")
}