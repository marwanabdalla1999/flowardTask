package com.floward.floward_task.features.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.floward.floward_task.core.ui.snackBars.LocalAppSnackBarHostState

@Composable
fun ProfileScreen(state: ProfileState,feedBackMessage: String) {
    val snackBarHostState = LocalAppSnackBarHostState.current

    LaunchedEffect(Unit) {
        snackBarHostState.showSnackbar(feedBackMessage)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AsyncImage(state.profile.avatarUrl, contentDescription = null)
        Text(state.profile.name)
        Text(state.profile.email)

    }
}

