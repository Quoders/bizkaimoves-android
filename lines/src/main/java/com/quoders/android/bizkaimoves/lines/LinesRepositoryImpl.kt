package com.quoders.android.bizkaimoves.lines

import com.quoders.android.bizkaimoves.lines.data.RoutesApi
import com.quoders.android.bizkaimoves.lines.data.RoutesApiData

class LinesRepositoryImpl constructor(
    private val routesApi: RoutesApi
) : LinesRepository {
    //  TODO: Implement database cache
    override suspend fun getRoutes(): List<Route> = routesApi.getRoutes().toRouteList()
}

private fun RoutesApiData.toRouteList(): List<Route> {
    val routes = mutableListOf<Route>()
    data.forEach {
        routes.add(
            Route(
                code = it.route_id,
                shortName = it.route_short_name,
                longName = it.route_desc,
                url = it.route_url,
                order = it.route_sort_order
            )
        )
    }
    return routes
}

data class Route(
    val code: String,
    val shortName: String,
    val longName: String,
    val url: String,
    val order: Int
)