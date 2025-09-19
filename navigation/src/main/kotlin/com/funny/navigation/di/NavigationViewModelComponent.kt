package com.funny.navigation.di

import com.funny.gamescreen.GameScreenViewModel
import dagger.Component

@Component(modules = [GameModule::class])
interface NavigationViewModelComponent {

    fun getGameScreenViewModel(): GameScreenViewModel
}