package com.floward.floward_task.core.ui.navigations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.floward.floward_task.features.dashboard.DashboardScreen
import com.floward.floward_task.features.dashboard.dashboardRoute
import com.floward.floward_task.features.profile.ProfileScreen
import com.floward.floward_task.features.profile.ProfileViewModel
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
            navController.navigate(ProfileDestination(feedbackMessage = message))
        }

        profileRoute()
    }
}
