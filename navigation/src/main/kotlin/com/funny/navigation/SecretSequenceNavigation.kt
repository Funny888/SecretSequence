package com.funny.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.funny.gamescreen.GameScreen
import com.funny.main.data.ScreenMainEvent
import com.funny.main.presentation.screen.MainScreen
import com.funny.settings.screen.SettingsScreen
import com.funny.splash.screen.SplashScreen
import kotlinx.serialization.Serializable

sealed class Destination {
    @Serializable
    object Splash : Destination()

    @Serializable
    object Main : Destination()

    @Serializable
    data class Game(val id: Int?) : Destination()

    @Serializable
    object Settings : Destination()
}


@Composable
fun SecretSequenceNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destination.Splash) {
        composable<Destination.Splash> {
            SplashScreen {
                navController.navigate(Destination.Main)
            }
        }
        composable<Destination.Main> {
            MainScreen(event = {
                navController.navigate(handleNavigateFromMain(it))
            })
        }
        composable<Destination.Game> {
            GameScreen()
        }
        composable<Destination.Settings> {
            SettingsScreen()
        }
    }
}

private fun handleNavigateFromMain(event: ScreenMainEvent): Destination = when (event) {
    ScreenMainEvent.EventAboutGame -> Destination.Splash
    is ScreenMainEvent.EventContinueGame -> Destination.Game(event.id)
    ScreenMainEvent.EventNewGame -> Destination.Game(null)
    ScreenMainEvent.EventSettings -> Destination.Settings
}
