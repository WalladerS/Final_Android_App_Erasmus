package com.example.projetsy43.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

// Ici c'est une partie de l'affichage dans school le haut

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolsAppBar(canNavigateBack: Boolean, navigateUp: () -> Unit, logoResId: Int) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (canNavigateBack) {
                    Spacer(modifier = Modifier.width(48.dp))
                }
                Image(
                    painter = painterResource(id = logoResId),
                    contentDescription = null,
                    modifier = Modifier.size(170.dp)
                )
                if (!canNavigateBack) {
                    Spacer(modifier = Modifier.width(48.dp))
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(Icons.Filled.ArrowBack, "Back", tint = Color.Black)
                }
            }
        }
    )
}
