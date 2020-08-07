package com.example.filmfinder.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.filmfinder.BuildConfig
import com.example.filmfinder.data.Movie
import com.example.filmfinder.data.MovieListResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * Class for interacting with the remote web service to fetch movie data.
 */
class RemoteMovieDataSource @Inject constructor() {
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        chain.proceed(chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $BEARER_TOKEN").build()
        )}.build()

    private val movieDbService: TheMovieDbService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheMovieDbService::class.java)


    fun getPopularMovies(): LiveData<List<Movie>> {
        val data = MutableLiveData<List<Movie>>()
        movieDbService.getPopular().enqueue(
            object : retrofit2.Callback<MovieListResponse> {
                override fun onResponse(call: retrofit2.Call<MovieListResponse>,
                                        response: retrofit2.Response<MovieListResponse>) {
                    data.value = response.body()?.results
                }
                override fun onFailure(call: retrofit2.Call<MovieListResponse>, t: Throwable) {
                    // TODO: Handle async API call error.
                }
            })
        return data
    }

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private const val BEARER_TOKEN = BuildConfig.TMDB_BEARER_TOKEN
    }
}