package com.example.filmfinder.data

import com.google.gson.annotations.SerializedName

/**
 * Data class representing an individual movie result returned by The Movie Database.
 */
data class Movie (
    @field:SerializedName("id") var id: String,
    @field:SerializedName("title") var title: String,
    @field:SerializedName("poster_path") var posterPath: String
)