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
            description = "Cette école est située en ..., en plein centre de la ville, est très connue pour ... et accueille pres de ... étudiants"),
        School(
            id = 2,
            image = R.drawable.loyola,
            photo1 = R.drawable.image1,
            photo2 = R.drawable.image2,
            photo3 = R.drawable.image3,
            photo4 = R.drawable.image4,
            name = "Loyola Andalucia",
            location = "Seville",
            availability = "Available for next semester",
            country = "Spain",
            domain = "Computer Science",
            description = "Cette école est située en ..., en plein centre de la ville, est très connue pour ... et accueille pres de ... étudiants"),

        School(
            id = 3,
            image = R.drawable.men_profile,
            photo1 = R.drawable.image1,
            photo2 = R.drawable.image2,
            photo3 = R.drawable.image3,
            photo4 = R.drawable.image4,
            name = "Christophe",
            location = "Petit",
            availability = "Year 5",
            country = "Spain",
            domain = "Energy",
            description = "Cette école est située en ..., en plein centre de la ville, est très connue pour ... et accueille pres de ... étudiants"),
        School(
            id = 4,
            image = R.drawable.men_profile,
            photo1 = R.drawable.image1,
            photo2 = R.drawable.image2,
            photo3 = R.drawable.image3,
            photo4 = R.drawable.image4,
            name = "Jean",
            location = "Legrand",
            availability = "Year 3",
            country = "Spain",
            domain = "Energy",
            description = "Cette école est située en ..., en plein centre de la ville, est très connue pour ... et accueille pres de ... étudiants"),
        School(
            id = 5,
            image = R.drawable.image1,
            photo1 = R.drawable.image1,
            photo2 = R.drawable.image2,
            photo3 = R.drawable.image3,
            photo4 = R.drawable.image4,
            name = "Yara",
            location = "Lemarchand",
            availability = "Year 2",
            country = "Spain",
            domain = "Info",
            description = "Cette école est située en ..., en plein centre de la ville, est très connue pour ... et accueille pres de ... étudiants"),
        School(
            id = 6,
            image = R.drawable.men_profile,
            photo1 = R.drawable.image1,
            photo2 = R.drawable.image2,
            photo3 = R.drawable.image3,
            photo4 = R.drawable.image4,
            name = "Sami",
            location = "Dubois",
            availability = "Year 1",
            country = "Spain",
            domain = "Energy",
            description = "Cette école est située en ..., en plein centre de la ville, est très connue pour ... et accueille pres de ... étudiants")
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