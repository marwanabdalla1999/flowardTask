package com.floward.floward_task.data.mappers

import com.floward.floward_task.data.models.WeatherResponse
import com.floward.floward_task.domain.model.Weather

fun WeatherResponse.toDomain() = Weather(
    city = this.name,
    temperature = this.main.temp,
    condition = this.weather.firstOrNull()?.description?:"UnKnown",
    iconUrl = "https://openweathermap.org/img/wn/${this.weather.firstOrNull()?.icon}@2x.png"
)