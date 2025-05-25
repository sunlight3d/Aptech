package com.fit2081.irene33624658.views

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
import com.fit2081.irene33624658.views.theme.Assignment3Theme
import com.fit2081.irene33624658.viewmodels.RegisterViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import com.fit2081.irene33624658.services.LoggerService
import com.fit2081.irene33624658.services.ToastService
import com.fit2081.irene33624658.utils.SharedPreferencesHelper
import com.fit2081.irene33624658.viewmodels.LoginViewModel
import com.google.firebase.auth.FirebaseAuthUserCollisionException

/*
61436567330,4
* */
class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize services
        LoggerService.debug("RegisterActivity created")
        ToastService.init(applicationContext)
        setContent {
            Assignment3Theme {
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
    LoggerService.debug("RegisterScreen composable launched")


    // Initialize repositories
    LaunchedEffect(Unit) {
        try {
            loginViewModel.initRepository(context)
            viewModel.initRepository(context)
            LoggerService.info("Repositories initialized successfully")
        } catch (e: Exception) {
            LoggerService.error("Failed to initialize repositories", throwable = e)
            ToastService.showError("Initialization error. Please restart the app.")
        }
    }
    val scrollState = rememberScrollState()
    val isKeyboardVisible = WindowInsets.ime.getBottom(LocalDensity.current) > 0

    val patientIds by loginViewModel.patientIds.collectAsState()
    var userId by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val validationState by viewModel.validationState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(scrollState)
            .imePadding()
            .navigationBarsPadding(),
            verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Register",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,            // 👈 căn giữa chữ
            modifier = Modifier
                .fillMaxWidth()                      // 👈 cho phép Text chiếm toàn bộ chiều ngang
                .padding(bottom = 32.dp)
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
                        LoggerService.debug("User ID validation error: ${validationState.userIdError}")
                    }
                },
                trailingIcon = {
                    IconButton(onClick = {
                        expanded = true
                        LoggerService.debug("Clicked dropdown icon")
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Show IDs"
                        )
                    }
                }
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                    LoggerService.debug("ID dropdown dismissed")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                if (patientIds.isEmpty()) {
                    LoggerService.warning("No patient IDs available in dropdown")
                    DropdownMenuItem(
                        text = { Text("No IDs available") },
                        onClick = {}
                    )
                } else {
                    patientIds.forEach { pid ->
                        DropdownMenuItem(
                            text = { Text(pid) },
                            onClick = {
                                userId = pid
                                expanded = false
                                LoggerService.debug("Selected patient ID: $pid")
                            }
                        )
                    }
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
                    LoggerService.debug("Phone validation error: ${validationState.phoneError}")
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
                    LoggerService.debug("Password validation error: ${validationState.passwordError}")
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
                    LoggerService.debug("Confirm password validation error: ${validationState.confirmPasswordError}")
                    Text(validationState.confirmPasswordError!!, color = Color.Red)
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Name",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            placeholder = { Text("Enter your name") },
            isError = validationState.nameError != null,
            supportingText = {
                if (validationState.nameError != null) {
                    LoggerService.debug("Name validation error: ${validationState.nameError}")
                    Text(validationState.nameError!!, color = Color.Red)
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
            LoggerService.warning("Showing error message to user: $errorMessage")
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        Button(
            onClick = {
                showError = false

                // Run validations first
                val isPhoneValid = viewModel.validatePhone(phoneNumber)
                val isPasswordValid = viewModel.validatePassword(password, confirmPassword)

                // Now check userId via async call
                if (isPhoneValid && isPasswordValid) {
                    viewModel.validateUserId(userId) { isUserIdValid ->
                        if (!isUserIdValid) {
                            showError = true
                            errorMessage = "Invalid User ID"
                            return@validateUserId
                        }

                        // If all validations passed, proceed to register
                        viewModel.register(
                            userId = userId,
                            name = name,
                            phoneNumber = phoneNumber,
                            password = password,
                            confirmPassword = confirmPassword,
                            onSuccess = {
                                LoggerService.debug("Register success in local DB, now creating Firebase account")
                                val sharedPrefsHelper = SharedPreferencesHelper(context)

                                val auth = com.google.firebase.auth.FirebaseAuth.getInstance()
                                val email = "${phoneNumber}@fit2081.com"

                                auth.createUserWithEmailAndPassword(email, password)
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            LoggerService.info("Firebase user created successfully: ${auth.currentUser?.uid}")
                                            ToastService.showSuccess("Firebase user created successfully")
                                            context.startActivity(Intent(context, LoginActivity::class.java))
                                        } else {
                                            val exception = task.exception
                                            LoggerService.error("Firebase registration failed", throwable = exception)

                                            if (exception is FirebaseAuthUserCollisionException) {
                                                ToastService.showError("Account already exists for this phone number in Firebase !.")
                                            } else {
                                                ToastService.showError("Firebase registration failed: ${exception?.message}")
                                            }
                                        }
                                    }
                            },
                            onFailure = { msg ->
                                errorMessage = msg
                                showError = true
                            }
                        )
                    }
                } else {
                    showError = true
                    errorMessage = "Please fix the validation errors"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            )
        ) {
            Text("Register", fontSize = 16.sp)
        }


        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                LoggerService.debug("Navigate to login clicked")
                context.startActivity(Intent(context, LoginActivity::class.java))
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            )
        ) {
            Text("Login", fontSize = 16.sp)
        }
    }
}
