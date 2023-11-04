package com.quoders.android.bizkaimoves.lines.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.quoders.android.bizkaimoves.lines.LinesRepositoryImpl
import com.quoders.android.bizkaimoves.lines.navigation.RouteArgs

class RouteViewModel constructor(
    savedStateHandle: SavedStateHandle,
    private val linesRepository: LinesRepositoryImpl
) : ViewModel() {

    private val routeArgs: RouteArgs = RouteArgs(savedStateHandle)

    init {
        fetchRoute(routeArgs.topicId)
    }

    private fun fetchRoute(routeId: String) {

    }
}
