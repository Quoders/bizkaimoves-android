package com.quoders.bizkaimoves

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.quoders.bizkaimoves.ui.BizkaimovesApp

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizkaimovesApp()
        }
    }
}