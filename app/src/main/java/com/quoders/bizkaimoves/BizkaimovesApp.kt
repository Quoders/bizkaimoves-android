package com.quoders.bizkaimoves

import android.app.Application
import com.airbnb.mvrx.Mavericks
import com.quoders.android.bizkaimoves.lines.di.linesModule
import org.koin.core.context.GlobalContext.startKoin

class BizkaimovesApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(linesModule)
        }

        Mavericks.initialize(this)
    }
}