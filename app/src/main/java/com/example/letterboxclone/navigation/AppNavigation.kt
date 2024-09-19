package com.example.letterboxclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.letterboxclone.ui.screens.EntryScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.EntryScreen.route) {
        composable(AppScreens.EntryScreen.route) {
            EntryScreen(navController)
        }
    }
}