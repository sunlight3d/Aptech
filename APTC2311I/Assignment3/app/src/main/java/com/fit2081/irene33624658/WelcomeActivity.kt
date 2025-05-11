package com.fit2081.irene33624658

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.fit2081.irene33624658.utils.SharedPreferencesHelper
import com.fit2081.irene33624658.food_intake.FoodIntakeScreen
//import com.fit2081.irene33624658.ui.theme.Assignment1Theme
import com.fit2081.irene33624658.viewmodels.WelcomeViewModel

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Kiểm tra trạng thái login
        val prefsHelper = SharedPreferencesHelper(this)
        if (prefsHelper.isUserLoggedIn()) {              // :contentReference[oaicite:4]{index=4}:contentReference[oaicite:5]{index=5}
            // Nếu đã login, khởi thẳng FoodIntakeScreen
            startActivity(Intent(this, FoodIntakeScreen::class.java))
            finish()                                       // không cho back về Welcome
            return
        }
        enableEdgeToEdge()
        setContent {
            WelcomeScreen(
                onLoginClick = {
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            )
        }
    }
}

@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit,
    viewModel: WelcomeViewModel = viewModel()
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.initRepository(context)
        viewModel.initializeAppData(context)
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
            modifier = Modifier.size(100.dp)
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
            modifier = Modifier.fillMaxWidth()
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
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF67CFDC),
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
