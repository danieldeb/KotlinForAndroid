package com.sedsoftware.weatherapp.ui

import android.app.Application
import com.sedsoftware.weatherapp.extensions.DelegatesExt

class App : Application() {

  companion object {
    var instance: App by DelegatesExt.notNullSingleValue()
  }

  override fun onCreate() {
    super.onCreate()
    instance = this
  }
}