package com.example.projetsy43.data.datasources
// On a préféré faire une data class pour School mais on aurait pu faire database aussi.
data class School(
    val id: Long,
    val image: Int,
    val photo1: Int,
    val photo2: Int,
    val photo3: Int,
    val photo4: Int,
    val name: String,
    val location: String,
    val availability: String,
    val country: String,
    val domain: String,
    val description: String
)
