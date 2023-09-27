package com.example.city.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.city.R
import com.example.city.model.Places
import com.example.city.ui.utils.CurrentScreen


@Composable
fun HomeScreen(cityUiState: CityUiState , cityViewModel: CityViewModel , modifier: Modifier= Modifier){
    cityViewModel.updatePreviousScreen(CurrentScreen.HOME)
    LazyColumn (modifier = modifier.padding(12.dp)){
        item {
            Text(text = "Popular",
                 style = MaterialTheme.typography.bodyLarge,
                 textAlign = TextAlign.Center,
                 modifier = Modifier
                     .padding(top = 5.dp)
            )
        }
        item {
            PopularRecommendations(
                    popularPlaces = cityUiState.places.filter { it.isPopularRecommendation } ,
                    onItemClick = { cityViewModel.updateCurrentPlaces(it)} ,
                    modifier = Modifier.padding(top = 14.dp))
        }
        item {
            Text(
                    text = "Categories" ,
                    style = MaterialTheme.typography.bodyLarge ,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 20.dp)
            )
        }
        item {
            CategoriesList(onClick = { cityViewModel.updateCurrentCategory(it) },
                           modifier = Modifier.padding(top = 12.dp))
        }
    }
}

@Composable
fun CategoriesList(onClick : (String) -> Unit, modifier: Modifier = Modifier){
    val categoryList = mapOf(
            "Temples" to R.drawable.lotus_image ,
            "Shopping Centres" to R.drawable.ala_moana ,
            "Cinemas" to R.drawable.rio_cinema ,
            "Restaurants" to R.drawable.steirereck,
            "Coffee Shops" to R.drawable.rosetta_roastery)

    val categoryListPairs: List<Pair<String, Int>> = categoryList.toList()

    Column(modifier = modifier.padding(5.dp),
           verticalArrangement = Arrangement.spacedBy(10.dp)) {
        categoryListPairs.forEach { categoryPair ->
            ListItem(category = categoryPair, onItemClick = { onClick(categoryPair.first) })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItem(category: Pair<String, Int>, onItemClick: (String) -> Unit, modifier: Modifier = Modifier) {
    Card(
            elevation = CardDefaults.cardElevation() ,
            modifier = modifier ,
            shape = RoundedCornerShape(5.dp) ,
            onClick = { onItemClick(category.first) } ,
    ) {
        Row(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
        ) {

            Image(
                    painter = painterResource(id = category.second) ,
                    contentDescription = null , // Provide a meaningful description
                    contentScale = ContentScale.Crop ,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(shape = RoundedCornerShape(5.dp))
            )

            Text(
                    text = category.first,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold ,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .align(alignment = Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun PopularRecommendations(
    popularPlaces: List<Places> ,
    onItemClick: (Places) -> Unit,
    modifier: Modifier = Modifier ,
    contentPadding: PaddingValues = PaddingValues(0.dp) ,){

    LazyRow(
            contentPadding = contentPadding,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier
    ){
       items(items = popularPlaces){ recommendations ->
           PopularRecommendationLstItem(place =  recommendations, onClick = { onItemClick(it)})
       }
    }
}


@Composable
fun PopularRecommendationLstItem(place: Places , onClick: (Places) -> Unit, modifier: Modifier = Modifier){
    Card ( modifier = Modifier.clickable { onClick(place) }) {
        Box {
            val defaultImage = painterResource(id = place.imageResourcesId)
            Image(painter = defaultImage ,
                  contentDescription = null ,
                  modifier = Modifier
                      .width(180.dp)
                      .height(130.dp) ,
                  contentScale = ContentScale.FillBounds)
            Text(text = stringResource(id = place.titleResourcesId) ,
                 style = MaterialTheme.typography.bodySmall ,
                 fontSize = 12.sp ,
                 modifier = Modifier.align(alignment = Alignment.BottomCenter ))
        }
    }
}

@Composable
fun DefaultPreview(){
    CategoriesList(onClick = {})
}
