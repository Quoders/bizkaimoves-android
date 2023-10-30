package com.quoders.android.bizkaimoves.lines.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class RouteData(
    val route_id: Int,
    val route_short_name: String,
    val route_long_name: String,
)

interface RoutesApiService {
    @GET("api/routes")
    suspend fun getRoutes(): List<RouteData>
}

class RoutesApi : RoutesApiService {
    private val logging = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val networkApi = Retrofit.Builder()
        .baseUrl(bizkaibusBaseUrlLocalHost)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(RoutesApiService::class.java)

    override suspend fun getRoutes() = networkApi.getRoutes()
}

private const val bizkaibusBaseUrlLocalHost = "https://bizkaibus-api-52b009d032a6.herokuapp.com"
