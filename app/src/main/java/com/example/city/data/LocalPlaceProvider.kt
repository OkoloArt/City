package com.example.city.data

import com.example.city.R
import com.example.city.model.Places

object LocalPlaceProvider {

    val defaultPlace = getPlacesData()[0]

     fun getPlacesData(): List<Places> {
        return listOf(
                Places(
                        imageResourcesId = R.drawable.mahabodhi ,
                        titleResourcesId = R.string.mahabodhi_temple,
                        descriptionResourcesId = R.string.mahabodhi_temple_description,
                        category = R.string.temples
                ) ,
                Places(
                        imageResourcesId = R.drawable.ankor_wat ,
                        titleResourcesId = R.string.ankor_wat,
                        descriptionResourcesId = R.string.ankor_wat_description,
                        category = R.string.temples
                ) ,
                Places(
                        imageResourcesId = R.drawable.wat_rong_khun ,
                        titleResourcesId = R.string.wat_rong_khun,
                        descriptionResourcesId = R.string.wat_rong_khun_description,
                        category = R.string.temples
                ) ,
                Places(
                        imageResourcesId = R.drawable.lotus_image ,
                        titleResourcesId = R.string.lotus_temple,
                        descriptionResourcesId = R.string.lotus_temple_description,
                        category = R.string.temples,
                        isPopularRecommendation = true
                ) ,
                Places(
                        imageResourcesId = R.drawable.temple_of_hatshepsut ,
                        titleResourcesId = R.string.temple_of_hatshepsut,
                        descriptionResourcesId = R.string.temple_of_hatshepsut_description,
                        category = R.string.temples
                ) ,
                Places(
                        imageResourcesId = R.drawable.eleven_madison_park ,
                        titleResourcesId = R.string.eleven_madison_park,
                        descriptionResourcesId = R.string.eleven_madison_park_description,
                        category = R.string.restaurants
                ) ,
                Places(
                        imageResourcesId = R.drawable.frantzen ,
                        titleResourcesId = R.string.frantzen,
                        descriptionResourcesId = R.string.frantzen_description,
                        category = R.string.restaurants
                ) ,
                Places(
                        imageResourcesId = R.drawable.arzak ,
                        titleResourcesId = R.string.arzak,
                        descriptionResourcesId = R.string.arzak_description,
                        category = R.string.restaurants
                ) ,
                Places(
                        imageResourcesId = R.drawable.slanted_door ,
                        titleResourcesId = R.string.slanted_door,
                        descriptionResourcesId = R.string.slanted_door_description,
                        category = R.string.restaurants,
                        isPopularRecommendation = true
                ) ,
                Places(
                        imageResourcesId = R.drawable.steirereck ,
                        titleResourcesId = R.string.steirereck,
                        descriptionResourcesId = R.string.steirereck_description,
                        category = R.string.restaurants
                ) ,
                Places(
                        imageResourcesId = R.drawable.istanbul_cevahir ,
                        titleResourcesId = R.string.istanbul_cevahir,
                        descriptionResourcesId = R.string.istanbul_cevahir_description,
                        category = R.string.shopping
                ) ,
                Places(
                        imageResourcesId = R.drawable.ala_moana ,
                        titleResourcesId = R.string.ala_moana,
                        descriptionResourcesId = R.string.ala_moana_description,
                        category = R.string.shopping
                ) ,
                Places(
                        imageResourcesId = R.drawable.siam_paragon ,
                        titleResourcesId = R.string.siam_paragon,
                        descriptionResourcesId = R.string.siam_paragon_description,
                        category = R.string.shopping,
                        isPopularRecommendation = true
                ) ,
                Places(
                        imageResourcesId = R.drawable.mall_of_asia ,
                        titleResourcesId = R.string.mall_of_asia,
                        descriptionResourcesId = R.string.mall_of_asia_description,
                        category = R.string.shopping
                ) ,
                Places(
                        imageResourcesId = R.drawable.west_edmonton_mall ,
                        titleResourcesId = R.string.west_edmonton,
                        descriptionResourcesId = R.string.west_edmonton_description,
                        category = R.string.shopping
                ) ,
                Places(
                        imageResourcesId = R.drawable.path__tuschinski ,
                        titleResourcesId = R.string.pathe_tuschinski,
                        descriptionResourcesId = R.string.pathe_tuschinski_description,
                        category = R.string.cinemas
                ) ,
                Places(
                        imageResourcesId = R.drawable.le_grand_rex ,
                        titleResourcesId = R.string.le_grand_rex,
                        descriptionResourcesId = R.string.le_grand_rex_description,
                        category = R.string.cinemas
                ) ,
                Places(
                        imageResourcesId = R.drawable.village_east_cinema ,
                        titleResourcesId = R.string.village_east_cinema,
                        descriptionResourcesId = R.string.village_east_cinema_description,
                        category = R.string.cinemas
                ) ,
                Places(
                        imageResourcesId = R.drawable.the_civic ,
                        titleResourcesId = R.string.the_civic,
                        descriptionResourcesId = R.string.the_civic_description,
                        category = R.string.cinemas
                ) ,
                Places(
                        imageResourcesId = R.drawable.rio_cinema ,
                        titleResourcesId = R.string.rio_cinema,
                        descriptionResourcesId = R.string.rio_cinema_description,
                        category = R.string.cinemas,
                        isPopularRecommendation = true
                ) ,
                Places(
                        imageResourcesId = R.drawable.the_roastery_by_nozy_coffee_cafe ,
                        titleResourcesId = R.string.the_roastery_by_nozy,
                        descriptionResourcesId = R.string.the_roastery_by_Nozy_description,
                        category = R.string.coffee
                ) ,
                Places(
                        imageResourcesId = R.drawable.rosetta_roastery ,
                        titleResourcesId = R.string.rosetta_roastery,
                        descriptionResourcesId = R.string.rosetta_roastery_description,
                        category = R.string.coffee,
                        isPopularRecommendation = true
                ) ,
                Places(
                        imageResourcesId = R.drawable.simple_kaffa ,
                        titleResourcesId = R.string.simple_kaffa,
                        descriptionResourcesId = R.string.simple_kaffa_description,
                        category = R.string.coffee
                ) ,
                Places(
                        imageResourcesId = R.drawable.heart_coffee ,
                        titleResourcesId = R.string.heart_coffee,
                        descriptionResourcesId = R.string.heart_coffee_description,
                        category = R.string.coffee
                ) ,
                Places(
                        imageResourcesId = R.drawable.bonanza_coffee ,
                        titleResourcesId = R.string.bonanza_coffee,
                        descriptionResourcesId = R.string.bonanza_coffee_description,
                        category = R.string.coffee
                ) ,
        )
    }

    // Define a mapping between string categories and their integer representations
    private val categoryMapping = mapOf(
            "Temples" to R.string.temples,
            "Restaurants" to R.string.restaurants,
            "Shopping Centres" to R.string.shopping,
            "Cinemas" to R.string.cinemas,
            "Coffee" to R.string.coffee
    )

    // Function to get places for a specific category
    fun getPlacesForCategory(category: String): List<Places> {
        val categoryId = categoryMapping[category]
        return if (categoryId != null) {
            getPlacesData().filter { it.category == categoryId }
        } else {
            emptyList() // Return an empty list if the category is not found
        }
    }

}