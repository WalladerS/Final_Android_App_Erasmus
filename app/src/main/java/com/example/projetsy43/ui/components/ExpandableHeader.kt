package com.example.projetsy43.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
// Ici on gère l'affichage avec les menu qui souvrent quand on clique sur ville pays...

@Composable
fun ExpandableHeader(
    title: String,
    style: TextStyle,
    indent: Dp = 0.dp,
    backgroundColor: Color,
    textColor: Color,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState().value
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(interactionSource = interactionSource, indication = null) { onClick() }
            .background(if (isPressed) backgroundColor.copy(alpha = 0.85f) else backgroundColor)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .padding(start = indent)
    ) {
        Text(
            text = title,
            style = style,
            color = textColor,
            fontWeight = FontWeight.Bold
        )
    }
}
