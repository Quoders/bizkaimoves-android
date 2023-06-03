package com.quoders.android.bizkaimoves.aroundme.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

const val AROUND_ME_RESOURCE_ID = "aroundMeResourceId"
const val aroundMeNavigationRoute = "around_me_route/{$AROUND_ME_RESOURCE_ID}"

fun NavController.navigateToAroundMe(navOptions: NavOptions? = null) {
    this.navigate(aroundMeNavigationRoute, navOptions)
}

fun NavGraphBuilder.aroundMeScreen() {
    composable(
        route = aroundMeNavigationRoute,
        arguments = listOf(
            navArgument(AROUND_ME_RESOURCE_ID) { type = NavType.StringType },
        ),
    ) {
        AroundMeRoute()
    }
}