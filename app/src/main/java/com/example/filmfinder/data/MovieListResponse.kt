package com.example.filmfinder.data

import com.google.gson.annotations.SerializedName

/**
 * Data class representing a movie list response from The Movie Database.
 */
data class MovieListResponse(
    @field:SerializedName("results") val results: List<Movie>
)