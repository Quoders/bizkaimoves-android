package com.quoders.android.bizkaimoves.lines.navigation

import android.net.Uri
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.quoders.android.bizkaimoves.lines.ui.LineRouteRoute

internal const val lineIdArg = "lineId"


fun NavController.navigateToRoute(lineId: String) {
    val encodedId = Uri.encode(lineId)
    this.navigate("line_route/$encodedId") {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.routeScreen(
    onBackClick: () -> Unit,
    onLineClick: (String) -> Unit,
) {
    composable(
        route = "line_route/{$lineIdArg}",
        arguments = listOf(
            navArgument(lineIdArg) { type = NavType.StringType },
        ),
    ) {
        LineRouteRoute(onBackClick = onBackClick, onLineClick = onLineClick)
    }
}