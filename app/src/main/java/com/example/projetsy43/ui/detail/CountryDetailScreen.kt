package com.example.projetsy43.ui.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projetsy43.data.datasources.SchoolData
import com.example.projetsy43.ui.components.SchoolsAppBar
import com.example.projetsy43.R


// Si jamais on souhaite afficher un menu pour le pays
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryDetailScreen(country: String, navController: NavController) {
    val cities = SchoolData.getSchoolsGroupedByCountry()[country] ?: mapOf()
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
                items(cities.keys.toList()) { city ->
                    Text(
                        text = city,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable { navController.navigate("city/${country}/${city}") }
                    )
                }
            }
        }
    )
}
