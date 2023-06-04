package com.quoders.android.bizkaimoves.aroundme.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun AroundMeRoute(
    modifier: Modifier = Modifier,
    //viewModel: AroundMeViewModel = hiltViewModel(),
) {
    AroundMeScreen(
        modifier = modifier,
    )
}

@Composable
fun AroundMeScreen(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = "Around Me screen"
    )
}