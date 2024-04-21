package com.example.apptours.di

import com.example.apptours.data.SearchRepoImpl
import com.example.apptours.data.retrofit.OnlineToursApi
import com.example.apptours.domain.SearchRepo
import com.example.apptours.view.presenter.ChoosePresenter
import com.example.apptours.view.presenter.ChooseView
import com.example.apptours.view.presenter.SearchPresenter
import com.example.apptours.view.presenter.SearchView
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import moxy.MvpPresenter
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://wwww.onlinetours.ru"

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .client(createOkHttpClient())
            .build()
    }

    @Singleton
    @Provides
    fun createOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val request: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Token token=7f0185a09ec234cf0c2662a14d6e6fcf").build()
            chain.proceed(request)
        }
        return httpClient.build()
    }

    @Singleton
    @Provides
    fun provideOnlineToursApi(retrofit: Retrofit): OnlineToursApi {
        return retrofit.create(OnlineToursApi::class.java)
    }

    @Singleton
    @Provides
    fun bindSearchRepo(api: OnlineToursApi): SearchRepo{
        return SearchRepoImpl(api)
    }

    @Singleton
    @Provides
    fun bindSearchPresenter(repo: SearchRepo): MvpPresenter<ChooseView>{
        return ChoosePresenter(repo)
    }

    @Singleton
    @Provides
    fun provideToursSearchPresenter(repo: SearchRepo): MvpPresenter<SearchView>{
        return SearchPresenter(repo)
    }
}