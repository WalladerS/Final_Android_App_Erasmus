package com.example.projetsy43.data.datasources

import com.example.projetsy43.R

object CityData {
    private val allCities = listOf(
        City(
            name = "Madrid",
            country = "Spain",
            description = "Madrid, Spain's central capital, is a city of elegant boulevards and expansive, manicured parks such as the Buen Retiro. It's renowned for its rich repositories of European art, including the Prado Museum’s works by Goya, Velázquez and other Spanish masters.",
            photos = listOf(R.drawable.madrid3, R.drawable.madrid2, R.drawable.madrid1),
            attractions = listOf("Prado Museum", "Royal Palace", "Retiro Park")
        ),
        City(
            name = "Seville",
            country = "Spain",
            description = "Seville is the capital and largest city of the Spanish autonomous community of Andalusia and the province of Seville. It is situated on the lower reaches of the River Guadalquivir, in the southwest of the Iberian Peninsula.",
            photos = listOf(R.drawable.seville1, R.drawable.seville3, R.drawable.seville1),
            attractions = listOf("Seville Cathedral", "Alcázar of Seville", "Plaza de España")
        ),
        City(
            name = "Barcelona",
            country = "Spain",
            description = "Barcelona, the cosmopolitan capital of Spain’s Catalonia region, is known for its art and architecture. The fantastical Sagrada Família church and other modernist landmarks designed by Antoni Gaudí dot the city.",
            photos = listOf(R.drawable.barcelone1, R.drawable.barcelone2, R.drawable.barcelone3),
            attractions = listOf("Sagrada Família", "Park Güell", "La Rambla")
        ),
        City(
            name = "Milan",
            country = "Italy",
            description = "Milan, a metropolis in Italy's northern Lombardy region, is a global capital of fashion and design. Home to the national stock exchange, it’s a financial hub also known for its high-end restaurants and shops.",
            photos = listOf(R.drawable.milan1, R.drawable.milan2, R.drawable.milan3),
            attractions = listOf("Duomo di Milano", "Galleria Vittorio Emanuele II", "Sforza Castle")
        ),
        City(
            name = "Dortmund",
            country = "Germany",
            description = "Dortmund is a city in Germany’s North Rhine-Westphalia region. It’s known for its Westphalian cuisine, beer, football, and events like the world’s largest Christmas market.",
            photos = listOf(R.drawable.dortmund1, R.drawable.dortmund2, R.drawable.dortmund3),
            attractions = listOf("Westfalenpark", "Dortmund U-Tower", "German Football Museum")
        ),
        City(
            name = "Chicoutimi",
            country = "Canada",
            description = "Chicoutimi is one of the three boroughs of the city of Saguenay, Quebec, Canada. Located at the confluence of the Chicoutimi and Saguenay Rivers, it is known for its picturesque landscapes and rich history.",
            photos = listOf(R.drawable.chicoutimi1, R.drawable.chicoutimi2, R.drawable.chicoutimi3),
            attractions = listOf("Pulperie de Chicoutimi", "Saguenay Fjord National Park", "Zone Portuaire")
        ),
        City(
            name = "Birkenfeld",
            country = "Germany",
            description = "Birkenfeld is a charming town in Germany, known for its scenic landscapes and vibrant community life. The Trier University of Applied Sciences (Umwelt Campus) is located here, attracting students from various parts of the world.",
            photos = listOf(R.drawable.birk1, R.drawable.birk2, R.drawable.birk3),
            attractions = listOf("Hunsrück-Hochwald National Park", "Wildenburg Castle", "Erbeskopf Mountain")
        )
    )

    fun getCityInfo(country: String, city: String): City? {
        return allCities.find { it.name.equals(city, ignoreCase = true) && it.country.equals(country, ignoreCase = true) }
    }
}