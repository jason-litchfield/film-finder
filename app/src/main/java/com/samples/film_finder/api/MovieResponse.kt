package com.samples.film_finder.api

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @field:SerializedName("page") val page: Number,
    @field:SerializedName("total_pages") val totalPages: Number,
    @field:SerializedName("results") val results: List<MovieResult>
)

data class MovieResult(
    @field:SerializedName("id") val id: String,
    @field:SerializedName("title") val title: String,
    @field:SerializedName("poster_path") val posterPath: String?
)
