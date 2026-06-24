package com.example.red30.compose.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.red30.compose.ui.screen.FavoritesScreen
import com.example.red30.compose.ui.screen.SessionDetailScreen
import com.example.red30.compose.ui.screen.SessionsScreen
import com.example.red30.compose.ui.screen.SpeakersScreen
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.red30.compose.MainViewModel

@Composable
fun Red30TechNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: MainViewModel
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle() // Include UI state from View model
    NavHost( // This is navigation manager that manages navigation between different activity screens
        modifier = Modifier.fillMaxSize(),
        navController = rememberNavController(),
        startDestination = "sessions"

    ) {
        composable(route = "sessions") { // This is different routes
            SessionsScreen(uiState = uiState)
        }
        composable(route = "speakers") {
            SpeakersScreen(uiState = uiState)
        }
        composable(route = "favorites") {
            FavoritesScreen(uiState = uiState)
        }
        composable(route = "sessionDetails") {
            uiState.selectedSession?.let { it1 -> SessionDetailScreen(sessionInfo = it1) }
        }
    }

}

