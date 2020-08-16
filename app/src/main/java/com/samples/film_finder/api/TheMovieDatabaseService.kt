package com.samples.film_finder.api

import retrofit2.Call
import retrofit2.http.GET

/**
 * Interface methods for interacting with the REST APIs at www.themoviedb.org
 */
interface TheMovieDatabaseService {
    @GET("configuration")
    fun getConfiguration(): Call<ConfigurationResponse>

    @GET("movie/popular")
    fun getPopularMovies(): Call<MovieResponse>
}