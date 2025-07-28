package com.floward.floward_task.core.ui.navigations

import kotlinx.serialization.Serializable


@Serializable
sealed interface Destination

@Serializable
data object DashboardDestination : Destination

@Serializable
data class ProfileDestination(val feedbackMessage: String = "") : Destination