package com.funny.local.ds.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = Colors(
            primary = Color(0xBE65EADE),
            primaryVariant = Color(0xFF4EB0A7),
            secondary = Color(0xFF6DE890),
            secondaryVariant = Color(0xFF5DC97A),
            background = Color(0xFF76B3E8),
            surface = Color(0xFFB7AEAE),
            error = Color(0xFFA91414),
            onPrimary = Color(0xFF0E1F4D),
            onSecondary = Color(0xFF051D65),
            onBackground = Color(0xFF1D4F80),
            onSurface = Color(0xFFB9C6D3),
            onError = Color(0xFFC03636),
            isLight = true
        ),
        typography = MaterialTheme.typography,
        shapes = MaterialTheme.shapes,
        content = content,
    )
}