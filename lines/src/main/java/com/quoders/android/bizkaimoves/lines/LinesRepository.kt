package com.quoders.android.bizkaimoves.lines

interface LinesRepository {
    suspend fun getLines(): List<Line>
}