package com.quoders.android.bizkaimoves.lines.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.quoders.android.bizkaimoves.lines.ui.LinesListRoute

private const val linesGraphRoutePattern = "lines_graph"
const val linesNavigationRoute = "lines_route"

fun NavController.navigateToLinesGraph(navOptions: NavOptions? = null) {
    this.navigate(linesGraphRoutePattern, navOptions)
}

fun NavGraphBuilder.linesGraph(
    onLineClick: (String) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation(
        route = linesGraphRoutePattern,
        startDestination = linesNavigationRoute,
    ) {
        composable(route = linesNavigationRoute) {
            LinesListRoute(onLineClick = onLineClick)
        }
        nestedGraphs()
    }
}