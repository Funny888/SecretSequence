package com.fynny.secretsequence.di

import android.content.Context
import com.fynny.secretsequence.presentation.SecretSequenceActivity
import dagger.BindsInstance
import dagger.Component

@Component
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun appContext(appContext: Context): Builder
        fun build(): AppComponent
    }

    fun inject(activity: SecretSequenceActivity)
}