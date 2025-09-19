package com.funny.gamescreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameScreenViewModel(
    private val id: Int? = null
): ViewModel() {

    private var _state = MutableStateFlow(GameState.EMPTY)
    val state = _state.asStateFlow()

    init {
        _state.tryEmit(GameState(1))
    }
}