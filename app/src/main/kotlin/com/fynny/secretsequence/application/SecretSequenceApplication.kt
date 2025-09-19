package com.fynny.secretsequence.application

import android.app.Application
import com.fynny.secretsequence.di.DaggerAppComponent

class SecretSequenceApplication: Application() {
    val component = DaggerAppComponent.builder().appContext(this).build()
}