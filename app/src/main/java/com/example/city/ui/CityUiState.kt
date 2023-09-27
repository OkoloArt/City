package com.example.city.ui

import com.example.city.data.LocalPlaceProvider
import com.example.city.model.Places
import com.example.city.ui.utils.CurrentScreen

data class CityUiState(
    val places : List<Places> = emptyList() ,
    val currentCategory: String = "" ,
    val currentPLace: Places = LocalPlaceProvider.defaultPlace,
    val currentScreen: CurrentScreen = CurrentScreen.HOME,
    val previousScreen: CurrentScreen = CurrentScreen.HOME
)