package com.example.filmfinder.data

import androidx.lifecycle.LiveData
import com.example.filmfinder.api.RemoteMovieDataSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository to asynchronously load movie data from the remote web service and cache locally.
 */
@Singleton
class MovieRepository @Inject constructor(private val remoteDataSource: RemoteMovieDataSource) {
    // TODO: Cache the movie data in a local data store (Room?)
    // TODO: Fetch more data via paging
    fun getPopularMovies(): LiveData<List<Movie>> = remoteDataSource.getPopularMovies()
}