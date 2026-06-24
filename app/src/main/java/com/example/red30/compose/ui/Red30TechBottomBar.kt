package com.example.red30.compose.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.red30.compose.ui.screen.topLevelScreens

@Composable
fun Red30TechBottomBar(modifier: Modifier = Modifier,
                       navHost: NavHostController,
                       currentDestination: NavDestination?
) {
    NavigationBar(modifier = Modifier) {
        topLevelScreens.forEach { screen ->
            val label: String = stringResource(screen.resourceId)
            NavigationBarItem( // Created new item in navigation bar
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = label
                    )
                },
                label = {
                    Text(label)
                },
                selected = currentDestination?.hierarchy?.any { // Check if current screen exists in stack if it exists then it's selected
                    it.route == screen.route
                } == true,
                onClick = {
                    navHost.navigate(screen.route) {
                        popUpTo(navHost.graph.startDestinationId) // This removes from stack
                        launchSingleTop = true // This makes that it launches one instance of view
                    }
                }
            )
        }
    }

}