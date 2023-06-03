package com.quoders.bizkaimoves.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.quoders.android.bizkaimoves.aroundme.navigation.aroundMeNavigationRoute
import com.quoders.android.bizkaimoves.aroundme.navigation.aroundMeScreen
import com.quoders.android.bizkaimoves.favorites.navigation.favoritesScreen
import com.quoders.android.bizkaimoves.lines.navigation.linesScreen
import com.quoders.bizkaimoves.ui.BizkaimovesAppState

@Composable
fun BizkaimovesNavHost(
    appState: BizkaimovesAppState,
    modifier: Modifier = Modifier,
    startDestination: String = aroundMeNavigationRoute,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        aroundMeScreen()
        linesScreen()
        favoritesScreen()
    }
}
