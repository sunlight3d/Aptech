package com.fit2081.irene33624658


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fit2081.assignment1.R
import com.fit2081.irene33624658.food_intake.FoodIntakeScreen
import com.fit2081.irene33624658.ui.theme.Assignment1Theme
import com.fit2081.irene33624658.utils.CsvReader


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set the content using compose
        setContent {
            Assignment1Theme {
                LoginScreen()
            }
        }
    }
}


/**
 * Composable function for the Login Screen UI
 */
@Composable
fun LoginScreen() {
    // state variables
    var id by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    // dropdown meny expanded state
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

    // load users from CSV
    val users by remember { mutableStateOf(CsvReader.readPatientsFromCsv(context)) }

    // main layout container
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        // login title
        Text(
            text = "Login",
            fontSize = 30.sp,
            color = Color(0xFF00BCD4),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        // user ID dropdown selector
        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = id,
                onValueChange = {}, // read-only field
                label = { Text("My ID") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                trailingIcon = {
                    IconButton(onClick = { expanded = true }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_down),
                            contentDescription = "Dropdown",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                readOnly = true // prevent manual input
            )

            // dropdown menu listing unique user IDs
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                users.map { it.userId }.distinct().forEach { userId ->
                    DropdownMenuItem(
                        text = { Text(userId) },
                        onClick = {
                            id = userId
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // phone number field
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Phone number") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        // show error message if login fails
        if (showError) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "This app is only for pre-registered users. Please have your ID and phone number handy before continuing",
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Login Button
        Button(
            onClick = {
                // find user matching the entered ID and phone number
                val user = users.find { it.userId == id && it.phoneNumber == phoneNumber }
                if (user != null) {
                    // save user info to SharedPreferences
                    val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
                    with(prefs.edit()) {
                        putString("user_id", user.userId)
                        putString("phone_number", user.phoneNumber)
                        apply()
                    }
                    // navigate to Food Intake Screen
                    context.startActivity(Intent(context, FoodIntakeScreen::class.java))
                } else {
                    errorMessage = "Invalid user ID or phone number"
                    showError = true
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF67CFDC), // Teal background
                contentColor = Color.White          // White text
            )
        ) {
            Text("Login")
        }
    }
}












