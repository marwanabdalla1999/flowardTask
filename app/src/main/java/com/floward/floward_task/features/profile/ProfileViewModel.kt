package com.floward.floward_task.features.profile

import com.floward.floward_task.core.bases.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() :
    BaseViewModel<ProfileState, ProfileEvent, ProfileEffect>() {

    override fun setInitialState(): ProfileState = ProfileState()

    override fun handleEvents(event: ProfileEvent) {

    }
}
