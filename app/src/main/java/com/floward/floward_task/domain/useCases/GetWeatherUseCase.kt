package com.floward.floward_task.domain.useCases


import com.floward.floward_task.domain.model.Weather
import com.floward.floward_task.domain.repositories.IWeatherRepository

class GetWeatherUseCase(private val repository: IWeatherRepository): IGetWeatherUseCase{
   override suspend operator fun invoke(city: String): Weather {
        return repository.getWeather(city)
    }
}
