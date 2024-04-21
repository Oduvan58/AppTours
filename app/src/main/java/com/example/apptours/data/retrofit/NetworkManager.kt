package com.example.apptours.data.retrofit

import com.example.apptours.domain.HotelRepo
import com.example.apptours.domain.Tour
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.IOException

class NetworkManager {

    private val baseUrl = "https://wwww.onlinetours.ru"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .client(createOkHttpClient())
            .build()
    }

    private fun createOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val request: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Token token=7f0185a09ec234cf0c2662a14d6e6fcf").build()
            chain.proceed(request)
        }
        return httpClient.build()
    }

    private var onlineToursApi: OnlineToursApi = retrofit.create(OnlineToursApi::class.java)

}