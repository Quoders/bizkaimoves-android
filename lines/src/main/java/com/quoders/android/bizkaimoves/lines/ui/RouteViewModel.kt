package com.quoders.android.bizkaimoves.lines.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quoders.android.bizkaimoves.lines.LinesRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RouteViewModel constructor(
    private val linesRepository: LinesRepositoryImpl
) : ViewModel() {

    private val _uiState = MutableStateFlow<RouteUiState>(RouteUiState.Empty)
    val uiState: StateFlow<RouteUiState> = _uiState

    init {
        fetchRoute()
    }

    private fun fetchRoute() {
        _uiState.value = RouteUiState.Loading

        viewModelScope.launch {
            try {


            } catch (ex: Exception) {
                _uiState.value = RouteUiState.Error(ex)
            }
        }
    }
}

sealed interface RouteUiState {
    object Empty : RouteUiState
    object Loading : RouteUiState
    object Success : RouteUiState
    data class Error(val exception: Throwable) : RouteUiState
}