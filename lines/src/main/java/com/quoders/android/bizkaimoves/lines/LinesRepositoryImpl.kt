package com.quoders.android.bizkaimoves.lines

import com.quoders.android.bizkaimoves.lines.data.RouteData
import com.quoders.android.bizkaimoves.lines.data.RoutesApi


class LinesRepositoryImpl(
    private val routesApi: RoutesApi
) : LinesRepository {
    //  TODO: Implement database cache
    override suspend fun getRoutes() = routesApi.getRoutes().toRouteList()

    private fun List<RouteData>.toRouteList(): List<Route> {
        val routes = mutableListOf<Route>()
        forEach {
            routes.add(
                Route(
                    code = it.route_id.toString(),
                    shortName = it.route_short_name,
                    longName = it.route_long_name,
                )
            )
        }
        return routes
    }
}

data class Route(
    val code: String,
    val shortName: String,
    val longName: String,
)