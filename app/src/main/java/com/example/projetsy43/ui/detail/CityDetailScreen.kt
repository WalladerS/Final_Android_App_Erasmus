package com.example.projetsy43.ui.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.projetsy43.data.datasources.SchoolData
import com.example.projetsy43.ui.components.SchoolItem
import com.example.projetsy43.ui.components.SchoolsAppBar
import com.example.projetsy43.R
// Ci jamais on souhaite afficher un écran pour la ville
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityDetailScreen(country: String, city: String, navController: NavController) {
    val schools = SchoolData.getSchoolsGroupedByCountry()[country]?.get(city) ?: listOf()
    Scaffold(
        topBar = {
            SchoolsAppBar(
                canNavigateBack = true,
                navigateUp = { navController.navigateUp() },
                logoResId = R.drawable.logo
            )
        },
        content = { paddingValues ->
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(schools) { school ->
                    SchoolItem(school = school) {
                        navController.navigate("school/${school.id}")
                    }
                }
            }
        }
    )
}
