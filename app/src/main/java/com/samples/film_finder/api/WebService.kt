package com.samples.film_finder.api

import com.samples.film_finder.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Service class for interacting with the remote web service for The Movie Database.
 */
class WebService {
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        chain.proceed(chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${BuildConfig.TMDB_API_V4}")
            .build()
        )}.build()

    private val movieDatabaseService: TheMovieDatabaseService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TheMovieDatabaseService::class.java)

    fun getImageConfig(): ImageConfig? = movieDatabaseService.getConfiguration().execute()
        .body()?.images

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
    }
}