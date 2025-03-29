package com.example.ngan33624658.ui.login
import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ngan33624658.R
import com.example.ngan33624658.ui.food_intake.FoodIntakeActivity
import com.example.ngan33624658.utils.CsvReader


//Android Composable = JAVA => NO !
//Android Composable = Kotlin => YES !

//Apple = SwiftUI = Swift => YES !
//Apple = SwiftUI = Objective C => NO !
@Composable
fun LoginScreen() {
    val context = LocalContext.current
    var phoneNumber by remember { mutableStateOf("61436567330") }
    var userId by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    // Đọc dữ liệu từ CSV
    val users by remember {
        mutableStateOf(CsvReader.readUsersFromCsv(context))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        //userID: 4, phone: 61436567330
        Text(text = "Log in", fontSize = 30.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(20.dp))

        // Dropdown cho User ID
        var expanded by remember { mutableStateOf(false) }
        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = userId,
                onValueChange = { userId = it },
                label = { Text("My ID") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                trailingIcon = {
                    IconButton(onClick = { expanded = true }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_down),
                            contentDescription = "Dropdown",
                            modifier = Modifier.size(24.dp))
                    }
                },
                readOnly = true
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                users.map { it.userId }.distinct().forEach { id ->
                    DropdownMenuItem(
                        text = { Text(id) },
                        onClick = {
                            userId = id
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Phone number") },

            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        if (showError) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            //61436567330,4,
            text = "This app is only for pre-registered users. Please have your ID and phone number handy before continuing",
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val user = users.find { it.userId == userId && it.phoneNumber == phoneNumber }

                if (user != null) {
                    val intent = Intent(context, FoodIntakeActivity::class.java)
                    context.startActivity(intent)
                } else {
                    // ... (giữ nguyên phần xử lý lỗi)
                }
            },
            // ... (giữ nguyên phần còn lại của Button)
        ) {
            Text(text = "Continue", fontSize = 18.sp)
        }
    }
}