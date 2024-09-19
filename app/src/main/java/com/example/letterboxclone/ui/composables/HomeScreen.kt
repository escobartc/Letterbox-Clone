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
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState

@Composable
fun ImageWithFade(modifier: Modifier, url: String) {
    val currentUrl by rememberUpdatedState(newValue = url)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.45f)
    ) {
        Crossfade(targetState = currentUrl, label = "") { imageUrl ->
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
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
