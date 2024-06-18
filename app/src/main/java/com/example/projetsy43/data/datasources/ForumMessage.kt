package com.example.projetsy43.data.datasources

data class ForumMessage(
    val id: Int, // Added id parameter
    val fimg: Int,
    val content: String,
    val likes: Int,
    val comments: Int
)
