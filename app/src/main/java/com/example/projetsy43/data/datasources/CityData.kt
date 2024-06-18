package com.example.projetsy43.data.datasources

import com.example.projetsy43.R

object CityData {
    private val allCities = listOf(
        City(
            name = "Madrid",
            country = "Spain",
            description = "Madrid, Spain's central capital, is a city of elegant boulevards and expansive, manicured parks such as the Buen Retiro. It's renowned for its rich repositories of European art, including the Prado Museum’s works by Goya, Velázquez and other Spanish masters.",
            photos = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)
        ),
        City(
            name = "Seville",
            country = "Spain",
            description = "Seville is the capital and largest city of the Spanish autonomous community of Andalusia and the province of Seville. It is situated on the lower reaches of the River Guadalquivir, in the southwest of the Iberian Peninsula.",
            photos = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)
        ),
        City(
            name = "Barcelona",
            country = "Spain",
            description = "Barcelona, the cosmopolitan capital of Spain’s Catalonia region, is known for its art and architecture. The fantastical Sagrada Família church and other modernist landmarks designed by Antoni Gaudí dot the city.",
            photos = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)
        ),
        City(
            name = "Milan",
            country = "Italy",
            description = "Milan, a metropolis in Italy's northern Lombardy region, is a global capital of fashion and design. Home to the national stock exchange, it’s a financial hub also known for its high-end restaurants and shops.",
            photos = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)
        ),
        City(
            name = "Dortmund",
            country = "Germany",
            description = "Dortmund is a city in Germany’s North Rhine-Westphalia region. It’s known for its Westphalian cuisine, beer, football, and events like the world’s largest Christmas market.",
            photos = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)
        ),
        City(
            name = "Chicoutimi",
            country = "Canada",
            description = "Chicoutimi is one of the three boroughs of the city of Saguenay, Quebec, Canada. Located at the confluence of the Chicoutimi and Saguenay Rivers, it is known for its picturesque landscapes and rich history.",
            photos = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)
        )
    )

    fun getCityInfo(country: String, city: String): City? {
        return allCities.find { it.name.equals(city, ignoreCase = true) && it.country.equals(country, ignoreCase = true) }
    }
}