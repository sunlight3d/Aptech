package com.fit2081.week5_viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Calendar

// GreetingViewModel: A ViewModel to manage UI state related to greeting messages.
class GreetingViewModel : ViewModel() {
    // Stores the name of the user. Default is an empty string.
    var userName by mutableStateOf("")
        private set // Prevent external modification;
    // can only be updated through ViewModel functions.

    // Stores the greeting message to be displayed.
    // Default is an empty string.
    var greetingMessage by mutableStateOf("")
        private set // Prevent external modification;
    // can only be updated through ViewModel functions.

    // Indicates whether a loading operation is in progress. Default is false.
    var isLoading by mutableStateOf(false)
        private set // Prevent external modification; controlled within ViewModel.

    /**
     * Updates the userName property.
     * @param name - The new name provided by the user.
     */
    fun updateUserName(name: String) {
        userName = name
    }
    /**
     * Generates a personalized greeting message
     * based on the time of day and the user's name.
     * The operation is asynchronous to simulate processing delay.
     * If the userName is blank, an error message is displayed.
     */
    fun generateGreeting() {
        //viewModelScope is a coroutine scope tied to the ViewModel's lifecycle.
        //We need it to run the delay operation without blocking the UI.
        viewModelScope.launch {
            isLoading = true // Set loading state to true during the operation.
            delay(1000) // Simulate a delay (e.g., fetching or processing data).

            if (userName.isNotBlank()) { // Ensure userName is not empty.
                // Get the current hour of the day (0-23).
                val currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

                // Determine greeting message based on the current time.
                greetingMessage = when (currentTime) {
                    in 0..11 -> "Good Morning, $userName!"
                    in 12..17 -> "Good Afternoon, $userName!"
                    else -> "Good Evening, $userName!"
                }
            } else {
                // Display error message if no name is provided.
                greetingMessage = "Please enter your name."
            }
            isLoading = false // Set loading state back
        // to false after the operation completes.
        }
    }
}