package com.floward.floward_task.features.dashboard.mappers

import com.floward.floward_task.core.ui.models.AppWeatherModel
import com.floward.floward_task.data.models.WeatherResponse
import com.floward.floward_task.domain.model.Weather

fun Weather.toUiModel() = AppWeatherModel(
    city = this.city,
    temperature = this.temperature,
    condition = this.condition,
    iconUrl = this.iconUrl
)