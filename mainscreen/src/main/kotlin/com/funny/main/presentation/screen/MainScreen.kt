package com.funny.main.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.funny.local.ds.buttons.LocalDsButtonMenu
import com.funny.local.ds.text.LocalDsText
import com.funny.local.ds.theme.AppTheme
import com.funny.main.data.ScreenMainEvent
import com.funny.main.presentation.strings.MainScreenStrings

@Composable
fun MainScreen(event: (ScreenMainEvent) -> Unit) {
    AppTheme {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
        ) {
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxSize(1F)
                    .padding(it)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(vertical = 100.dp)
                ) {
                    LocalDsText(
                        text = MainScreenStrings.title,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 40.dp)
                    )

                    LocalDsButtonMenu(text = MainScreenStrings.newGame) {
                        event.invoke(
                            ScreenMainEvent.EventNewGame
                        )
                    }
                    LocalDsButtonMenu(text = MainScreenStrings.continueGame) {
                        event.invoke(
                            ScreenMainEvent.EventNewGame
                        )
                    }
                    LocalDsButtonMenu(text = MainScreenStrings.settings) {
                        event.invoke(
                            ScreenMainEvent.EventSettings
                        )
                    }
                    LocalDsButtonMenu(text = MainScreenStrings.aboutGame) {
                        event.invoke(
                            ScreenMainEvent.EventAboutGame
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
private fun Preview() {
    MainScreen(event = {})
}