package com.sedsoftware.weatherapp.data.server

import com.google.gson.Gson
import com.sedsoftware.weatherapp.BuildConfig
import java.net.URL

class ForecastRequest(val zipCode: Long) {

  companion object {
    private val APP_ID = BuildConfig.OPENWEATHER_API_KEY
    private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
    private val COMPLETE_URL = "${URL}&APPID=${APP_ID}&q="
  }

  fun execute(): ForecastResult {
    val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
    return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
  }
}