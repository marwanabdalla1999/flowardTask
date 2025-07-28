package com.floward.floward_task.domain.repositories

import com.floward.floward_task.domain.model.Weather

interface IWeatherRepository {
    suspend fun getWeather(city: String): Weather
}
