package com.quoders.android.bizkaimoves.lines.data

data class RoutesApiData(
    val data: List<Data>
)
data class Data(
    val route_desc: String,
    val route_id: String,
    val route_short_name: String,
    val route_sort_order: Int,
    val route_url: String
)
