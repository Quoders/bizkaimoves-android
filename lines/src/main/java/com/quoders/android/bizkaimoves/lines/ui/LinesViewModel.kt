package com.quoders.android.bizkaimoves.lines.ui

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.ViewModelContext
import com.quoders.android.bizkaimoves.lines.LinesRepository
import com.quoders.android.bizkaimoves.lines.LinesRepositoryImpl
import com.quoders.android.bizkaimoves.lines.Line
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.android.inject

class LinesViewModel(
    initialState: LinesState,
    private val repository: LinesRepository
) : MavericksViewModel<LinesState>(
    initialState
) {
    init {
        fetchLines()
    }

    private fun fetchLines() {
        suspend {
            repository.getLines()
        }.execute(Dispatchers.IO) {
            copy(lines = it)
        }
    }

    companion object : MavericksViewModelFactory<LinesViewModel, LinesState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: LinesState
        ): LinesViewModel {
            val repo: LinesRepositoryImpl by viewModelContext.activity.inject()
            return LinesViewModel(state, repo)
        }
    }
}

data class LinesState(
    val lines: Async<List<Line>> = Uninitialized
) : MavericksState