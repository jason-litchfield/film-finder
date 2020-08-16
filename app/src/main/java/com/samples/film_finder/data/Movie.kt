package com.samples.film_finder.data

import android.graphics.Bitmap

data class Movie(val id: String, val title: String, val poster: Bitmap? = null)