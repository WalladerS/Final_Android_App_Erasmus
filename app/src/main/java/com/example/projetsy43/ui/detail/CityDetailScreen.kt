package com.example.projetsy43.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projetsy43.data.datasources.SchoolData
import com.example.projetsy43.ui.components.SchoolItem
import com.example.projetsy43.ui.components.SchoolsAppBar
import com.example.projetsy43.R
import com.example.projetsy43.data.datasources.School
import com.example.projetsy43.data.datasources.City
import com.example.projetsy43.data.datasources.CityData

// Ci jamais on souhaite afficher un écran pour la ville
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityDetailScreen(country: String, city: String, navController: NavController) {
    var cityInfo by remember { mutableStateOf<City?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(country, city) {
        // Simulate a data fetch with a delay
        kotlinx.coroutines.delay(1000)
        cityInfo = CityData.getCityInfo(country, city)
        isLoading = false
    }

    Scaffold(
        topBar = {
            SchoolsAppBar(
                canNavigateBack = true,
                navigateUp = { navController.navigateUp() },
                logoResId = R.drawable.logo
            )
        },
        content = { paddingValues ->
            if (isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                cityInfo?.let { city ->
                    Column(
                        modifier = Modifier
                            .padding(paddingValues)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = city.name,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = city.description,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Text(
                            text = "Photos",
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(city.photos) { photo ->
                                Image(
                                    painter = painterResource(id = photo),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(200.dp)
                                        .padding(8.dp)
                                )
                            }
                        }
                    }
                } ?: run {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("City information not available.")
                    }
                }
            }
        }
    )
}