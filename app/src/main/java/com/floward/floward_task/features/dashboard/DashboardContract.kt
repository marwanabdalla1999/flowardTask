package com.floward.floward_task.features.dashboard

import com.trianglz.ui.base.ViewEvent
import com.trianglz.ui.base.ViewSideEffect
import com.trianglz.ui.base.ViewState
import com.floward.floward_task.core.ui.models.AppWeatherModel

data class DashboardState(
    val isLoading: Boolean = false,
    val weather: AppWeatherModel? = null,
    val feedBack:String = ""
) : ViewState


sealed class DashboardEvent : ViewEvent {
    data object LoadWeather : DashboardEvent()
    data class SetFeedBack(val feedBack: String) : DashboardEvent()
    data class SendFeedback(val feedBack: String) : DashboardEvent()
}

sealed class DashboardEffect : ViewSideEffect {
    data class ShowError(val message: String) : DashboardEffect()
    data class SendFeedback(val feedBack: String) : DashboardEffect()
}
