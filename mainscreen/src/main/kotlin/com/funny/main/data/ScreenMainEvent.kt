package com.funny.main.data

sealed class ScreenMainEvent {
    object EventNewGame: ScreenMainEvent()
    data class EventContinueGame(val id: Int): ScreenMainEvent()
    object EventSettings: ScreenMainEvent()
    object EventAboutGame: ScreenMainEvent()
}