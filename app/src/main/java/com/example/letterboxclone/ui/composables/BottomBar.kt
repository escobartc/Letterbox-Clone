package com.example.letterboxclone.ui.composables

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.letterboxclone.ui.theme.BottomBarColor

@Composable
fun BottomBar() {
    BottomNavigation(
        backgroundColor = BottomBarColor,
        contentColor = Color.White
    ) {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Lock, contentDescription = "Home") },
            selected = false,
            onClick = { /* Handle home click */ }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.List, contentDescription = "Search") },
            selected = false,
            onClick = { /* Handle search click */ }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Search, contentDescription = "Profile") },
            selected = false,
            onClick = { /* Handle profile click */ }
        )
    }
}
