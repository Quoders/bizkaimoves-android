package com.quoders.android.bizkaimoves.lines

import com.quoders.android.bizkaimoves.lines.data.LineData
import com.quoders.android.bizkaimoves.lines.data.BizkaibusApi

class LinesRepositoryImpl(
    private val bizkaibusApi: BizkaibusApi
) : LinesRepository {
    //  TODO: Implement database cache
    override suspend fun getLines() = bizkaibusApi.getLines().toLineList()

    private fun List<LineData>.toLineList(): List<Line> {
        val lines = mutableListOf<Line>()
        forEach {
            lines.add(
                Line(
                    code = it.route_id.toString(),
                    shortName = it.route_short_name,
                    longName = it.route_long_name,
                )
            )
        }
        return lines
    }
}

data class Line(
    val code: String,
    val shortName: String,
    val longName: String,
)