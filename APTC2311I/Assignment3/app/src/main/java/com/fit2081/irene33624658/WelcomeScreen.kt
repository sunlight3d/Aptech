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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fit2081.assignment1.R
import com.fit2081.irene33624658.ui.theme.Assignment1Theme

// entry activity for the app
class WelcomeScreen : ComponentActivity() {
    // called when the activity is starting
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // display
        // set the content view using Jetpack Compose
        setContent {
            Assignment1Theme { // apply the application's theme
                WelcomeScreen {
                    // handle button click with Activity navigation
                    val intent = Intent(this, LoginActivity::class.java)

                    startActivity(intent)
                }




            }
        }
    }
}

@Composable
fun WelcomeScreen(onLoginClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // app title
        Text(
            text = "NutriTrack",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(18.dp))

        // app logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // app disclaimer text
        Text(
            text = "This app provides general health and nutrition information for educational purposes only. It is not intended as medical advice, diagnosis, or treatment. Always consult a qualified healthcare professional before making any changes to your diet, exercise, or health regimen.\n" +
                    "\n" +
                    "Use this app at your own risk." +
                    "If you'd like to an Accredited Practicing Dietitian (APD), please visit the Monash Nutrition/Dietetics Clinic (discounted rates for students)",
            fontSize = 12.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "https://www.monash.edu/medicine/scs/nutrition/clinics/nutrition",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(40.dp))

        // login button
        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF67CFDC))
        ) {
            Text(text = "Login", fontSize = 18.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(150.dp))

        Text(
            text = "Designed with ❤️ by Irene Nguyen (33624658)",
            fontSize = 15.sp,
            color = Color.Black
        )
    }
}

