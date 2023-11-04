package com.quoders.android.bizkaimoves.lines.ui

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.quoders.android.bizkaimoves.lines.Line

@Composable
internal fun LinesListRoute(
    onLineClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val viewModel: LinesViewModel = mavericksViewModel()
    val linesState = viewModel.collectAsState()

    when(val lines = linesState.value.lines) {
        is Loading -> LoadingContent(modifier = modifier)
        is Fail -> ErrorContent(modifier = modifier)
        is Success -> LinesListContent(lines = lines.invoke(), onLineClick = onLineClick)
        Uninitialized -> EmptyContent(modifier = modifier)
    }
}

@Composable
private fun LinesListContent(
    lines: List<Line>,
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
                HorizontalDivider(
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
fun LoadingContent(
    modifier: Modifier
) {
    Text(
        modifier = modifier,
        text = "Loading State"
    )
}

@Composable
private fun ErrorContent(
    modifier: Modifier
) {
    Text(
        modifier = modifier,
        text = "Error State"
    )
}

@Composable
private fun EmptyContent(
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
fun LinesScreenPreviewMavericks() {
    MaterialTheme {
        LinesListContent(
            listOf(
                Line("1", "A0651", "A0652-LANESTOSA-BALMASEDA"),
                Line("2", "A0653", "A0653-TRUCIOS TURTZIOZ-ARTZENTALES"),
                Line("3", "A2153", "A2153-BILBAO-TXORIERRI-LARRABETZU"),
                Line("4", "A2163", "A2163-ERANDIO-UPV/EHU"),
            ),
            onLineClick = {}
        )
    }
}
