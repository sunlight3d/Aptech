package com.fit2081.irene33624658.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fit2081.irene33624658.services.LoggerService
import com.fit2081.irene33624658.services.ToastService
import com.fit2081.irene33624658.views.food_intake.FoodIntakeScreen
import com.fit2081.irene33624658.views.theme.Assignment1Theme
import com.fit2081.irene33624658.viewmodels.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize services
        LoggerService.debug("LoginActivity created")
        ToastService.init(applicationContext)
        setContent {
            Assignment1Theme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()) {
    val context = LocalContext.current
    // Track initialization state
    var isInitialized by remember { mutableStateOf(false) }
    // Initialize repository
    LaunchedEffect(Unit) {
        try {
            viewModel.initRepository(context)
            LoggerService.info("Login repository initialized successfully")
            isInitialized = true
        } catch (e: Exception) {
            LoggerService.error("Failed to initialize login repository", throwable = e)
            ToastService.showError("Initialization error. Please restart the app.")
        }
    }

    LoggerService.debug("LoginScreen composable launched")
    val scrollState = rememberScrollState()
    val isKeyboardVisible = WindowInsets.ime.getBottom(LocalDensity.current) > 0

    if (isInitialized && viewModel.isUserLoggedIn(context)) {
        LoggerService.info("User already logged in, redirecting to FoodIntakeScreen")
        context.startActivity(Intent(context, FoodIntakeScreen::class.java))
        return
    }

    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val patientIds by viewModel.patientIds.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(scrollState)
            .imePadding()
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Log in",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,  // đậm hơn
            color = Color.Black,
            textAlign = TextAlign.Center,       // căn giữa
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        )

        // Nhãn My ID có thể bấm cả vùng Text để mở dropdown
        Text(
            text = "My ID (Provided by your Clinician)",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true
                    LoggerService.debug("ID dropdown opened", tag = "LoginScreen")
                }
                .padding(bottom = 4.dp)
        )

        Box(modifier = Modifier.fillMaxWidth().animateContentSize()  ) {
            OutlinedTextField(
                value = id,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        expanded = true
                        LoggerService.debug("ID field clicked to open dropdown", tag = "LoginScreen")
                    }
                    .animateContentSize()
                , // bấm vào khung cũng mở
                shape = RoundedCornerShape(12.dp),
                readOnly = true,
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
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize()
            ) {
                patientIds.forEach { patientId ->
                    DropdownMenuItem(
                        text = { Text(patientId) },
                        onClick = {
                            id = patientId
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Password",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = { Text("Enter your password") }
        )

        AnimatedVisibility(
            visible = showError,
            enter = fadeIn(animationSpec = tween(durationMillis = 2000))
                    + expandVertically(animationSpec = tween(durationMillis = 2000)),
            exit = fadeOut(animationSpec = tween(durationMillis = 2200))
                    + shrinkVertically(animationSpec = tween(durationMillis = 2200))
        ) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "This app is only for pre-registered users. Please enter your ID and password or Register to claim your account on your first visit.",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        Button(
            onClick = {
                if (id.isBlank() || password.isBlank()) {
                    errorMessage = "Please enter both user ID and password"
                    showError = true
                } else {
                    coroutineScope.launch {
                        val phoneNumber = viewModel.getPhoneNumberByUserId(id)

                        if (phoneNumber != null) {
                            val email = "${phoneNumber}@fit2081.com"
                            val auth = FirebaseAuth.getInstance()

                            auth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        LoggerService.info("Firebase login successful: ${auth.currentUser?.uid}")
                                        ToastService.showSuccess("Logged in with Firebase")
                                        context.startActivity(Intent(context, FoodIntakeScreen::class.java))
                                    } else {
                                        LoggerService.error("Firebase login failed", throwable = task.exception)
                                        ToastService.showError("Firebase login failed: ${task.exception?.message}")
                                    }
                                }
                        } else {
                            ToastService.showError("Unable to get phone number for this user")
                        }
                    }

                }
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
            Text("Continue", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                context.startActivity(Intent(context, RegisterActivity::class.java))
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
    }
}
