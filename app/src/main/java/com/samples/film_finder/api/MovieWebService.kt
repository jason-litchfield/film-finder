package com.samples.film_finder.api

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.samples.film_finder.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedInputStream

/**
 * Service class for interacting with the remote web service for The Movie Database.
 */
class MovieWebService {
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        chain.proceed(
            chain.request().newBuilder()
                .addHeader("Authorization", "Bearer ${BuildConfig.TMDB_API_V4}")
                .build()
        )
    }.build()

    private val movieDatabaseService: TheMovieDatabaseService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TheMovieDatabaseService::class.java)

    private val imageConfig: ImageConfig? = movieDatabaseService.getConfiguration().execute()
        .body()?.images

    fun getPosterSizes(): List<String> = imageConfig?.posterSizes ?: emptyList()

    fun getPopularMovies(): List<MovieResult> = movieDatabaseService.getPopularMovies().execute()
        .body()?.results ?: emptyList()

    fun getImage(imagePath: String): Bitmap? = BitmapFactory.decodeStream(
        BufferedInputStream(
            client.newCall(Request.Builder().url("${imageConfig?.secureBaseUrl}$imagePath").build())
                .execute().body()?.byteStream()
        )
    )

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
    }
}