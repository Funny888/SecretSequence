package com.funny.navigation.ext

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
inline fun <reified VM : ViewModel> injectViewModel(
    key: String? = null,
    crossinline createViewModel: () -> VM
): VM =
    viewModel(
        key = key,
        modelClass = VM::class,
        factory = object : ViewModelProvider.Factory {
            override fun <VM : ViewModel> create(modelClass: Class<VM>): VM {
                return createViewModel() as VM
            }
        }
    )