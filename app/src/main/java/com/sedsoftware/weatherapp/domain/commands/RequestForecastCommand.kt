package com.sedsoftware.weatherapp.domain.commands

import com.sedsoftware.weatherapp.domain.datasource.ForecastProvider
import com.sedsoftware.weatherapp.domain.model.ForecastList

class RequestForecastCommand(
    val zipCode: Long,
    val forecastProvider: ForecastProvider = ForecastProvider()) :
    Command<ForecastList> {

  companion object {
    val DAYS = 7
  }

  override fun execute(): ForecastList {
    return forecastProvider.requestByZipCode(zipCode, DAYS)
  }
}