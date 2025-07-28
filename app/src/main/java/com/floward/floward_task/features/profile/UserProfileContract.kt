package com.floward.floward_task.features.profile

import com.floward.floward_task.core.ui.models.UserProfile
import com.trianglz.ui.base.ViewEvent
import com.trianglz.ui.base.ViewSideEffect
import com.trianglz.ui.base.ViewState



data class ProfileState(
    val profile: UserProfile = UserProfile(
        name = "Marwan Ahmed",
        email = "marwan@example.com",
        avatarUrl = "https://i.pravatar.cc/150?img=3")
) : ViewState

sealed class ProfileEvent : ViewEvent

sealed class ProfileEffect : ViewSideEffect
