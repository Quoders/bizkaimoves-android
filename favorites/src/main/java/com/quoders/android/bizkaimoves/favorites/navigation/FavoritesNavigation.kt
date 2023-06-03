package com.quoders.android.bizkaimoves.favorites.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

const val FAVORITES_RESOURCE_ID = "favoritesResourceId"
const val favoritesNavigationRoute = "favorites_route/{$FAVORITES_RESOURCE_ID}"

fun NavController.navigateToFavorites(navOptions: NavOptions? = null) {
    this.navigate(favoritesNavigationRoute, navOptions)
}

fun NavGraphBuilder.favoritesScreen() {
    composable(
        route = favoritesNavigationRoute,
        arguments = listOf(
            navArgument(FAVORITES_RESOURCE_ID) { type = NavType.StringType },
        ),
    ) {
        FavoritesRoute()
    }
}