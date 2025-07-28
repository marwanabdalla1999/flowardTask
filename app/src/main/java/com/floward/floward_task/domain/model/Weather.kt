package com.floward.floward_task.domain.model

data class Weather(
    val city: String,
    val temperature: Double,
    val condition: String,
    val iconUrl: String
)
