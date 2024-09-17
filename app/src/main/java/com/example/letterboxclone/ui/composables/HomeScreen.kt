package com.example.letterboxclone.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.letterboxclone.ui.theme.LetterBoxBackground


@Composable
fun ImageWithFade(modifier: Modifier, url: String) {
    Box(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight(0.4f)) {
        AsyncImage(
            model = url,
            contentDescription = null,
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = modifier.fillMaxSize(),
            shape = RoundedCornerShape(0.dp),
            color = Color.Transparent
        ) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, LetterBoxBackground),
                            startY = 300f
                        )
                    )
            )
        }
    }
}
