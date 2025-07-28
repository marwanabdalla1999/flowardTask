package com.floward.floward_task.domain.useCases

import com.floward.floward_task.domain.model.Weather

interface IGetWeatherUseCase {
    suspend operator fun invoke(city: String): Weather
}