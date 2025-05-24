package com.fit2081.irene33624658.views.food_intake

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.LaunchedEffect
import com.fit2081.assignment1.R
import com.fit2081.irene33624658.views.food_intake.ui.theme.widgets.PersonaDialog
import com.fit2081.irene33624658.views.home.HomeActivity
import com.fit2081.irene33624658.utils.SharedPreferencesHelper


class FoodIntakeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FoodIntake()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerDialog (
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
            }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6EC9D5))) {
                Text("OK")
            }
        },
        dismissButton = {
            Button(onClick = onCancel,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6EC9D5))) {
                Text("Cancel", color = Color.White)
            }
        }
    )
}

@Composable
fun FoodIntake() {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    var selectedPersona by remember { mutableStateOf<Map<String, String>?>(null) }
    var selectedPersonaName by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    var showErrorDialog by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    val prefsHelper = remember { SharedPreferencesHelper(context) }

    val primaryColor = Color(0xFF79C5BF)
    val backgroundColor = Color(0xFFF3F3F3)  // Light background
    val cardColor = Color.White
    val textColor = Color(0xFF212121)  // Dark text

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Spacer(modifier = Modifier.height(20.dp))

        // Back Navigation and Title
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
//            Button(
//                onClick = {
//                    // Finish current activity to go back
//                    (context as Activity).finish()
//                },
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = Color.Transparent,
//                    contentColor = primaryColor)
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_back),
//                    contentDescription = "Back",
//                    tint = Color(0xFF6EC9D5),
//                    modifier = Modifier.size(24.dp)
//                )
//            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp), // 👈 Dịch xuống 1 chút
                horizontalArrangement = Arrangement.Center, // 👈 Căn giữa ngang
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Food Intake Questionnaire",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                    textAlign = TextAlign.Center // 👈 Đảm bảo text được căn giữa nếu có nhiều dòng
                )
            }
        }

        // Food Categories - Just add Card and colors
        Surface(
            color = cardColor,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Tick all the food categories you can eat",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryColor  // Changed color
                )


        val foodCategories = listOf(
            "Fruits", "Vegetables", "Grains", "Red Meat", "Seafood", "Poultry", "Fish", "Eggs", "Nuts/Seeds"
        )
        val selectedFoods = remember { mutableStateListOf<String>() }

                Column(modifier = Modifier.fillMaxWidth()) {
                    foodCategories.chunked(3).forEach { rowItems ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            rowItems.forEach { food ->
                                // each item takes equal width
                                Box (modifier = Modifier.weight(1f)) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(vertical = 4.dp)
                                    ) {
                                        Checkbox(
                                            checked = selectedFoods.contains(food),
                                            onCheckedChange = {
                                                if (it) selectedFoods.add(food) else selectedFoods.remove(food)
                                            },
                                            colors = CheckboxDefaults.colors(
                                                checkedColor = Color(0xFF79C5BF),  // teal color when checked
                                                uncheckedColor = Color.Gray,
                                                checkmarkColor = Color.White
                                            )
                                        )
                                        Text(
                                            text = food,
                                            modifier = Modifier.padding(start = 0.dp))

                                    }
                                }
                            }
                            // fill remaining space if less than 3 items
                            if (rowItems.size < 3) {
                                repeat(3 - rowItems.size) {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
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

                // persona buttons + dialog
        val personas = listOf(
            mapOf(
                "name" to "Health Devotee",
                "image" to R.drawable.persona_1.toString(),
                "description" to "I am passionate about healthy eating. I follow fitness influencers and always look for new diets and superfoods. My goal is to maintain a healthy lifestyle through proper nutrition and exercise."
            ),
            mapOf(
                "name" to "Mindful Eater",
                "image" to R.drawable.persona_2.toString(),
                "description" to "I eat with full awareness, focusing on the quality of food I consume. I avoid distractions while eating and take time to appreciate every bite. My choices are guided by my health and emotional well-being."
            ),
            mapOf(
                "name" to "Wellness Striver",
                "image" to R.drawable.persona_3.toString(),
                "description" to "I try to balance my diet and fitness routines while managing a busy lifestyle. I prioritize fresh, whole foods but occasionally indulge in my favorite treats. Staying active and maintaining consistency is my key goal."
            ),
            mapOf(
                "name" to "Balance Seeker",
                "image" to R.drawable.persona_4.toString(),
                "description" to "I seek a balanced approach to eating, avoiding extreme diets. My meals include a variety of whole grains, proteins, and healthy fats. Moderation is important to me, and I focus on long-term sustainability."
            ),
            mapOf(
                "name" to "Health Procrastinator",
                "image" to R.drawable.persona_5.toString(),
                "description" to "I want to eat healthy but often delay changes due to time constraints. I know the benefits of good nutrition but struggle with meal planning. My goal is to start making small, positive changes in my diet."
            ),
            mapOf(
                "name" to "Food Carefree",
                "image" to R.drawable.persona_6.toString(),
                "description" to "I eat whatever I feel like, without overthinking nutrition labels. I enjoy trying different cuisines and believe food should be enjoyed. I don’t follow strict rules but listen to my body’s cravings."
            )
        )

//        Persona Info Dialog
                selectedPersona?.let { persona ->
                    PersonaDialog(
                        showDialog = showDialog,
                        onDismiss = { showDialog = false },
                        imageRes = persona["image"]?.toIntOrNull() ?: 0,
                        title = persona["name"] ?: "",
                        description = persona["description"] ?: ""
                    )
                }


                Spacer(modifier = Modifier.height(20.dp))

        // dropdown for persona selection
        Text(
            text = "Which persona best fits you?",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        DropdownPersonaSelector(
            personas = personas.map { it["name"] ?: "" },
            selectedPersona = selectedPersonaName,
            onPersonaSelected = {
                selectedPersonaName = it
                val matchedPersona = personas.find { persona -> persona["name"] == it }
                if (matchedPersona != null) {
                    selectedPersona = matchedPersona
                    showDialog = true
                }
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

    // timings
        Text(text = "Timings", fontSize = 18.sp, fontWeight = FontWeight.Medium)

        val timeLabels = listOf(
            "What time do you normally eat your biggest meal?",
            "What time do you go to sleep at night?",
            "What time do you wake up in the morning?"
        )
    // create state variables for each time
        var biggestMealTime by remember {
            mutableStateOf(prefsHelper.getBiggestMealTime())
        }
        var sleepTime by remember {
            mutableStateOf(prefsHelper.getSleepTime())
        }

        var wakeUpTime by remember {
            mutableStateOf(prefsHelper.getWakeUpTime())
        }

        // create state variables for showing time pickers
        var showBiggestMealTimePicker by remember { mutableStateOf(false) }
        var showSleepTimePicker by remember { mutableStateOf(false) }
        var showWakeUpTimePicker by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            // load saved data when screen opens
            val savedFoods = prefsHelper.getFoodPreferences()
            selectedFoods.clear()
            selectedFoods.addAll(savedFoods)

            selectedPersonaName = prefsHelper.getPersona()

            biggestMealTime = prefsHelper.getBiggestMealTime()
            sleepTime = prefsHelper.getSleepTime()
            wakeUpTime = prefsHelper.getWakeUpTime()
        }

// time picker dialogs
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

// time selection rows
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(timeLabels[0], modifier = Modifier.weight(1f))
            Button(
                onClick = { showBiggestMealTimePicker = true },
                modifier = Modifier.width(120.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6EC9D5))
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
                modifier = Modifier.width(120.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6EC9D5))
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
                modifier = Modifier.width(120.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6EC9D5))
            ) {
                Text(wakeUpTime)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Save Button
        Button(
            onClick = {
                when {
                    selectedFoods.isEmpty() -> {
                        errorMessage = "Please select at least one food category"
                        showErrorDialog = true
                    }
                    selectedPersonaName.isEmpty() -> {
                        errorMessage = "Please select your persona"
                        showErrorDialog = true
                    }
                    !isTimeValid(biggestMealTime) ||
                            !isTimeValid(sleepTime) ||
                            !isTimeValid(wakeUpTime) -> {
                        errorMessage = "Please select a valid time"
                        showErrorDialog = true
                    }
                    // 1. Kiểm tra 3 thời điểm không trùng
                    biggestMealTime == sleepTime ||
                            biggestMealTime == wakeUpTime ||
                            sleepTime == wakeUpTime -> {
                        errorMessage = "Biggest meal, sleep and wake‐up times must all be different"
                        showErrorDialog = true
                    }
                    // 2. Giờ thức dậy phải trước giờ ăn chính
                    !isEarlier(wakeUpTime, biggestMealTime) -> {
                        errorMessage = "Wake‐up time must be earlier than your biggest meal time"
                        showErrorDialog = true
                    }
                    // 3. Giờ ngủ phải sau giờ ăn chính
                    !isEarlier(biggestMealTime, sleepTime) -> {
                        errorMessage = "Sleep time must be later than your biggest meal time"
                        showErrorDialog = true
                    }
                    // 4. Giờ thức dậy và giờ ngủ phải cách nhau ít nhất 4 giờ
                    !isGapAtLeastHours(wakeUpTime, sleepTime, 4) -> {
                        errorMessage = "There must be at least 4 hours between wake‐up and sleep times"
                        showErrorDialog = true
                    }
                    else -> {
                        // save data -> SharedPreferences
                        prefsHelper.saveFoodPreferences(selectedFoods)
                        prefsHelper.savePersona(selectedPersonaName)
                        prefsHelper.saveTimings(biggestMealTime, sleepTime, wakeUpTime)

                        // HomeActivity
                        val intent = Intent(context, HomeActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        context.startActivity(intent)
                }}
            }, modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6EC9D5))
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


    }
}
/** Trả về true nếu time1 < time2 */
fun isEarlier(time1: String, time2: String): Boolean {
    val (h1, m1) = time1.split(":").map { it.toInt() }
    val (h2, m2) = time2.split(":").map { it.toInt() }
    return h1 < h2 || (h1 == h2 && m1 < m2)
}

/** Trả về true nếu khoảng cách giữa time1 và time2 >= hours */
fun isGapAtLeastHours(time1: String, time2: String, hours: Int): Boolean {
    val (h1, m1) = time1.split(":").map { it.toInt() }
    val (h2, m2) = time2.split(":").map { it.toInt() }
    val minutes1 = h1 * 60 + m1
    val minutes2 = h2 * 60 + m2
    return kotlin.math.abs(minutes2 - minutes1) >= hours * 60
}

@Composable
fun ErrorDialog(show: Boolean, message: String, onDismiss: () -> Unit) {
    if (show) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Missing Information") },
            text = { Text(message) },
            confirmButton = {
                Button(onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6EC9D5))) {
                    Text("OK")
                }
            }
        )
    }
}

fun isTimeValid(time:String): Boolean {
    return try {
        val parts = time.split(":")
        val hour = parts[0].toInt()
        val minute = parts[1].toInt()
        hour in 0..23 && minute in 0..59 && time != "00:00"
    } catch (e: Exception) {
        false
    }
}

