package com.quoders.android.bizkaimoves.lines.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

const val LINES_RESOURCE_ID = "linesResourceId"
const val linesNavigationRoute = "lines_route/{$LINES_RESOURCE_ID}"

fun NavController.navigateToLines(navOptions: NavOptions? = null) {
    this.navigate(linesNavigationRoute, navOptions)
}

fun NavGraphBuilder.linesScreen() {
    composable(
        route = linesNavigationRoute,
        arguments = listOf(
            navArgument(LINES_RESOURCE_ID) { type = NavType.StringType },
        ),
    ) {
        LinesRoute()
    }
}