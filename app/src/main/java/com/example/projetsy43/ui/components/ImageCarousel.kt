package com.example.projetsy43.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ImageCarousel(images: List<Int>) {
    val listState = rememberLazyListState()
    var currentIndex by remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()
    var autoScrollEnabled by remember { mutableStateOf(true) }

    LaunchedEffect(autoScrollEnabled, currentIndex) {
        if (autoScrollEnabled) {
            while (true) {
                delay(3000) // Delay for 3 seconds
                currentIndex = (currentIndex + 1) % images.size
                coroutineScope.launch {
                    listState.animateScrollToItem(currentIndex)
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.linearGradient(
                        colors = listOf(Color(0xFF89CFF0), Color(0xFF4682B4))
                    )
                ),
            shape = RoundedCornerShape(12.dp),
            tonalElevation = 5.dp,
            shadowElevation = 5.dp,
        ) {
            LazyRow(
                state = listState,
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(images) { index, imageRes ->
                    Box(
                        modifier = Modifier
                            .size(312.dp)
                            .clip(RoundedCornerShape(24.dp))
                            .border(2.dp, Color.White, RoundedCornerShape(24.dp))
                    ) {
                        Image(
                            painter = painterResource(id = imageRes),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(24.dp))
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = autoScrollEnabled,
                onCheckedChange = { autoScrollEnabled = it }
            )
            Text(text = "Enable Pictures Auto Scroll")
        }
    }
}


