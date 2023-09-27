package com.example.city.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.city.R
import com.example.city.ui.utils.CityContentType
import com.example.city.ui.utils.CurrentScreen

@Composable
fun CityApp( windowWidthSize : WindowWidthSizeClass ){

    val cityViewModel : CityViewModel = viewModel()
    val cityUiState by cityViewModel.cityUiState.collectAsState()

    val contentType: CityContentType = when(windowWidthSize){
        WindowWidthSizeClass.Compact ->{
            CityContentType.ListOnly
        }
        WindowWidthSizeClass.Medium -> {
            CityContentType.ListOnly
        }
        WindowWidthSizeClass.Expanded -> {
            CityContentType.ListAndDetail
        }
        else -> {
            CityContentType.ListOnly
        }
    }

    if (contentType == CityContentType.ListAndDetail){
        CityListAndDetails(
                cityUiState = cityUiState ,
                cityViewModel = cityViewModel)
    }else{
        Scaffold(
                topBar = {
                    CityTopBar(
                            onBackButtonClick = { cityViewModel.navigateBack(cityUiState.currentScreen) } ,
                            currentScreen = cityUiState.currentScreen )
                }
        ) { innerPadding ->
            when (cityUiState.currentScreen) {
                CurrentScreen.HOME -> {
                    HomeScreen(cityUiState = cityUiState ,
                               cityViewModel = cityViewModel ,
                               modifier = Modifier.padding(innerPadding))
                }

                CurrentScreen.PLACES -> {
                    PlacesListLayout(
                            cityViewModel = cityViewModel,
                            placeList = cityUiState.places.filter {
                                stringResource(id = it.category) == cityUiState.currentCategory
                            } ,
                            onClick = { cityViewModel.updateCurrentPlaces(it) } ,
                            modifier = Modifier.padding(innerPadding)
                    )
                }

                CurrentScreen.DETAILS -> {
                    DetailLayout(
                            place = cityUiState.currentPLace,
                            modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityTopBar(
    onBackButtonClick: () -> Unit,
    currentScreen: CurrentScreen,
    modifier: Modifier = Modifier
){
    TopAppBar(
            title = { Text(text = when (currentScreen) {
                CurrentScreen.PLACES -> { "Places" }

                CurrentScreen.DETAILS -> { "Details" }

                else -> { "City" }
            }
            ) } ,
            navigationIcon = if (currentScreen == CurrentScreen.DETAILS || currentScreen == CurrentScreen.PLACES) {
                {
                    IconButton(onClick = onBackButtonClick) {
                        Icon(
                                imageVector = Icons.Filled.ArrowBack ,
                                contentDescription = stringResource(R.string.back_button)
                        )
                    }
                }
            }
            else {
                { Box {} }
            })
}

@Composable
fun CityListAndDetails(
    cityUiState: CityUiState,
    cityViewModel: CityViewModel,
    modifier: Modifier = Modifier
) {
    Row(
            modifier = modifier.fillMaxWidth()
    ) {
        Box(
                modifier = Modifier.weight(0.9f)
        ) {
            HomeScreen(cityUiState = cityUiState ,
                       cityViewModel = cityViewModel)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Box(
                modifier = Modifier.weight(1.2f)
        ) {
            Scaffold(
                    topBar = {
                        ListAndDetailTopBar(onBackButtonClick = { cityViewModel.navigateBack(cityUiState.currentScreen) } ,
                                            currentScreen = cityUiState.currentScreen )
                    }
            ) { innerPadding ->
                ShowPlacesOrDetails(
                        currentScreen = cityUiState.currentScreen ,
                        cityUiState = cityUiState ,
                        cityViewModel = cityViewModel,
                        modifier = Modifier.padding(innerPadding))
            }
        }
    }
}


@Composable
fun ShowPlacesOrDetails(
    currentScreen: CurrentScreen, cityUiState: CityUiState,
    cityViewModel: CityViewModel,
    modifier: Modifier = Modifier){
    when (currentScreen) {
        CurrentScreen.PLACES -> {
            PlacesListLayout(
                    cityViewModel = cityViewModel,
                    placeList = cityUiState.places.filter {
                        stringResource(id = it.category) == cityUiState.currentCategory
                    },
                    onClick = { cityViewModel.updateCurrentPlaces(it) },
                    modifier = modifier
            )
        }

        CurrentScreen.DETAILS -> {
            DetailLayout(
                    place = cityUiState.currentPLace,
                    modifier = modifier)
        }

        else -> {
            PlacesListLayout(
                    cityViewModel = cityViewModel,
                    placeList = cityUiState.places.filter {
                        stringResource(id = it.category) == cityUiState.currentCategory
                    },
                    onClick = { cityViewModel.updateCurrentPlaces(it) },
                    modifier = modifier
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListAndDetailTopBar(
    onBackButtonClick: () -> Unit,
    currentScreen: CurrentScreen,
    modifier: Modifier = Modifier){
    TopAppBar(
            title = { Text(text = when (currentScreen) {
                CurrentScreen.PLACES -> { "Places" }

                CurrentScreen.DETAILS -> { "Details" }

                else -> { "Places" }
            }
            ) } ,
            navigationIcon = if (currentScreen == CurrentScreen.DETAILS) {
                {
                    IconButton(onClick = onBackButtonClick) {
                        Icon(
                                imageVector = Icons.Filled.ArrowBack ,
                                contentDescription = stringResource(R.string.back_button)
                        )
                    }
                }
            }
            else {
                { Box {} }
            })
}


@Preview(widthDp = 1000, showBackground = true)
@Composable
fun CityPreview(){

    val viewModel : CityViewModel = viewModel()
    val cityUiState by viewModel.cityUiState.collectAsState()

    CityListAndDetails(cityUiState = cityUiState , cityViewModel = viewModel )

}
