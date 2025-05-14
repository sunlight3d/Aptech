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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.fit2081.irene33624658.views.home.BottomNavItem
import com.fit2081.assignment1.R
import com.fit2081.irene33624658.utils.SharedPreferencesHelper

@Composable
fun HomeTab(navController: NavController) {
    val context = LocalContext.current
    var user by remember { mutableStateOf<Patient?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    val scrollState = rememberScrollState()
    val prefsHelper = remember { SharedPreferencesHelper(context) }

    // load user data from CSV
    LaunchedEffect(Unit) {
        // load the user data based on saved ID and phone number from SharedPreferences
        val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val userId = prefs.getString("user_id", "") ?: ""
        val phoneNumber = prefs.getString("phone_number", "") ?: ""

        if (userId.isNotEmpty() && phoneNumber.isNotEmpty()) {
            val users = CsvReader.readPatientsFromCsv(context)
            user = users.find { it.userId == userId && it.phoneNumber == phoneNumber }
        }
        isLoading = false
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
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Text("You've already filled in your Food Intake Questionnaire, but you can change details here:")

        Spacer(modifier = Modifier.height(8.dp))

        // edit button to go back to the questionnaire
        Button(onClick = {
            val intent = Intent(context, FoodIntakeScreen::class.java)
            context.startActivity(intent)
        },
            modifier = Modifier.wrapContentWidth(),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF54DDEE)))
        {
            Icon(
                Icons.Filled.Edit, contentDescription = "Edit",
                modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text("Edit",)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // title and link to Insights screen
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("My Score", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            TextButton(
                onClick = {
                    // navigate to the insights tab
                    navController.navigate(BottomNavItem.Insights.route) {
                        // Xóa stack navigation để không quay lại Home khi bấm back
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                modifier = Modifier.wrapContentWidth(),
            ) {
                Text(
                    "See all scores",
                    color = Color(0xFF4CAF51),
                    fontWeight = FontWeight.Medium)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // placeholder image for food score visual
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
                Image(
                    painter = painterResource(id = R.drawable.food_dish),
                    contentDescription = "Description",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        // display loading message or score information
        if (isLoading) {
            Text("Loading scores...", fontSize = 16.sp)
        } else {
            user?.let {
                // Row for Food Quality score with icon and value
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                color = Color.LightGray.copy(alpha = 0.2f),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Outlined.KeyboardArrowUp,
                            contentDescription = "Score",
                            tint = Color.DarkGray,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "Your Food Quality score",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f) // Thêm weight để chiếm không gian còn lại
                    )
                    Text(
                        "${user?.heifaTotalScore ?: 0}/100".format(it.heifaTotalScore),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4CAF51)
                    )
                }

                // Other user info
                Spacer(modifier = Modifier.height(8.dp))

            } ?: run {
                Text("No user data found", fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // explanation of score
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
