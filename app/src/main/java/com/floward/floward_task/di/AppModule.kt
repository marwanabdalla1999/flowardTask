package com.floward.floward_task.di

import com.floward.floward_task.BuildConfig
import com.floward.floward_task.data.dataSource.remoteDataSource.WeatherApiService
import com.floward.floward_task.data.repositoriesImpl.WeatherRepositoryImpl
import com.floward.floward_task.domain.repositories.IWeatherRepository
import com.floward.floward_task.domain.useCases.GetWeatherUseCase
import com.floward.floward_task.domain.useCases.IGetWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://api.openweathermap.org/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        val client = OkHttpClient.Builder().addInterceptor(logging).build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherApiService(retrofit: Retrofit): WeatherApiService =
        retrofit.create(WeatherApiService::class.java)

    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherApiService): IWeatherRepository =
        WeatherRepositoryImpl(api, apiKey = BuildConfig.OPEN_WEATHER_API_KEY)

    @Provides
    @Singleton
    fun provideGetWeatherUseCase(repository: IWeatherRepository): IGetWeatherUseCase =
        GetWeatherUseCase(repository)
}
