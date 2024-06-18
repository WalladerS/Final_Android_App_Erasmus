package com.example.projetsy43

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projetsy43.data.datasources.ReportData
import com.example.projetsy43.data.datasources.School
import com.example.projetsy43.data.datasources.SchoolData

@Composable
fun Profile(school: School, navController: NavController) {
    Column(modifier = Modifier.background(Color(0xFFF0F0F0))) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF4CAF50), Color(0xFF2E7D32))
                    ),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Surface(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(50)),
                color = Color.White
            ) {
                Image(
                    painter = painterResource(id = school.image),
                    contentDescription = "${school.name} Profile Picture"
                )
            }
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = "${school.name} ${school.location}",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Availability: ${school.availability}",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Available Domains: ${school.domain}",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        val element = ReportData.getReportByUid(school.id)
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F7FA))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "School informations",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00796B)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = " ${school.description}"
                )
                ReportElement("Places taken", element.number_student_registered, element.max_student_registered)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Rating (from students)",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF00796B)
                )
                RatingStars(rating = element.note_school.toInt())
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Difficulty",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF00796B)
                )
                RatingStars(rating = element.note_difficulty.toInt())

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        navController.navigate("cityDetail/${school.country}/${school.location}")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Icon(Icons.Filled.Info, contentDescription = "More Info")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("More about ${school.location}")
                }
            }
        }
    }
}

@Composable
fun ReportElement(title: String, value: Long, total: Int) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF00796B)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$value/$total",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF004D40)
            )
            Spacer(modifier = Modifier.width(8.dp))
            LinearProgressIndicator(
                progress = value.toFloat() / total.toFloat(),
                modifier = Modifier.weight(1f),
                color = Color(0xFF004D40)
            )
        }
    }
}

@Composable
fun RatingStars(rating: Int, maxRating: Int = 5) {
    Row {
        for (i in 1..maxRating) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                tint = if (i <= rating) Color(0xFFFFD700) else Color(0xFFB0B0B0) // Gray color for non-filled stars
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    Profile(SchoolData.getSchoolByUid(1), NavController(LocalContext.current))
}