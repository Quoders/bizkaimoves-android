package com.quoders.android.bizkaimoves.lines.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun LinesRoute(
    modifier: Modifier = Modifier,
    viewModel: LinesViewModel = koinViewModel(),
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