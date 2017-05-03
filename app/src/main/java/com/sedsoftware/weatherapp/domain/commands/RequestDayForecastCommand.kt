package com.sedsoftware.weatherapp.domain.commands

import com.sedsoftware.weatherapp.domain.datasource.ForecastProvider
import com.sedsoftware.weatherapp.domain.model.Forecast

class RequestDayForecastCommand(
    val id: Long,
    val forecastProvider: ForecastProvider = ForecastProvider()) :
    Command<Forecast> {

  override fun execute() = forecastProvider.requestForecast(id)
}