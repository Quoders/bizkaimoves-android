package com.quoders.bizkaimoves.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.quoders.android.bizkaimoves.aroundme.navigation.aroundMeNavigationRoute
import com.quoders.android.bizkaimoves.aroundme.navigation.navigateToAroundMe
import com.quoders.android.bizkaimoves.favorites.navigation.favoritesNavigationRoute
import com.quoders.android.bizkaimoves.favorites.navigation.navigateToFavorites
import com.quoders.android.bizkaimoves.lines.navigation.linesRoute
import com.quoders.android.bizkaimoves.lines.navigation.navigateToLinesGraph
import com.quoders.bizkaimoves.navigation.TopLevelDestination
import kotlinx.coroutines.CoroutineScope

val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

@Composable
fun rememberBizkaimovesAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): BizkaimovesAppState {
    return remember(
        navController,
        coroutineScope,
    ) {
        BizkaimovesAppState(
            navController,
            coroutineScope,
        )
    }
}

@Stable
class BizkaimovesAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            aroundMeNavigationRoute -> TopLevelDestination.AROUND_ME
            linesRoute -> TopLevelDestination.LINES
            favoritesNavigationRoute -> TopLevelDestination.FAVORITES
            else -> null
        }

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.AROUND_ME -> navController.navigateToAroundMe(topLevelNavOptions)
            TopLevelDestination.LINES -> navController.navigateToLinesGraph(topLevelNavOptions)
            TopLevelDestination.FAVORITES -> navController.navigateToFavorites(topLevelNavOptions)
        }
    }
}