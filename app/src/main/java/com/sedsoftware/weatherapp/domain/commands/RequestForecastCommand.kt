package com.sedsoftware.weatherapp.domain.commands

import com.sedsoftware.weatherapp.data.ForecastRequest
import com.sedsoftware.weatherapp.domain.mappers.ForecastDataMapper
import com.sedsoftware.weatherapp.domain.model.ForecastList

class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(
                forecastRequest.execute()
        )
    }

}