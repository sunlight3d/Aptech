package com.fit2081.irene33624658

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fit2081.irene33624658.ui.theme.Assignment1Theme
import com.fit2081.irene33624658.viewmodels.RegisterViewModel
import android.content.Context
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fit2081.irene33624658.food_intake.FoodIntakeScreen
import com.fit2081.irene33624658.ui.theme.Assignment1Theme
import com.fit2081.irene33624658.viewmodels.LoginViewModel
import kotlinx.coroutines.launch

/*
61436567330,4
* */
class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment1Theme {
                RegisterScreen()
            }
        }
    }
}

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = viewModel(),
    loginViewModel: LoginViewModel = viewModel()
) {
    val context = LocalContext.current
    // Khởi tạo repository và load danh sách ID
    loginViewModel.initRepository(context)
    viewModel.initRepository(context)
    val patientIds by loginViewModel.patientIds.collectAsState()

    var userId by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val validationState by viewModel.validationState
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Register",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // === My ID with dropdown ===
        Text(
            text = "My ID (Provided by your Clinician)",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
                .padding(bottom = 4.dp)
        )
        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = userId,
                onValueChange = { /* readOnly */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = true },
                shape = RoundedCornerShape(12.dp),
                readOnly = true,
                isError = validationState.userIdError != null,
                supportingText = {
                    if (validationState.userIdError != null) {
                        Text(validationState.userIdError!!, color = Color.Red)
                    }
                },
                trailingIcon = {
                    IconButton(onClick = { expanded = true }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Show IDs"
                        )
                    }
                }
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                patientIds.forEach { pid ->
                    DropdownMenuItem(
                        text = { Text(pid) },
                        onClick = {
                            userId = pid
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // === Phone Number Field ===
        Text(
            text = "Phone Number",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            placeholder = { Text("Enter your phone number") },
            isError = validationState.phoneError != null,
            supportingText = {
                if (validationState.phoneError != null) {
                    Text(validationState.phoneError!!, color = Color.Red)
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // === Password Field ===
        Text(
            text = "Password",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = { Text("Enter your password") },
            isError = validationState.passwordError != null,
            supportingText = {
                if (validationState.passwordError != null) {
                    Text(validationState.passwordError!!, color = Color.Red)
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // === Confirm Password Field ===
        Text(
            text = "Confirm Password",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = { Text("Enter your password again") },
            isError = validationState.confirmPasswordError != null,
            supportingText = {
                if (validationState.confirmPasswordError != null) {
                    Text(validationState.confirmPasswordError!!, color = Color.Red)
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "This app is only for pre-registered users. Please enter your ID, phone number and password to claim your account.",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        if (showError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        Button(
            onClick = {
                viewModel.register(
                    userId = userId,
                    phoneNumber = phoneNumber,
                    password = password,
                    onSuccess = {
                        context.startActivity(
                            Intent(context, FoodIntakeScreen::class.java)
                        )
                    },
                    onFailure = { msg ->
                        errorMessage = msg
                        showError = true
                    }
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF67CFDC),
                contentColor = Color.White
            )
        ) {
            Text("Register", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = {
                context.startActivity(Intent(context, LoginActivity::class.java))
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Login", color = Color(0xFF67CFDC))
        }
    }
}
