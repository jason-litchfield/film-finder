package com.samples.film_finder.api

import retrofit2.Call
import retrofit2.http.GET

interface TheMovieDatabaseService {
    @GET("configuration")
    fun getConfiguration(): Call<ConfigurationResponse>
}