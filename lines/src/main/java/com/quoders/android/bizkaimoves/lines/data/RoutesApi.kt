package com.quoders.android.bizkaimoves.lines.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RoutesApiService {
    @GET("api/routes")
    suspend fun getRoutes(): RoutesApiData
}

class RoutesApi : RoutesApiService {

    private val networkApi = Retrofit.Builder()
        .baseUrl(bizkaibusBaseUrlLocalHost)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor()
                        .apply {
                            setLevel(HttpLoggingInterceptor.Level.BODY)
                        },
                )
                .build()
        )
        .build()
        .create(RoutesApiService::class.java)

    override suspend fun getRoutes(): RoutesApiData = networkApi.getRoutes()
}

data class NetworkResponse<T>(
    val data: T,
)

private const val bizkaibusBaseUrlLocalHost = "http://10.0.2.2:4000"
