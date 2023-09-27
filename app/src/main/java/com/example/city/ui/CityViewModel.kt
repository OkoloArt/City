package com.example.city.ui

import androidx.lifecycle.ViewModel
import com.example.city.data.LocalPlaceProvider
import com.example.city.model.Places
import com.example.city.ui.utils.CurrentScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CityViewModel : ViewModel (){

    private val _cityUiState = MutableStateFlow(
            CityUiState(
                    places = LocalPlaceProvider.getPlacesData(),
                    currentPLace = LocalPlaceProvider.getPlacesData().getOrElse(0){
                        LocalPlaceProvider.defaultPlace
                    },
                    currentCategory = "Temples"
            ))
    val cityUiState : StateFlow<CityUiState> = _cityUiState.asStateFlow()

    fun updateCurrentCategory(category : String){
        _cityUiState.update {
            it.copy(
                    currentCategory = category,
                    currentScreen = CurrentScreen.PLACES
            )
        }
    }

    fun updateCurrentPlaces(place: Places){
        _cityUiState.update {
            it.copy(
                    currentPLace = place,
                    currentScreen = CurrentScreen.DETAILS

            )
        }
    }

    fun updatePreviousScreen(previousScreen: CurrentScreen){
        _cityUiState.update {
            it.copy(
                    previousScreen = previousScreen
            )
        }
    }

    fun navigateBack(currentScreen: CurrentScreen){
        val previousScreen = _cityUiState.value.previousScreen
        if (currentScreen == CurrentScreen.PLACES){
            _cityUiState.update {
                it.copy(
                        currentScreen = CurrentScreen.HOME
                )
            }
        }else if (currentScreen == CurrentScreen.DETAILS && previousScreen == CurrentScreen.HOME){
            _cityUiState.update {
                it.copy(
                        currentScreen = CurrentScreen.HOME
                )
            }
        }else if (currentScreen == CurrentScreen.DETAILS && previousScreen == CurrentScreen.PLACES){
            _cityUiState.update {
                it.copy(
                        currentScreen = CurrentScreen.PLACES
                )
            }
        }
    }

}