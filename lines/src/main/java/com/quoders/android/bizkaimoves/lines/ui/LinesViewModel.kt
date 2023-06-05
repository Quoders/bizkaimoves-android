package com.quoders.android.bizkaimoves.lines.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quoders.android.bizkaimoves.lines.LinesRepositoryImpl
import com.quoders.android.bizkaimoves.lines.Route
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LinesViewModel constructor(
    private val linesRepository: LinesRepositoryImpl
) : ViewModel() {
    private val _uiState = MutableStateFlow(LinesUiState())
    val uiState: StateFlow<LinesUiState> = _uiState

    init {
        viewModelScope.launch {
            uiState.value.isLoading = true
            _uiState.value.lines = linesRepository.getRoutes()
            _uiState.value.isLoading = false
        }
    }
}

data class LinesUiState(
    var isLoading: Boolean = false,
    var lines: List<Route> = emptyList(),
)