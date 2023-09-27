package com.example.city.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Places(
    @DrawableRes val imageResourcesId : Int,
    @StringRes val titleResourcesId : Int,
    @StringRes val descriptionResourcesId : Int,
    @StringRes val category : Int,
    var isPopularRecommendation: Boolean = false
)
