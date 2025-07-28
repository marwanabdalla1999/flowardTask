package com.floward.floward_task.core.ui.models

data class AppWeatherModel(
    val city: String,
    val temperature: Double,
    val condition: String,
    val iconUrl: String
)
