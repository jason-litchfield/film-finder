package com.samples.film_finder.api

import com.samples.film_finder.BuildConfig
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Test class for the interacting with The Movie Database API.
 */
class WebServiceUnitTest {
    private lateinit var service: WebService
    private var imageConfig: ImageConfig? = null

    @Before
    fun setup() {
        service = WebService()
        imageConfig = service.getImageConfig()
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
    fun getImageConfig_validRequest_hasImageConfigData() {
        assertNotNull(imageConfig)
    }

    @Test
    fun getImageConfig_validRequest_hasImageBaseUrls() {
        assertNotEquals("Image base url cannot be empty.", "", imageConfig?.baseUrl)
        assertNotEquals("Image secure base url cannot be empty.", "", imageConfig?.secureBaseUrl)
    }

    @Test
    fun getImageConfig_validRequest_hasPosterSizes() {
        assertNotEquals("Received an empty list for poster sizes.", emptyList<String>(), imageConfig?.posterSizes)
    }
}