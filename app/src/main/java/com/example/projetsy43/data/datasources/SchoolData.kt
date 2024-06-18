package com.example.projetsy43.data.datasources

import com.example.projetsy43.R


object SchoolData {

    private val allSchool = listOf(
        School(
            id = 1,
            image = R.drawable.upm,
            photo1 = R.drawable.image2,
            photo2 = R.drawable.image2,
            photo3 = R.drawable.image3,
            photo4 = R.drawable.image4,
            name = "UPM",
            location = "Madrid",
            availability = "Available for next semester",
            country = "Spain",
            domain = "All specialities",
            description = "This school is located in the center of Madrid, is well known for the IT sector and welcomes almost 7 students"),
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
            description = "This school is located south of Seville, in Dos Hermanas, is well known for its different courses and welcomes 10 students"),

        School(
            id = 3,
            image = R.drawable.loyola,
            photo1 = R.drawable.image1,
            photo2 = R.drawable.image2,
            photo3 = R.drawable.image3,
            photo4 = R.drawable.image4,
            name = "Trier University of Applied Sciences (Umwelt Campus)",
            location = "Birkenfeld",
            availability = "Available for January 2025",
            country = "Germany",
            domain = "Energy",
            description = "This school is located in Germany in the center of the old town, is well known for his multiculturality and welcomes almost 15 students"),
        School(
            id = 4,
            image = R.drawable.loyola,
            photo1 = R.drawable.image1,
            photo2 = R.drawable.image2,
            photo3 = R.drawable.image3,
            photo4 = R.drawable.image4,
            name = "UQAC",
            location = "Chicoutimi",
            availability = "Available for September 2024",
            country = "Canada",
            domain = "Energy/ Mecanic",
            description = "This school is located in Canada in the center of Choucotimi, is well known for his branch in AI and welcomes almost 4 students\""),
        School(
            id=5,
            image=R.drawable.loyola,
            photo1=R.drawable.image1,
            photo2=R.drawable.image2,
            photo3=R.drawable.image3,
            photo4=R.drawable.image4,
            name="UPC - EEBE",
            location="Barcelona",
            availability="January 2025",
            country="Spain",
            domain="Engineering",
            description="This school is located in Barcelona, specializing in engineering and technology, with a strong emphasis on innovation and research."
        ),
        School(
            id=6,
            image=R.drawable.upm,
            photo1=R.drawable.image1,
            photo2=R.drawable.image2,
            photo3=R.drawable.image3,
            photo4=R.drawable.image4,
            name="POLIBA",
            location="Milan",
            availability="September 2024",
            country="Italy",
            domain="Engineering",
            description="Located in Milan, this prestigious school is renowned for its programs in engineering and architecture, attracting students from around the globe."
        ),
                School(
            id=7,
            image=R.drawable.upm,
            photo1=R.drawable.image2,
            photo2=R.drawable.image3,
            photo3=R.drawable.image4,
            photo4=R.drawable.image1,
            name="UPC - EEBE",
            location="Barcelona",
            availability="September 2024",
            country="Spain",
            domain="Engineering",
            description="This school is located in Barcelona, specializing in engineering and technology, with a strong emphasis on innovation and research."
        ),
        School(
            id=8,
            image=R.drawable.upm,
            photo1=R.drawable.image2,
            photo2=R.drawable.image1,
            photo3=R.drawable.image1,
            photo4=R.drawable.image4,
            name="POLIMI",
            location="Milan",
            availability="January 2025",
            country="Italy",
            domain="Design",
            description="Located in Milan, this prestigious school is renowned for its programs in design and architecture, attracting students from around the globe."
        ),
        School(
            id=9,
            image=R.drawable.upm,
            photo1=R.drawable.image3,
            photo2=R.drawable.image4,
            photo3=R.drawable.image1,
            photo4=R.drawable.image2,
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