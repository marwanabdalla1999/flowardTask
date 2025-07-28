package com.floward.floward_task.core.ui.snackBars

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.staticCompositionLocalOf

val LocalAppSnackBarHostState = staticCompositionLocalOf<SnackbarHostState> {
    error("SnackBarHostState not provided")
}