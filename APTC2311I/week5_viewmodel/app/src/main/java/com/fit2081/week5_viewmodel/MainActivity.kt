package com.fit2081.week5_viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fit2081.week5_viewmodel.ui.theme.Week5_viewmodelTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week5_viewmodelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingScreen(innerPadding)
                }
            }
        }
    }
}

/**
 * Composable function that represents the main screen for displaying a greeting.
 * It handles user input, greeting generation, and displays the result.
 *
 * @param innerPaddingValues Padding values provided by the Scaffold to handle screen insets.
 * @param viewModel The ViewModel responsible for managing the greeting data and logic.
 */
@Composable
fun GreetingScreen(
    innerPaddingValues: PaddingValues,
    viewModel: GreetingViewModel = viewModel()
) {
    // Observe ViewModel states for reactive UI updates
    val userName = viewModel.userName
    val greetingMessage = viewModel.greetingMessage
    val isLoading = viewModel.isLoading

    // Main UI Layout: A Column for vertical arrangement of UI elements
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // TextField for user to input their name
        TextField(
            value = userName,
            onValueChange = { viewModel.updateUserName(it) },
            label = { Text("Enter your name") },
            modifier = Modifier.fillMaxWidth()
        )
        // Spacer to add vertical space between components
        Spacer(modifier = Modifier.height(16.dp))

        // Button to trigger the generation of the greeting message
        Button(
            // Trigger the generation of the greeting message when clicked
            onClick = { viewModel.generateGreeting() },
            // Align the button to the center horizontally
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Generate Greeting")
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Conditional display: show loading indicator while loading, else show the greeting
        if (isLoading) {
            // Loading indicator
            CircularProgressIndicator()
        } else {
            Text(
                text = greetingMessage,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}
