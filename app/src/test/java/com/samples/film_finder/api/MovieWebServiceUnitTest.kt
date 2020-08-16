package com.samples.film_finder.api

import com.samples.film_finder.BuildConfig
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Test class for the interacting with The Movie Database API.
 */
class MovieWebServiceUnitTest {
    private lateinit var service: MovieWebService

    @Before
    fun setup() {
        service = MovieWebService()
    }

    @Test
    fun getApiKey_fromBuildConfigField_isAvailable() {
        assertNotNull("The authentication key cannot be null.", BuildConfig.TMDB_API_V3)
        assertNotSame("The authentication key was empty.", "", BuildConfig.TMDB_API_V3)
    }

    @Test
    fun getApiToken_fromBuildConfigField_isAvailable() {
        assertNotNull("The authentication token cannot be null.", BuildConfig.TMDB_API_V4)
        assertNotSame("The authentication key was empty.", "", BuildConfig.TMDB_API_V4)
    }

    @Test
    fun getImageConfig_validRequest_hasPosterSizes() {
        assertNotEquals(
            "Received an empty list for poster sizes.",
            emptyList<String>(),
            service.getPosterSizes()
        )
    }

    @Test
    fun getPopularMovies_validRequest_hasMovieList() {
        assertNotNull(service.getPopularMovies())
    }

    // Hate this test name. Is this class still needed?
    @Test
    fun getImage_returnsNonNullBitmap() {
        val image = service.getImage("https://image.tmdb.org/t/p/w154/b5XfICAvUe8beWExBz97i0Qw4Qh.jpg")
        assertNotNull(image)
    }
}