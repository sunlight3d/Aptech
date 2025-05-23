package com.fit2081.irene33624658.views.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.fit2081.irene33624658.views.theme.Assignment3Theme

class HomeActivity: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment3Theme {
                HomeScreen()
            }
        }
    }
}
