package com.quoders.android.bizkaimoves.lines.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quoders.android.bizkaimoves.lines.LinesRepositoryImpl
import com.quoders.android.bizkaimoves.lines.Route
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LinesViewModel(
    private val linesRepository: LinesRepositoryImpl
) : ViewModel() {

    private val _uiState = MutableStateFlow<LinesUiState>(LinesUiState.Empty)
    val uiState: StateFlow<LinesUiState> = _uiState

    init {
        fetchLines()
    }

    internal fun fetchLines() {
        _uiState.value = LinesUiState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val routes = linesRepository.getRoutes()
                if (routes.isEmpty()) {
                    _uiState.value = LinesUiState.Empty
                } else {
                    val lines = getRoutesWithFormattedName(routes)
                    _uiState.value = LinesUiState.Success(lines)
                }
            } catch (ex: Exception) {
                _uiState.value = LinesUiState.Error(ex)
            }
        }
    }

    private fun getRoutesWithFormattedName(routes: List<Route>): List<Route> {
        val lines = mutableListOf<Route>()
        routes.forEach {
            lines.add(
                it.copy(longName = getLineNameFromRouteDescription(it.shortName, it.longName))
            )
        }
        return lines
    }

    private fun getLineNameFromRouteDescription(shortName: String, longName: String): String {
        var lineName = longName
        if (longName.contains(shortName)) {
            lineName = longName.substringAfter("$shortName-").uppercase()
        }
        return lineName
    }
}


sealed interface LinesUiState {
    object Empty : LinesUiState
    object Loading : LinesUiState
    data class Success(val lines: List<Route>) : LinesUiState
    data class Error(val exception: Throwable) : LinesUiState
}