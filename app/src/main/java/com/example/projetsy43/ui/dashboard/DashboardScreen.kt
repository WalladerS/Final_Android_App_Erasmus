package com.example.projetsy43.ui.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projetsy43.data.datasources.SchoolData
import com.example.projetsy43.ui.components.ExpandableHeader
import com.example.projetsy43.ui.components.SchoolItem
import com.example.projetsy43.ui.components.SchoolsAppBar
import com.example.projetsy43.R

val expandedCountries = mutableStateMapOf<String, Boolean>()
val expandedCities = mutableStateMapOf<String, Boolean>()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    val schoolsGroupedByCountry = SchoolData.getSchoolsGroupedByCountry()
    Text(text = "testcyprien")
    Scaffold(
        topBar = {
            SchoolsAppBar(canNavigateBack = false, navigateUp = { /* Do nothing */ }, logoResId = R.drawable.logo)
        },
        content = { paddingValues ->
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                schoolsGroupedByCountry.forEach { (country, cities) ->
                    item {
                        ExpandableHeader(
                            title = country,
                            style = MaterialTheme.typography.headlineMedium,
                            backgroundColor = Color(0xff0091ea),
                            textColor = Color.White,
                            onClick = {
                                expandedCountries[country] = !(expandedCountries[country] ?: false)
                            }
                        )

                        if (expandedCountries[country] == true) {
                            cities.forEach { (city, schools) ->
                                ExpandableHeader(
                                    title = city,
                                    style = MaterialTheme.typography.bodyLarge,
                                    indent = 16.dp,
                                    backgroundColor = Color(0xff40c4ff),
                                    textColor = MaterialTheme.colorScheme.onSecondary,
                                    onClick = {
                                        expandedCities[city] = !(expandedCities[city] ?: false)
                                    }
                                )

                                if (expandedCities[city] == true) {
                                    schools.forEach { school ->
                                        SchoolItem(school = school) {
                                            navController.navigate("school/${school.id}")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}


