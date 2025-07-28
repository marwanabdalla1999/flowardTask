package com.floward.floward_task.core.ui.navigations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.floward.floward_task.features.dashboard.dashboardRoute
import com.floward.floward_task.features.profile.profileRoute


@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = DashboardDestination
    ) {
        dashboardRoute { message ->
            navController.navigate(ProfileDestination(feedbackMessage = message)){
                popUpTo(navController.graph.startDestinationId) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }

        profileRoute()
    }
}
