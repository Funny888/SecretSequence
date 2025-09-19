package com.fynny.secretsequence.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.funny.local.ds.theme.AppTheme
import com.funny.navigation.SecretSequenceNavigation
import com.fynny.secretsequence.application.SecretSequenceApplication

class SecretSequenceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecretSequenceApplication().component.inject(this)
            AppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    SecretSequenceNavigation()
                }
            }
        }
    }
}