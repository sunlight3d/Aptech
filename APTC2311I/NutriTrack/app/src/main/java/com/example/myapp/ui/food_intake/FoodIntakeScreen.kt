package com.example.myapp.ui.food_intake
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapp.R
import com.example.myapp.ui.widgets.CustomAlertDialog
import com.example.myapp.ui.widgets.PersonaDialog
import com.example.myapp.utils.alert

@Composable
fun FoodIntakeScreen(navController: NavController) {
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Back",
                    tint = Color(0xFF6200EE),
                    modifier = Modifier.size(24.dp))
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

        // Timings
        Text(text = "Timings", fontSize = 18.sp, fontWeight = FontWeight.Medium)

        val timeLabels = listOf(
            "What time do you normally eat your biggest meal?",
            "What time do you go to sleep at night?",
            "What time do you wake up in the morning?"
        )

        timeLabels.forEach { label ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(label, modifier = Modifier.weight(1f))
                OutlinedTextField(
                    value = "00:00",
                    onValueChange = {},
                    modifier = Modifier.width(120.dp),
                    leadingIcon = {
                        Icon(Icons.Default.Notifications, contentDescription = "Time Picker")
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Save Button
        Button(
            onClick = { navController.navigate("home") },
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
    }
}