package com.example.filmfinder.api

import com.example.filmfinder.data.MovieListResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Interface methods for interacting with the REST APIs at www.themoviedb.org
 */
interface TheMovieDbService {
    @GET("movie/popular")
    fun getPopular(): Call<MovieListResponse>
}
