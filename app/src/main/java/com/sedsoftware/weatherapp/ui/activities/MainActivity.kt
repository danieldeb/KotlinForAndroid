package com.sedsoftware.weatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.sedsoftware.weatherapp.BuildConfig
import com.sedsoftware.weatherapp.R
import com.sedsoftware.weatherapp.data.Request
import com.sedsoftware.weatherapp.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)

        val apiKey = BuildConfig.OPENWEATHER_API_KEY

        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?APPID=$apiKey" +
                "&q=Krasnodar&mode=json&units=metric&cnt=7"

        async {
            Request(url).run()
            uiThread { longToast("Request performed") }
        }
    }
}
