package com.quoders.android.bizkaimoves.favorites.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun FavoritesRoute(
    modifier: Modifier = Modifier,
    //viewModel: FavoritesViewModel = hiltViewModel(),
) {
    FavoritesScreen(
        modifier = modifier,
    )
}

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = "Favorites screen"
    )
}