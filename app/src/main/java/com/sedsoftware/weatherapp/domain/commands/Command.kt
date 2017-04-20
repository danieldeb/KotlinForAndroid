package com.sedsoftware.weatherapp.domain.commands

interface Command<T> {
    fun execute(): T
}