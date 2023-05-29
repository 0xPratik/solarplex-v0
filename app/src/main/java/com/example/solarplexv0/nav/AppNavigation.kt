package com.example.solarplexv0.nav

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.solarplexv0.screens.MainScreen
import com.example.solarplexv0.screens.main.MainViewModel
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender

@Composable
fun AppNavigation(activityResultSender: ActivityResultSender) {

    val navController = rememberNavController( )

    NavHost(navController = navController, startDestination = AppScreens.MainScreen.name) {

        composable(AppScreens.MainScreen.name) {
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(mainViewModel = mainViewModel,activityResultSender = activityResultSender)
        }
    }
}