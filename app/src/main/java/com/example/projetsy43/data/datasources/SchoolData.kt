package com.example.projetsy43.data.datasources

import com.example.projetsy43.R


object SchoolData {

    private val allSchool = listOf(
        School(
            id = 1,
            image = R.drawable.upm,
            photo1 = R.drawable.madrid1,
            photo2 = R.drawable.madrid2,
            photo3 = R.drawable.madrid3,
            photo4 = R.drawable.madrid4,
            name = "UPM",
            location = "Madrid",
            availability = "Available for next semester",
            country = "Spain",
            domain = "All specialities",
            description = "This school is located in the center of Madrid, is well known for the IT sector and welcomes almost 7 students"
        ),
        School(
            id = 2,
            image = R.drawable.loyola,
            photo1 = R.drawable.image1,
            photo2 = R.drawable.image2,
            photo3 = R.drawable.image3,
            photo4 = R.drawable.image4,
            name = "Loyola Andalucia",
            location = "Seville",
            availability = "Available for September 2024",
            country = "Spain",
            domain = "Computer Science/ Energy",
            description = "This school is located south of Seville, in Dos Hermanas, is well known for its different courses and welcomes 10 students"
        ),
        School(
            id = 3,
            image = R.drawable.birklogo,
            photo1 = R.drawable.birk1,
            photo2 = R.drawable.birk2,
            photo3 = R.drawable.birk3,
            photo4 = R.drawable.birk4,
            name = "Trier University of Applied Sciences (Umwelt Campus)",
            location = "Birkenfeld",
            availability = "Available for January 2025",
            country = "Germany",
            domain = "Energy",
            description = "This school is located in Germany in the center of the old town, is well known for his multiculturality and welcomes almost 15 students"
        ),
        School(
            id = 4,
            image = R.drawable.chicoulogo,
            photo1 = R.drawable.chicou1,
            photo2 = R.drawable.chicou2,
            photo3 = R.drawable.chicou3,
            photo4 = R.drawable.chicou4,
            name = "UQAC",
            location = "Chicoutimi",
            availability = "Available for September 2024",
            country = "Canada",
            domain = "Energy/ Mecanic",
            description = "This school is located in Canada in the center of Choucotimi, is well known for his branch in AI and welcomes almost 4 students"
        ),
        School(
            id = 5,
            image = R.drawable.upclogo,
            photo1 = R.drawable.upc1,
            photo2 = R.drawable.upc2,
            photo3 = R.drawable.upc3,
            photo4 = R.drawable.upc4,
            name = "UPC - EEBE",
            location = "Barcelona",
            availability = "January 2025",
            country = "Spain",
            domain = "Engineering",
            description = "This school is located in Barcelona, specializing in engineering and technology, with a strong emphasis on innovation and research."
        ),
        School(
            id = 6,
            image = R.drawable.polibalogo,
            photo1 = R.drawable.poliba1,
            photo2 = R.drawable.poliba2,
            photo3 = R.drawable.poliba3,
            photo4 = R.drawable.poliba4,
            name = "POLIBA",
            location = "Milan",
            availability = "September 2024",
            country = "Italy",
            domain = "Engineering",
            description = "Located in Milan, this prestigious school is renowned for its programs in engineering and architecture, attracting students from around the globe."
        ),
        School(
            id = 7,
            image = R.drawable.uclmlogo,
            photo1 = R.drawable.uclm1,
            photo2 = R.drawable.uclm2,
            photo3 = R.drawable.uclm3,
            photo4 = R.drawable.uclm4,
            name = "UCLM",
            location = "Barcelona",
            availability = "September 2024",
            country = "Spain",
            domain = "Engineering",
            description = "This school is located in Barcelona, specializing in engineering and technology, with a strong emphasis on innovation and research."
        ),
        School(
            id=8,
            image=R.drawable.polibalogo,
            photo1=R.drawable.poliba1,
            photo2=R.drawable.poliba2,
            photo3=R.drawable.poliba3,
            photo4=R.drawable.poliba4,
            name="POLIMI",
            location="Milan",
            availability="January 2025",
            country="Italy",
            domain="Design",
            description="Located in Milan, this prestigious school is renowned for its programs in design and architecture, attracting students from around the globe."
        ),
        School(
            id = 8,
            image = R.drawable.etflogo,
            photo1 = R.drawable.tu1,
            photo2 = R.drawable.tu2,
            photo3 = R.drawable.tu3,
            photo4 = R.drawable.tu4,
            name = "ETF",
            location = "Dortmund",
            availability = "September 2024",
            country = "Germany",
            domain = "Technology",
            description = "TU Dortmund is a leading institution in Germany, focusing on technological advancements and offering numerous research opportunities."
        ),
        School(
            id=9,
            image=R.drawable.tulogo,
            photo1=R.drawable.tu1,
            photo2=R.drawable.tu2,
            photo3=R.drawable.tu3,
            photo4=R.drawable.tu4,
            name="TU Dortmund",
            location="Dortmund",
            availability="September 2024",
            country="Germany",
            domain="Technology",
            description="TU Dortmund is a leading institution in Germany, focusing on technological advancements and offering numerous research opportunities."
        )
    )



    fun getDefaultSchool() = allSchool.first()

    fun isSchoolAccount(uid: Long): Boolean = allSchool.any { it.id == uid }

    fun getSchoolByUid(uid: Long): School {
        return allSchool.first { it.id == uid }
    }

    fun getAllSchool(): List<School> {
        return allSchool
    }

    fun getSchoolsGroupedByCity(): Map<String, List<School>> {
        return allSchool.groupBy { it.location }.toSortedMap()
    }

    fun getSchoolsGroupedByCountry(): Map<String, Map<String, List<School>>> {
        return allSchool.groupBy { it.country }.mapValues { entry ->
            entry.value.groupBy { it.location }
        }
    }
}