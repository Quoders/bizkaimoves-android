package com.quoders.android.bizkaimoves.lines

interface LinesRepository {
    suspend fun getRoutes(): List<Route>
}