package com.example.projetsy43.ui.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.projetsy43.Dashboard
import com.example.projetsy43.data.datasources.School
import com.example.projetsy43.ui.components.SchoolsAppBar
import com.example.projetsy43.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolDetailScreen(navController: NavController, school: School?) {
    Scaffold(
        topBar = {
            SchoolsAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                logoResId = R.drawable.logo
            )
        },
        content = { paddingValues ->
            if (school != null) {
                // School details content goes here
                // Replace `Dashboard` with your actual composable to show school details
                Dashboard(
                    school = school,
                    navigateUp = { navController.navigateUp() },
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    )
}
