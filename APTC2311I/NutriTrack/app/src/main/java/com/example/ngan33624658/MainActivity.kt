package com.example.ngan33624658

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ngan33624658.ui.food_intake.FoodIntakeScreen
import com.example.ngan33624658.ui.home.HomeScreen
import com.example.ngan33624658.ui.login.LoginScreen
import com.example.ngan33624658.ui.welcome.WelcomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WelcomeScreen()
//            val navController: NavHostController = rememberNavController()
//            NavHost(navController, startDestination = "welcome") {
//                composable("welcome") { WelcomeScreen(navController) }
//                composable("login") { LoginScreen(navController) }
//                composable("food_intake") { FoodIntakeScreen(navController) }
//                composable("home") { HomeScreen() }
//            }
        }
    }
}
