package com.example.red30.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // this is override onCreate function this invokes when main activity is created
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // This defines that app layout should be from edge to edge
        setContent { // This sets content of main activity
            Red30TechApp()
        }
    }
}
