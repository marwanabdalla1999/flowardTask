package com.floward.floward_task.features.profile

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.floward.floward_task.core.ui.navigations.ProfileDestination

fun NavGraphBuilder.profileRoute(){

    composable<ProfileDestination>{ backStackEntry ->
        val feedback = backStackEntry.toRoute<ProfileDestination>().feedbackMessage
        val viewModel: ProfileViewModel = hiltViewModel()
        val state by viewModel.viewState.collectAsStateWithLifecycle()
        ProfileScreen(feedBackMessage = feedback,state = state)
    }
}