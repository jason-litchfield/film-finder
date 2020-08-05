package com.example.filmfinder.data

/**
 * Interface methods for interacting with the REST APIs at www.themoviedb.org
 */
interface TMDBService {
    // TODO: Connect to actual REST endpoints
    fun getPopular(): List<Movie> = emptyList()
}
