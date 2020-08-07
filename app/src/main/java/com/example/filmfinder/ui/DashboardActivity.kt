package com.example.filmfinder.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.filmfinder.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main activity class for the Film Finder app.
 */
@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)
    }
}