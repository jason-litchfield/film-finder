package com.example.filmfinder.data

import android.util.LruCache
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

const val CACHE_SIZE = 1000

/**
 * Repository to asynchronously load movie data from the remote web service and cache locally.
 */
@Singleton
class MovieRepository @Inject constructor(
    private val movieDbService: TMDBService,
    private val cache: LruCache<String, Movie>
) {
    // TODO: Cache timeout mechanism
    fun getPopularMovies(): LiveData<List<Movie>> {
        if (cache.size() == 0) {
            movieDbService.getPopular().forEach {
                cache.put(it.id, it)
            }
        }
        return MutableLiveData(mutableListOf<Movie>().apply {
            cache.snapshot().values.forEach { this.add(it) }
        })
    }
}