package com.github.almasud.rick_and_morty.ui.utils

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

/**
 * Create a shimmer effect
 *
 * @author RK SINGH Al Masud
 */
fun Modifier.shimmer(visible: Boolean = true, circular: Boolean = false): Modifier =
    this.placeholder(
        visible = visible,
        color = Color.LightGray.copy(alpha = 0.4f),
        shape = if (circular) CircleShape else RoundedCornerShape(4.dp),
        highlight = PlaceholderHighlight.shimmer(Color.LightGray.copy(alpha = 0.9f))
    )