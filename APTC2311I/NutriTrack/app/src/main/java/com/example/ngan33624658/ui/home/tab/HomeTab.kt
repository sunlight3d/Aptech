package com.example.ngan33624658.ui.home.tab
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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ngan33624658.models.User
import com.example.ngan33624658.utils.CsvReader
import androidx.compose.ui.*
import com.example.ngan33624658.ui.food_intake.FoodIntakeActivity
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.ngan33624658.R
import com.example.ngan33624658.ui.home.BottomNavItem

@Composable
fun HomeTab(navController: NavController) {
    val context = LocalContext.current
    var user by remember { mutableStateOf<User?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    // Load user data from CSV
    LaunchedEffect(Unit) {
        val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val userId = prefs.getString("user_id", "") ?: ""
        val phoneNumber = prefs.getString("phone_number", "") ?: ""

        if (userId.isNotEmpty() && phoneNumber.isNotEmpty()) {
            val users = CsvReader.readUsersFromCsv(context)
            user = users.find { it.userId == userId && it.phoneNumber == phoneNumber }
        }
        isLoading = false
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text("Hello,", fontSize = 24.sp)
        Text("Ngan Nguyen", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        // Row for text and Edit button
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "You've already filled in your Food Intake Questionnaire, but you can change details here:",
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {
                    val intent = Intent(context, FoodIntakeActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier.wrapContentWidth(),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6200EE),
                    contentColor = Color.White // Màu chữ và icon đen
                )
            ) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit", modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("Edit")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        // Row for My Score and See all scores
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("My Score", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            TextButton(
                onClick = {
                    // Chuyển đến tab Insights khi bấm
                    navController.navigate(BottomNavItem.Insights.route) {
                        // Xóa stack navigation để không quay lại Home khi bấm back
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                modifier = Modifier.wrapContentWidth()
            ) {
                Text("See all scores")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
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
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f) // Thêm weight để chiếm không gian còn lại
                    )
                    Text(
                        "%.1f/100".format(it.heifaTotalScore),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4CAF51)
                    )
                }

                // Other user info
                Spacer(modifier = Modifier.height(8.dp))
//                Text("Gender: ${it.sex}", fontSize = 16.sp)
//                Text("Phone: ${it.phoneNumber}", fontSize = 16.sp)
            } ?: run {
                Text("No user data found", fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("What is the Food Quality Score?", fontSize = 16.sp, fontWeight = FontWeight.Bold)
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