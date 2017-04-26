package com.sedsoftware.weatherapp.domain.commands

import com.sedsoftware.weatherapp.data.server.ForecastRequest
import com.sedsoftware.weatherapp.domain.mappers.ForecastDataMapper
import com.sedsoftware.weatherapp.domain.model.ForecastList

class RequestForecastCommand(val zipCode: Long) : Command<ForecastList> {

  override fun execute(): ForecastList {
    val forecastRequest = ForecastRequest(zipCode)
    return ForecastDataMapper().convertFromDataModel(zipCode,
        forecastRequest.execute()
    )
  }

}