package com.example.letterboxclone.navigation

sealed class AppScreens (val route: String){
    object EntryScreen: AppScreens(route = "entry_screen")

}