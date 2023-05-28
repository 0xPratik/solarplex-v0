package com.example.solarplexv0.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.solarplexv0.screens.MainScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController( )

    NavHost(navController = navController, startDestination = AppScreens.MainScreen.name) {

        composable(AppScreens.MainScreen.name) {
            MainScreen()
        }
    }
}