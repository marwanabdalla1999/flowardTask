package com.floward.floward_task.data.repositoriesImpl

import com.floward.floward_task.data.dataSource.remoteDataSource.WeatherApiService
import com.floward.floward_task.data.mappers.toDomain
import com.floward.floward_task.domain.model.Weather
import com.floward.floward_task.domain.repositories.IWeatherRepository

class WeatherRepositoryImpl(
    private val api: WeatherApiService,
    private val apiKey: String
) : IWeatherRepository {

    override suspend fun getWeather(city: String): Weather {
        val response = api.getWeather(city = city, apiKey = apiKey)
        if (response.isSuccessful){
            return response.body()?.toDomain()?:throw Exception("can't parse response")
        }
        else{
            throw Exception("can't get weather")
        }
    }
}
