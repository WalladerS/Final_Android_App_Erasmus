package com.example.projetsy43

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.projetsy43.data.datasources.Comment
import com.example.projetsy43.data.datasources.SchoolData
import com.example.projetsy43.ui.dashboard.DashboardScreen
import com.example.projetsy43.ui.detail.CityDetailScreen
import com.example.projetsy43.ui.detail.CountryDetailScreen
import dagger.hilt.android.AndroidEntryPoint

import com.example.projetsy43.data.repository.CommentRepository
import com.example.projetsy43.data.datasources.AppDatabase
import com.example.projetsy43.ui.detail.SchoolDetailScreen
import com.example.projetsy43.ui.theme.Projetsy43Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var database: AppDatabase
    private lateinit var repository: CommentRepository

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the database
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database"
        ).build()

        // Initialize the repository
        repository = CommentRepository(database.commentDao())

        setContent {
            val navController = rememberNavController()
            Projetsy43Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(text = "test")

                    NavHost(navController = navController, startDestination = "dashboard") {
                        composable("dashboard") {
                            DashboardScreen(navController = navController)
                        }
                        composable("country/{country}") { backStackEntry ->
                            val country = backStackEntry.arguments?.getString("country") ?: return@composable
                            CountryDetailScreen(country, navController)
                        }
                        composable("city/{country}/{city}") { backStackEntry ->
                            val country = backStackEntry.arguments?.getString("country") ?: return@composable
                            val city = backStackEntry.arguments?.getString("city") ?: return@composable
                            CityDetailScreen(country, city, navController)
                        }
                        composable("school/{schoolId}") { backStackEntry ->
                            val schoolId = backStackEntry.arguments?.getString("schoolId")?.toLongOrNull()
                            val school = schoolId?.let { SchoolData.getSchoolByUid(it) }
                            SchoolDetailScreen(navController = navController, school = school)
                        }
                    }
                }
            }
        }

        // Example usage: Insert a comment and fetch all comments
        lifecycleScope.launch {
            repository.insert(Comment(message = "Hello, world!", timestamp = System.currentTimeMillis()))
            val comments = repository.getAllComments()
            // Update your UI with the comments
        }
    }
}

