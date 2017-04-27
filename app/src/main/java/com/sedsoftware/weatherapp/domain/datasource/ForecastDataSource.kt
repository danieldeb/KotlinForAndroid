package com.sedsoftware.weatherapp.domain.datasource

import com.sedsoftware.weatherapp.domain.model.ForecastList

interface ForecastDataSource {
  fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
}