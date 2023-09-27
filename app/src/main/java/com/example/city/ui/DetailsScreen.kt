package com.example.city.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.city.R
import com.example.city.data.LocalPlaceProvider
import com.example.city.model.Places
import com.example.city.ui.utils.CurrentScreen


@Composable
fun DetailLayout(place: Places, modifier: Modifier = Modifier){

    LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(12.dp)
    ) {
        item {
            Surface(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(top = 10.dp)
            ) {
                Image(
                        painter = painterResource(id = place.imageResourcesId) ,
                        contentScale = ContentScale.FillBounds ,
                        contentDescription = stringResource(id = place.titleResourcesId) ,
                        modifier = Modifier.size(350.dp, 200.dp)
                )
            }
        }
        item {
            Text(
                    text = stringResource(id = place.titleResourcesId),
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.padding(top = 14.dp)
            )
        }
        item {
            Text(
                    text = stringResource(id = place.descriptionResourcesId),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 14.dp)
            )
        }
    }
}

@Preview
@Composable
fun DetailPreview(){

    val place = LocalPlaceProvider.defaultPlace
    DetailLayout(place = place)
}
