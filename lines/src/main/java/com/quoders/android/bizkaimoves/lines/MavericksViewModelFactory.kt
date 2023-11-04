package com.quoders.android.bizkaimoves.lines

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext

/*inline fun <reified VM : MavericksViewModel<S>, reified S : MavericksState> koinMavericksViewModelFactory(
    crossinline viewModelFactory: (state: S, context: ViewModelContext) -> VM
): MavericksViewModelFactory<VM, S> {
    return object : MavericksViewModelFactory<VM, S> {
        override fun create(viewModelContext: ViewModelContext, state: S): VM {
            return viewModelFactory(state, viewModelContext)
        }
    }
}*/
