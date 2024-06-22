package com.example.projetsy43.ui.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.projetsy43.SchoolPage
import com.example.projetsy43.data.datasources.School
import com.example.projetsy43.ui.components.SchoolsAppBar
import com.example.projetsy43.R
// Ce qui permet l'envoie vers SchoolPage depuis le menu de base bleu
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
                SchoolPage(
                    school = school,
                    navController = navController,
                    modifier = Modifier.padding(paddingValues)
                )
            } else {

                Text("School not found", modifier = Modifier.padding(paddingValues))
            }
        }
    )
}