package com.fit2081.irene33624658.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fit2081.assignment1.R
import com.fit2081.irene33624658.services.LoggerService
import com.fit2081.irene33624658.services.ToastService
import com.fit2081.irene33624658.utils.SharedPreferencesHelper
//import com.fit2081.irene33624658.ui.theme.Assignment1Theme
import com.fit2081.irene33624658.viewmodels.WelcomeViewModel
import com.fit2081.irene33624658.views.home.HomeActivity
import com.fit2081.irene33624658.views.theme.Assignment3Theme
import kotlinx.coroutines.launch

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize services
        LoggerService.debug("WelcomeActivity created")
        ToastService.init(applicationContext)
        // 1. Kiểm tra trạng thái login
        val prefsHelper = SharedPreferencesHelper(this)
        if (prefsHelper.isUserLoggedIn()) {              // :contentReference[oaicite:4]{index=4}:contentReference[oaicite:5]{index=5}
            //LoggerService.info("User already logged in, redirecting to FoodIntakeScreen")
            //startActivity(Intent(this, FoodIntakeScreen::class.java))
            startActivity(Intent(this, HomeActivity::class.java))
            finish()                                       // không cho back về Welcome
            return
        }
        LoggerService.debug("Showing welcome screen for new/unauthenticated user")
        enableEdgeToEdge()
        setContent {
            Assignment3Theme {
                WelcomeScreen(
                    onLoginClick = {
                        LoggerService.debug("Login button clicked, navigating to LoginActivity")
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                )
            }
        }
    }
}

@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit,
    viewModel: WelcomeViewModel = viewModel()
) {
    val context = LocalContext.current

    // Spring animation for the logo
    val scale = remember { Animatable(1f) }
    val rotation = remember { Animatable(0f) }

    // Animation for disclaimer text
    val alpha = remember { Animatable(0f) }
    val offsetY = remember { Animatable(20f) }

    LaunchedEffect(Unit) {
        LoggerService.debug("WelcomeScreen composable launched")
        try {
            viewModel.initRepository(context)
            viewModel.initializeAppData(context)
            LoggerService.info("App data initialized successfully")
        } catch (e: Exception) {
            LoggerService.error("Failed to initialize app data", throwable = e)
            ToastService.showError("Initialization error. Please restart the app.")
        }
        // Spring animation sequence
        launch {
            LoggerService.debug("Starting welcome animations")
            // Bounce effect
            scale.animateTo(
                targetValue = 1.2f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            scale.animateTo(
                targetValue = 1f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )

            // Rotation effect
            rotation.animateTo(
                targetValue = 15f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            rotation.animateTo(
                targetValue = -15f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            rotation.animateTo(
                targetValue = 0f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
            // Rotation effect
            rotation.animateTo(
                targetValue = 30f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            rotation.animateTo(
                targetValue = -30f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            rotation.animateTo(
                targetValue = 0f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )

            // Rotation effect
            rotation.animateTo(
                targetValue = 15f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            rotation.animateTo(
                targetValue = -15f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            rotation.animateTo(
                targetValue = 0f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
        }
        launch {
            // Disclaimer text animation
            alpha.animateTo(1f, animationSpec = spring(stiffness = Spring.StiffnessLow))
            offsetY.animateTo(0f, animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy))
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "NutriTrack",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(18.dp))

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(100.dp)
                .scale(scale.value)
                .rotate(rotation.value)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "This app provides general health and nutrition information for educational purposes only. " +
                    "It is not intended as medical advice, diagnosis, or treatment. Always consult a qualified " +
                    "healthcare professional before making any changes to your diet, exercise, or health regimen.\n\n" +
                    "Use this app at your own risk. If you'd like to see an Accredited Practicing Dietitian (APD), " +
                    "please visit the Monash Nutrition/Dietetics Clinic (discounted rates for students)",
            fontSize = 12.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .alpha(alpha.value)
                .offset(y = offsetY.value.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "https://www.monash.edu/medicine/scs/nutrition/clinics/nutrition",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                LoggerService.debug("Login button pressed in WelcomeScreen")
                onLoginClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            )
        ) {
            Text(text = "Login", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(150.dp))

        Text(
            text = "Designed with ❤️ by Irene Nguyen (33624658)",
            fontSize = 15.sp,
            color = Color.Black
        )
    }
}
