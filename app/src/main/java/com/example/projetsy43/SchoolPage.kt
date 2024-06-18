package com.example.projetsy43

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.rememberScrollState
import androidx.navigation.NavController
import com.example.projetsy43.data.datasources.School


@Composable
fun Dashboard(school: School, navController: NavController, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .padding(10.dp)
            .verticalScroll(scrollState)
    ) {
        Profile(school, navController)
        Spacer(modifier = Modifier.height(16.dp))
        ImageCarousel(images = listOf(
            school.photo1,
            school.photo2,
            school.photo3,
            school.photo4
        ))
        Spacer(modifier = Modifier.height(16.dp))
        Forum(school)
        Spacer(modifier = Modifier.height(16.dp))
    }
}





