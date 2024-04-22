package com.example.apptours.di

import com.example.apptours.data.HotelsRepoImpl
import com.example.apptours.data.HotelsUseCaseImpl
import com.example.apptours.data.SearchRepoImpl
import com.example.apptours.data.retrofit.OnlineToursApi
import com.example.apptours.domain.HotelsRepo
import com.example.apptours.domain.SearchRepo
import com.example.apptours.domain.SearchToursUseCase
import com.example.apptours.view.presenter.ChoosePresenter
import com.example.apptours.view.presenter.ChooseToPresenter
import com.example.apptours.view.presenter.ChooseToView
import com.example.apptours.view.presenter.ChooseView
import com.example.apptours.view.presenter.HotelsPresenter
import com.example.apptours.view.presenter.HotelsView
import com.example.apptours.view.presenter.SearchPresenter
import com.example.apptours.view.presenter.SearchView
import com.google.gson.GsonBuilder
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
    fun bindSearchRepo(api: OnlineToursApi): SearchRepo {
        return SearchRepoImpl(api)
    }

    @Singleton
    @Provides
    fun bindHotelsUseCase(repo: HotelsRepo, useCase: SearchToursUseCase) =
        HotelsUseCaseImpl(repo, useCase)


    @Singleton
    @Provides
    fun bindHotelsRepo(api: OnlineToursApi): HotelsRepo {
        return HotelsRepoImpl(api)
    }

    @Singleton
    @Provides
    fun bindSearchPresenter(
        repo: SearchRepo,
        useCase: SearchToursUseCase
    ): MvpPresenter<ChooseView> {
        return ChoosePresenter(repo, useCase)
    }

    @Singleton
    @Provides
    fun bindSearchToPresenter(
        repo: SearchRepo,
        useCase: SearchToursUseCase
    ): MvpPresenter<ChooseToView> {
        return ChooseToPresenter(repo, useCase)
    }

    @Singleton
    @Provides
    fun provideToursSearchPresenter(useCase: SearchToursUseCase): MvpPresenter<SearchView> {
        return SearchPresenter(useCase)
    }

    @Singleton
    @Provides
    fun provideHotelsPresenter(useCase: HotelsUseCaseImpl): MvpPresenter<HotelsView> {
        return HotelsPresenter(useCase)
    }
}