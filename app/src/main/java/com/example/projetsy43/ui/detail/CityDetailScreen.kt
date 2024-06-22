package com.example.projetsy43.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

// c'est l'écran qui s'affiche quand on clique sur + d'info sur la ville
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
                    LazyColumn(
                        modifier = Modifier
                            .padding(paddingValues)
                            .padding(16.dp)
                            .fillMaxSize()
                    ) {
                        item {
                            Text(
                                text = city.name,
                                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 30.sp),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            Text(
                                text = city.description,
                                style = MaterialTheme.typography.bodyMedium.copy(lineHeight = 24.sp),
                                modifier = Modifier.padding(bottom = 16.dp)
                            )
                            CityPhotoViewer(photos = city.photos)
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "Top Places to Visit",
                                style = MaterialTheme.typography.headlineSmall.copy(fontSize = 24.sp),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            city.attractions.forEach { attraction ->
                                Text(
                                    text = "• $attraction",
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.padding(bottom = 4.dp)
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

@Composable
fun CityPhotoViewer(photos: List<Int>) {
    var currentIndex by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        if (photos.isNotEmpty()) {
            Image(
                painter = painterResource(id = photos[currentIndex]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { if (currentIndex > 0) currentIndex-- },
                enabled = currentIndex > 0
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Previous photo"
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(
                onClick = { if (currentIndex < photos.size - 1) currentIndex++ },
                enabled = currentIndex < photos.size - 1
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Next photo"
                )
            }
        }
    }
}