package com.arthurtang.androidapppractice_winwin.network

import com.arthurtang.androidapppractice_winwin.data.ContentData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val HOST_NAME = "raw.githubusercontent.com/winwiniosapp"
//private const val BASE_URL = "https://$HOST_NAME/interview/main/"
private const val BASE_URL = "https://raw.githubusercontent.com/winwiniosapp/interview/main/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .addInterceptor(
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    ).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface WinWinApiService {
    @GET("interview2.json")
//    @GET("")
//    suspend fun getData(): ContentData
    suspend fun getData(): List<ContentData>
}

object WinWinApi {
    val retrofitService : WinWinApiService by lazy { retrofit.create(WinWinApiService::class.java) }
}



