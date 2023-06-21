package com.quoders.android.bizkaimoves.lines.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun LineRouteRoute(
    onBackClick: () -> Unit,
    onLineClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: RouteViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        RouteUiState.Empty -> EmptyState(modifier)
        is RouteUiState.Error -> ErrorState(modifier)
        RouteUiState.Loading -> LoadingState(modifier)
        is RouteUiState.Success -> RouteScreen()
    }
}

@Composable
private fun RouteScreen(

) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {

    }
}

@Composable
private fun ErrorState(
    modifier: Modifier
) {
    Text(
        modifier = modifier,
        text = "Error State"
    )
}

@Composable
private fun EmptyState(
    modifier: Modifier
) {
    Text(
        modifier = modifier,
        text = "Empty State"
    )
}