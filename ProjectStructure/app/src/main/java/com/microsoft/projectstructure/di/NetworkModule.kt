package com.microsoft.projectstructure.di

import com.microsoft.projectstructure.data.remote.RemoteDataSource
import com.microsoft.projectstructure.data.remote.Webservice
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.microsoft.projectstructure.BuildConfig.BASEURL


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideWebService(): Webservice {
        val gSONBuilder = GsonBuilder()
            .setLenient()
            .create()
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl(BASEURL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gSONBuilder))
            .build().create(Webservice::class.java)
    }

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(webservice: Webservice) = RemoteDataSource(webservice)

}