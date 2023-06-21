package com.quoders.android.bizkaimoves.lines.ui

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.quoders.android.bizkaimoves.lines.Route
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun LinesListRoute(
    onLineClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LinesViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        LinesUiState.Empty -> EmptyState(modifier)
        is LinesUiState.Error -> ErrorState(modifier)
        LinesUiState.Loading -> LoadingState(modifier)
        is LinesUiState.Success -> LinesListContent(
            (uiState as LinesUiState.Success).lines,
            onLineClick = onLineClick,
        )
    }
}

@Composable
private fun LinesListContent(
    lines: List<Route>,
    onLineClick: (String) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        lines.forEach { line ->
            item {
                LineItem(
                    line.code,
                    line.shortName,
                    line.longName,
                    onLineClick = onLineClick,
                )
                Divider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = Color.LightGray
                )
            }
        }
    }
}

@Composable
private fun LineItem(
    code: String,
    shortName: String,
    longName: String,
    onLineClick: (String) -> Unit,
) {
    Row(
        modifier = Modifier
            .clickable { onLineClick(code) }
    ) {
        Text(
            text = shortName,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = longName
        )
    }
}


@Composable
fun LoadingState(
    modifier: Modifier
) {
    Text(
        modifier = modifier,
        text = "Loading State"
    )
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

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun LinesScreenPreview() {
    MaterialTheme {
        LinesListContent(
            listOf(
                Route("1", "A0651", "A0652-LANESTOSA-BALMASEDA", "", 1),
                Route("2", "A0653", "A0653-TRUCIOS TURTZIOZ-ARTZENTALES", "", 1),
                Route("3", "A2153", "A2153-BILBAO-TXORIERRI-LARRABETZU", "", 1),
                Route("4", "A2163", "A2163-ERANDIO-UPV/EHU", "", 1),
            ),
            onLineClick = {}
        )
    }
}
