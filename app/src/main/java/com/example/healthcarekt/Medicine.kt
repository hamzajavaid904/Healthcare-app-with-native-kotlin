package com.example.healthcarekt

import android.app.AppComponentFactory
import android.os.Bundle
import androidx.activity.ComponentActivity

class Medicine : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.medicine)
    }
}