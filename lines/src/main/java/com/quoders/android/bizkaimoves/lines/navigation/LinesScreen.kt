package com.quoders.android.bizkaimoves.lines.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun LinesRoute(
    modifier: Modifier = Modifier,
    //viewModel: LinesViewModel = hiltViewModel(),
) {
    LinesScreen(
        modifier = modifier,
    )
}

@Composable
fun LinesScreen(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = "Lines screen"
    )
}