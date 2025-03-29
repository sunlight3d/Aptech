package com.example.ngan33624658.ui.home.tab
import android.content.Context
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ngan33624658.models.User
import com.example.ngan33624658.utils.CsvReader

@Composable
fun HomeTab() {
    val context = LocalContext.current
    var user by remember { mutableStateOf<User?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    // Load user data from CSV
    LaunchedEffect(Unit) {
        // Lấy thông tin user đã đăng nhập từ SharedPreferences
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

        Text("You've already filled in your Food Intake Questionnaire, but you can change details here:")

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { /* Handle Edit action */ }) {
            Text("Edit")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("My Score", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        TextButton(onClick = { /* Navigate to all scores */ }) {
            Text("See all scores")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            Text("Loading scores...", fontSize = 16.sp)
        } else {
            user?.let {
                Text("Your Food Quality score", fontSize = 20.sp)
                Text(
                    //"${it.heifaTotalScore.toInt()}/100",
                    "${it.heifaTotalScore}/100",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                // Hiển thị thêm các thông tin khác nếu cần
                Text("Gender: ${it.sex}", fontSize = 16.sp)
                Text("Phone: ${it.phoneNumber}", fontSize = 16.sp)
            } ?: run {
                Text("No user data found", fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("What is the Food Quality Score?", fontSize = 20.sp)
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