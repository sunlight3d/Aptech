package com.example.ngan33624658.ui.food_intake
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ngan33624658.R
import com.example.ngan33624658.ui.home.HomeActivity
import com.example.ngan33624658.ui.widgets.PersonaDialog
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import com.example.ngan33624658.utils.SharedPreferencesHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerDialog(
    onCancel: () -> Unit,
    onConfirm: (Int, Int) -> Unit,
    initialHour: Int = 0,
    initialMinute: Int = 0
) {
    val timePickerState = rememberTimePickerState(
        initialHour = initialHour,
        initialMinute = initialMinute,
        is24Hour = true
    )

    AlertDialog(
        onDismissRequest = onCancel,
        title = { Text("Select Time") },
        text = {
            TimePicker(state = timePickerState)
        },
        confirmButton = {
            Button(onClick = {
                onConfirm(timePickerState.hour, timePickerState.minute)
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            Button(onClick = onCancel) {
                Text("Cancel")
            }
        }
    )
}

@Composable
fun FoodIntakeScreen() {
    var showErrorDialog by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    var selectedPersona by remember { mutableStateOf<Map<String, String>?>(null) }
    var selectedPersonaName by remember { mutableStateOf("") } // Đổi tên biến để tránh xung đột
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        // Back Navigation and Title
        // Back Navigation and Title
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                // Thay vì dùng navController, chúng ta sẽ finish activity hiện tại
                (context as android.app.Activity).finish()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Back",
                    tint = Color(0xFF6200EE),
                    modifier = Modifier.size(24.dp)
                )
            }
            Text(text = "Food Intake Questionnaire", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Food Categories Checkboxes
        Text(
            text = "Tick all the food categories you can eat",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        val foodCategories = listOf(
            "Fruits", "Vegetables", "Grains", "Red Meat", "Seafood", "Poultry", "Fish", "Eggs", "Nuts/Seeds"
        )
        val selectedFoods = remember { mutableStateListOf<String>() }

        foodCategories.chunked(3).forEach { rowItems ->
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                rowItems.forEach { food ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = selectedFoods.contains(food),
                            onCheckedChange = {
                                if (it) selectedFoods.add(food) else selectedFoods.remove(food)
                            }
                        )
                        Text(food)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Persona Selection
        Text(
            text = "Your Persona",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "People can be broadly classified into 6 different types based on their eating preferences. Click on each button below to find out more.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(10.dp))

        val personas = listOf(
            mapOf(
                "name" to "Health Devotee",
                "image" to R.drawable.image1.toString(),
                "description" to "I am passionate about healthy eating. I follow fitness influencers and always look for new diets and superfoods. My goal is to maintain a healthy lifestyle through proper nutrition and exercise."
            ),
            mapOf(
                "name" to "Mindful Eater",
                "image" to R.drawable.image2.toString(),
                "description" to "I eat with full awareness, focusing on the quality of food I consume. I avoid distractions while eating and take time to appreciate every bite. My choices are guided by my health and emotional well-being."
            ),
            mapOf(
                "name" to "Wellness Striver",
                "image" to R.drawable.image3.toString(),
                "description" to "I try to balance my diet and fitness routines while managing a busy lifestyle. I prioritize fresh, whole foods but occasionally indulge in my favorite treats. Staying active and maintaining consistency is my key goal."
            ),
            mapOf(
                "name" to "Balance Seeker",
                "image" to R.drawable.image3.toString(),
                "description" to "I seek a balanced approach to eating, avoiding extreme diets. My meals include a variety of whole grains, proteins, and healthy fats. Moderation is important to me, and I focus on long-term sustainability."
            ),
            mapOf(
                "name" to "Health Procrastinator",
                "image" to R.drawable.image5.toString(),
                "description" to "I want to eat healthy but often delay changes due to time constraints. I know the benefits of good nutrition but struggle with meal planning. My goal is to start making small, positive changes in my diet."
            ),
            mapOf(
                "name" to "Food Carefree",
                "image" to R.drawable.image6.toString(),
                "description" to "I eat whatever I feel like, without overthinking nutrition labels. I enjoy trying different cuisines and believe food should be enjoyed. I don’t follow strict rules but listen to my body’s cravings."
            )
        )
        personas.chunked(2).forEach { rowItems ->
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                rowItems.forEach { persona ->
                    Button(
                        onClick = {
                            selectedPersona = persona
                            showDialog = true
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE)),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(text = persona["name"] ?: "", color = Color.White, fontSize = 13.sp)
                    }
                }
            }
        }

        // Persona Dialog
        selectedPersona?.let { persona ->
            PersonaDialog(
                showDialog = showDialog,
                onDismiss = { showDialog = false },
                imageRes = persona["image"]?.toIntOrNull() ?: 0, // Sửa lỗi chuyển đổi
                title = persona["name"] ?: "",
                description = persona["description"] ?: ""
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Dropdown for Persona Selection
        Text(
            text = "Which persona best fits you?",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        DropdownPersonaSelector(
            personas = personas.map { it["name"] ?: "" }, // Chuyển đổi thành List<String>
            selectedPersona = selectedPersonaName,
            onPersonaSelected = { selectedPersonaName = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Replace the existing timeLabels section with this code:

// Timings
        Text(text = "Timings", fontSize = 18.sp, fontWeight = FontWeight.Medium)

        val timeLabels = listOf(
            "What time do you normally eat your biggest meal?",
            "What time do you go to sleep at night?",
            "What time do you wake up in the morning?"
        )

// Create state variables for each time
        var biggestMealTime by remember { mutableStateOf("00:00") }
        var sleepTime by remember { mutableStateOf("00:00") }
        var wakeUpTime by remember { mutableStateOf("00:00") }

// Create state variables for showing time pickers
        var showBiggestMealTimePicker by remember { mutableStateOf(false) }
        var showSleepTimePicker by remember { mutableStateOf(false) }
        var showWakeUpTimePicker by remember { mutableStateOf(false) }

// Time picker dialogs
        if (showBiggestMealTimePicker) {
            TimePickerDialog(
                onCancel = { showBiggestMealTimePicker = false },
                onConfirm = { hour, minute ->
                    biggestMealTime = String.format("%02d:%02d", hour, minute)
                    showBiggestMealTimePicker = false
                },
                initialHour = biggestMealTime.substringBefore(":").toInt(),
                initialMinute = biggestMealTime.substringAfter(":").toInt()
            )
        }

        if (showSleepTimePicker) {
            TimePickerDialog(
                onCancel = { showSleepTimePicker = false },
                onConfirm = { hour, minute ->
                    sleepTime = String.format("%02d:%02d", hour, minute)
                    showSleepTimePicker = false
                },
                initialHour = sleepTime.substringBefore(":").toInt(),
                initialMinute = sleepTime.substringAfter(":").toInt()
            )
        }

        if (showWakeUpTimePicker) {
            TimePickerDialog(
                onCancel = { showWakeUpTimePicker = false },
                onConfirm = { hour, minute ->
                    wakeUpTime = String.format("%02d:%02d", hour, minute)
                    showWakeUpTimePicker = false
                },
                initialHour = wakeUpTime.substringBefore(":").toInt(),
                initialMinute = wakeUpTime.substringAfter(":").toInt()
            )
        }

// Time selection rows
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(timeLabels[0], modifier = Modifier.weight(1f))
            Button(
                onClick = { showBiggestMealTimePicker = true },
                modifier = Modifier.width(120.dp)
            ) {
                Text(biggestMealTime)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(timeLabels[1], modifier = Modifier.weight(1f))
            Button(
                onClick = { showSleepTimePicker = true },
                modifier = Modifier.width(120.dp)
            ) {
                Text(sleepTime)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(timeLabels[2], modifier = Modifier.weight(1f))
            Button(
                onClick = { showWakeUpTimePicker = true },
                modifier = Modifier.width(120.dp)
            ) {
                Text(wakeUpTime)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Save Button
        Button(
            onClick = {
                // Kiểm tra validation
                when {
                    selectedFoods.isEmpty() -> {
                        errorMessage = "Please select at least one food category"
                        showErrorDialog = true
                    }
                    selectedPersonaName.isEmpty() -> {
                        errorMessage = "Please select your persona"
                        showErrorDialog = true
                    }
                    !isTimeValid(biggestMealTime) || !isTimeValid(sleepTime) || !isTimeValid(wakeUpTime) -> {
                        errorMessage = "Vui lòng chọn thời gian hợp lệ"
                        showErrorDialog = true
                    }
                    else -> {
                        // Lưu dữ liệu vào SharedPreferences
                        val prefsHelper = SharedPreferencesHelper(context)
                        prefsHelper.saveFoodPreferences(selectedFoods)
                        prefsHelper.savePersona(selectedPersonaName)
                        prefsHelper.saveTimings(biggestMealTime, sleepTime, wakeUpTime)

                        // Chuyển đến HomeActivity
                        val intent = Intent(context, HomeActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        context.startActivity(intent)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
        ) {
            Icon(Icons.Default.ArrowDropDown, contentDescription = "Save", tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Save", fontSize = 18.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(40.dp))
        ErrorDialog(
            show = showErrorDialog,
            message = errorMessage,
            onDismiss = { showErrorDialog = false }
        )
    }
}

@Composable
fun ErrorDialog(show: Boolean, message: String, onDismiss: () -> Unit) {
    if (show) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Missing Information") },
            text = { Text(message) },
            confirmButton = {
                Button(onClick = onDismiss) {
                    Text("OK")
                }
            }
        )
    }
}
fun isTimeValid(time: String): Boolean {
    return try {
        val parts = time.split(":")
        val hour = parts[0].toInt()
        val minute = parts[1].toInt()
        hour in 0..23 && minute in 0..59 && time != "00:00"
    } catch (e: Exception) {
        false
    }
}