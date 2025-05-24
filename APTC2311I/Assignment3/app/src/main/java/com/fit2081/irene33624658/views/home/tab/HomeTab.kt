package com.fit2081.irene33624658.views.home.tab

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.fit2081.irene33624658.models.Patient
import com.fit2081.irene33624658.utils.CsvReader
import com.fit2081.irene33624658.views.food_intake.FoodIntakeScreen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.fit2081.irene33624658.views.home.BottomNavItem
import com.fit2081.assignment1.R
import com.fit2081.irene33624658.utils.SharedPreferencesHelper
import coil.compose.AsyncImage
import com.fit2081.irene33624658.services.LoggerService
import com.fit2081.irene33624658.services.ToastService
import com.fit2081.irene33624658.viewmodels.HomeViewModel


@Composable
fun HomeTab(navController: NavController) {
    val context = LocalContext.current
    val viewModel: HomeViewModel = viewModel()

    // Init repository và load user 1 lần
    LaunchedEffect(Unit) {
        viewModel.initRepository(context)
        viewModel.loadUser(context)
        ToastService.showSuccess("Welcome to Home!")
        LoggerService.debug("HomeTab screen loaded", tag = "HomeTab")
    }

    // State từ ViewModel
    val user by viewModel.user.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val scrollState = rememberScrollState()

    val imageUrl = remember {
        val randomId = (1..500).random()
        mutableStateOf("https://picsum.photos/id/$randomId/300")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        // greeting and user ID
        Text("Hello,", fontSize = 24.sp)
        Text(
            text = user?.userId ?: "User",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("You've already filled in your Food Intake Questionnaire, but you can change details here:")
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                LoggerService.info("Navigating to Food Intake screen", tag = "HomeTab")
                ToastService.showShort("Opening Food Intake form")
                val intent = Intent(context, FoodIntakeScreen::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth(0.33f).height(48.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF54DDEE))
        ) {
            Icon(Icons.Filled.Edit, contentDescription = "Edit", modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text("Edit")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("My Score", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            TextButton(
                onClick = {
                    navController.navigate(BottomNavItem.Insights.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            ) {
                Text("See all scores", color = Color(0xFF4CAF51), fontWeight = FontWeight.Medium)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Image
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .aspectRatio(1f)
                    .background(Color.LightGray)
            ) {
                AsyncImage(
                    model = imageUrl.value,
                    contentDescription = "Random image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            Text("Loading scores...", fontSize = 16.sp)
        } else {
            user?.let {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.LightGray.copy(alpha = 0.2f), shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Outlined.KeyboardArrowUp, contentDescription = "Score", tint = Color.DarkGray)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "Your Food Quality score",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        "${it.heifaTotalScore}/100",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4CAF51)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            } ?: run {
                Text("No user data found", fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("What is the Food Quality Score?", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Your Food Quality Score provides a snapshot of how well your eating patterns align with established food guidelines, helping you identify both strengths and opportunities for improvement in your diet.",
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "This personalized measurement considers various food groups including vegetables, fruits, whole grains, and proteins to give you practical insights for making healthier food choices.",
            fontSize = 16.sp
        )
    }
}
