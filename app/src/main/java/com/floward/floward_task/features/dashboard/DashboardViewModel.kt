package com.floward.floward_task.features.dashboard

import androidx.lifecycle.viewModelScope
import com.floward.floward_task.core.bases.BaseViewModel
import com.floward.floward_task.domain.useCases.IGetWeatherUseCase
import com.floward.floward_task.features.dashboard.mappers.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getWeatherUseCase: IGetWeatherUseCase
) : BaseViewModel<DashboardState, DashboardEvent, DashboardEffect>() {

    override fun setInitialState(): DashboardState = DashboardState()

    override fun handleEvents(event: DashboardEvent) {
        when (event) {
            is DashboardEvent.LoadWeather -> fetchWeather()
            is DashboardEvent.SetFeedBack -> setState { copy(feedBack = event.feedBack) }
            is DashboardEvent.SendFeedback -> setEffect { DashboardEffect.SendFeedback(event.feedBack) }
        }
    }

    private fun fetchWeather() {
        setState { copy(isLoading = true) }

        viewModelScope.launch {
            try {
                val weather = getWeatherUseCase("Cairo")
                setState { copy(isLoading = false, weather = weather.toUiModel()) }
            } catch (e: Exception) {
                setState { copy(isLoading = false) }
                setEffect { DashboardEffect.ShowError("Failed to load weather") }
            }
        }
    }
}
