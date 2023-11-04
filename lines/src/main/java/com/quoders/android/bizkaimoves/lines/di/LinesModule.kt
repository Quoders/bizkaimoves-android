package com.quoders.android.bizkaimoves.lines.di

import com.quoders.android.bizkaimoves.lines.LinesRepositoryImpl
import com.quoders.android.bizkaimoves.lines.data.BizkaibusApi
import com.quoders.android.bizkaimoves.lines.ui.RouteViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val linesModule = module {
    singleOf(::LinesRepositoryImpl)
    singleOf(::BizkaibusApi)

    viewModelOf(::RouteViewModel)
}
