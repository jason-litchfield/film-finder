package com.samples.film_finder.api

import com.google.gson.annotations.SerializedName

data class ConfigurationResponse(
    @field:SerializedName("images") val images: ImageConfig
)

data class ImageConfig(
    @field:SerializedName("base_url") val baseUrl: String,
    @field:SerializedName("secure_base_url") val secureBaseUrl: String,
    @field:SerializedName("poster_sizes") val posterSizes: List<String>
)
