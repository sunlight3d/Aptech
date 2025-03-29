package com.example.ngan33624658.ui.home
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.example.ngan33624658.R
import com.example.ngan33624658.ui.home.tab.*

sealed class BottomNavItem(val route: String, val iconRes: Int, val label: String) {
    object Home : BottomNavItem("home", R.drawable.ic_home, "Home")
    object Insights : BottomNavItem("insights", R.drawable.ic_insights, "Insights")
    object NutriCoach : BottomNavItem("nutriCoach", R.drawable.ic_nutri_coach, "NutriCoach")
    object Settings : BottomNavItem("settings", R.drawable.ic_settings, "Settings")
}

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(navController, startDestination = BottomNavItem.Home.route, Modifier.padding(innerPadding)) {
            composable(BottomNavItem.Home.route) { HomeTab() }
            composable(BottomNavItem.Insights.route) { InsightsTab() }
            composable(BottomNavItem.NutriCoach.route) { NutriCoachTab() }
            composable(BottomNavItem.Settings.route) { SettingsTab() }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Insights,
        BottomNavItem.NutriCoach,
        BottomNavItem.Settings
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                modifier = Modifier.size(30.dp),
                icon = { Icon(
                    painter = painterResource(id = item.iconRes), // Sử dụng icon từ drawable
                    contentDescription = item.label
                ) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

