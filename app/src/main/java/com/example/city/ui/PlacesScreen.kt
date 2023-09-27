package com.example.city.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.city.R
import com.example.city.model.Places
import com.example.city.ui.utils.CurrentScreen

@Composable
fun PlacesListLayout(cityViewModel: CityViewModel,placeList: List<Places> ,
                     onClick: (Places) -> Unit , modifier: Modifier = Modifier) {
    cityViewModel.updatePreviousScreen(CurrentScreen.PLACES)
    LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp) ,
            modifier = modifier.fillMaxWidth().padding(12.dp)
    ) {
        items(items = placeList) { place ->
            PlaceListItem(place = place, onItemClick = onClick)

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceListItem(place: Places, onItemClick: (Places) -> Unit, modifier: Modifier = Modifier) {

    val context = LocalContext.current.applicationContext

    // Load the original image
    val originalBitmap = BitmapFactory.decodeResource(context.resources , place.imageResourcesId)
    val scaledBitmap = Bitmap.createScaledBitmap(originalBitmap , 200 , 200 , true)

    Card(
            elevation = CardDefaults.cardElevation() ,
            modifier = modifier ,
            shape = RoundedCornerShape(5.dp) ,
            onClick = {onItemClick(place)}
    ) {
        Row(modifier = Modifier.padding(5.dp).fillMaxWidth()) {

            // Use the Image composable to display the image
            Image(
                    bitmap = scaledBitmap.asImageBitmap(),
                    contentDescription = null, // Provide a meaningful description
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(shape = RoundedCornerShape(5.dp))
            )

            Text(
                    text = stringResource(id = place.titleResourcesId),
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .align(alignment = Alignment.CenterVertically)
            )
        }
    }
}

//@Preview
//@Composable
//fun PlaceListPreview(){
//    val viewModel : CityViewModel = viewModel()
//    val cityUiState by viewModel.cityUiState.collectAsState()
//
//    PlacesListLayout(
//            placeList = cityUiState.places.filter {
//                stringResource(id = it.category) == cityUiState.currentCategory },
//            onClick = { viewModel.updateCurrentPlaces(it)},
//    )
//}


