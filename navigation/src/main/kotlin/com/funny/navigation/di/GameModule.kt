package com.funny.navigation.di

import com.funny.gamescreen.GameScreenViewModel
import dagger.Module
import dagger.Provides

@Module
object GameModule {

    @Provides
    fun provideGameViewModel() = GameScreenViewModel()
}