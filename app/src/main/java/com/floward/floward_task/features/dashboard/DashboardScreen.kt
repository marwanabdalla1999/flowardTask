package com.floward.floward_task.features.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.floward.floward_task.core.ui.snackBars.LocalAppSnackBarHostState
import kotlinx.coroutines.flow.Flow

@Composable
fun DashboardScreen(
    state: DashboardState,
    effect: Flow<DashboardEffect>,
    setEvent: (DashboardEvent) -> Unit,
    onSendFeedback: (String) -> Unit
) {
    val snackBarHostState = LocalAppSnackBarHostState.current

    LaunchedEffect(Unit) {
        setEvent(DashboardEvent.LoadWeather)
    }

    LaunchedEffect(Unit) {
        effect.collect { effect ->
            when (effect) {
                is DashboardEffect.ShowError -> {
                    snackBarHostState.showSnackbar(effect.message)
                }

                is DashboardEffect.SendFeedback -> onSendFeedback(effect.feedBack)
            }
        }
    }

    when {
        state.isLoading -> CircularProgressIndicator()
        state.weather != null -> {
            Column(horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)) {
                AsyncImage(state.weather.iconUrl,contentDescription = null)
                Text("City: ${state.weather.city}")
                Text("Temp: ${state.weather.temperature}°C")
                Text("Condition: ${state.weather.condition}")

                Spacer(Modifier.height(16.dp))
                OutlinedTextField(
                    value = state.feedBack,
                    onValueChange = { setEvent(DashboardEvent.SetFeedBack(it)) },
                    label = { Text("Feedback") }
                )
                Spacer(Modifier.height(16.dp))

                Button(onClick = { setEvent(DashboardEvent.SendFeedback(state.feedBack)) }) {
                    Text("Send Feedback")
                }
            }
        }
    }
}

