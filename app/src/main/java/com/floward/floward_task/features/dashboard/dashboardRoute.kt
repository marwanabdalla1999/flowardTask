package com.floward.floward_task.features.dashboard

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.floward.floward_task.core.ui.navigations.DashboardDestination


fun NavGraphBuilder.dashboardRoute(
    onSendFeedback: (String) -> Unit
) {

    composable<DashboardDestination> {
        val viewModel: DashboardViewModel = hiltViewModel()
        val state by viewModel.viewState.collectAsStateWithLifecycle()

        DashboardScreen(
            state = state,
            effect = viewModel.effect,
            setEvent = viewModel::setEvent,
            onSendFeedback = onSendFeedback
        )
    }
}