package com.fit2081.irene33624658.views.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.fit2081.assignment1.R
import com.fit2081.irene33624658.views.home.tab.HomeTab
import com.fit2081.irene33624658.views.home.tab.InsightsTab
import com.fit2081.irene33624658.views.home.tab.NutriCoachTab
import androidx.compose.runtime.getValue
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.NavHost
import com.fit2081.irene33624658.home.SettingsTab

// sealed class representing each bottom navigation tab with its route, icon, and label
sealed class BottomNavItem(val route: String, val iconRes: Int, val label: String) {
    object Home : BottomNavItem("home", R.drawable.ic_home, "Home")
    object Insights : BottomNavItem("insights", R.drawable.ic_insights, "Insights")
    object NutriCoach : BottomNavItem("nutriCoach", R.drawable.ic_nutri_coach, "NutriCoach")
    object Settings : BottomNavItem("settings", R.drawable.ic_settings, "Settings")
}

@Composable
fun HomeScreen() {
    val navController = rememberNavController() // to manage navigation
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = BottomNavItem.Home.route, // set default screen
            Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Home.route) { HomeTab(navController) }
            // Truyền navController vào InsightsTab
            composable(BottomNavItem.Insights.route) { InsightsTab(navController) }
            composable(BottomNavItem.NutriCoach.route) { NutriCoachTab() }
            composable(BottomNavItem.Settings.route) {
                SettingsTab(navController = navController)  // Context sẽ tự động được lấy từ LocalContext
            }
        }
    }
}

// bottom navigation bar component
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
                    painter = painterResource(id = item.iconRes),
                    contentDescription = item.label
                ) },
                label = { Text(item.label) },
                selected = currentRoute == item.route, // highlight selected item
                onClick = {
                    navController.navigate(item.route) {
                        // avoid creating multiple copies of the same destination
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

