package com.fit2081.irene33624658.views.home.tab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fit2081.irene33624658.dao.HospitalDatabase
import com.fit2081.irene33624658.repositories.GeminiRepository
import com.fit2081.irene33624658.repositories.PatientsRepository
import com.fit2081.irene33624658.viewmodels.FruitViewModel
import com.fit2081.irene33624658.viewmodels.MotivationViewModel
import com.fit2081.irene33624658.services.LoggerService
import com.fit2081.irene33624658.services.ToastService
import kotlinx.coroutines.launch


@Composable
fun NutriCoachTab(
    viewModel: FruitViewModel = viewModel(),
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        LoggerService.debug("NutriCoachTab launched", tag = "NutriCoach")
        ToastService.showShort("Welcome to NutriCoach!")
    }
    val motivationViewModel = remember {
        val db = HospitalDatabase.getDatabase(context)
        val geminiRepo = GeminiRepository(context)
        val patientsRepo = PatientsRepository(context)
        MotivationViewModel(geminiRepo, patientsRepo)
    }
    val names by viewModel.filteredNames.collectAsState()
    val detail by viewModel.detail.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val motivationMessage by motivationViewModel.message.collectAsState()
    val isMotivationLoading by motivationViewModel.isLoading.collectAsState()

    var text by remember { mutableStateOf("") }
    var showMessageDialog by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("NutriCoach", style = MaterialTheme.typography.headlineSmall)

        Spacer(Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TextField(
                value = text,
                onValueChange = {
                    text = it
                    viewModel.filterBy(it)
                },
                label = { Text("Fruit Name") },
                modifier = Modifier.weight(1f),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )

            val coroutineScope = rememberCoroutineScope()

            Button(
                onClick = {
                    coroutineScope.launch {
                        try {
                            LoggerService.debug("Fetching fruit detail for: $text", tag = "NutriCoach")
                            viewModel.fetchDetail(text)
                        } catch (e: Exception) {
                            LoggerService.error("Error fetching detail", throwable = e, tag = "NutriCoach")
                            ToastService.showError("Failed to fetch details. Please try again.")
                        }
                    }
                },
                enabled = text.isNotBlank() && !isLoading,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C00FF))
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        color = Color.White
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
                Spacer(Modifier.width(4.dp))
                Text("Details")
            }
        }

        Spacer(Modifier.height(16.dp))

        // Detail card
        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            detail?.let { f ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        listOf(
                            "family" to f.family,
                            "calories" to f.nutritions.calories.toString(),
                            "fat" to f.nutritions.fat.toString(),
                            "sugar" to f.nutritions.sugar.toString(),
                            "carbohydrates" to f.nutritions.carbohydrates.toString(),
                            "protein" to f.nutritions.protein.toString()
                        ).forEach { (label, value) ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(label, fontSize = 14.sp)
                                Text(value, fontSize = 14.sp)
                            }
                            HorizontalDivider()
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                LoggerService.info("Generating motivational message", tag = "NutriCoach")
                motivationViewModel.generateMotivationalMessage()
                showMessageDialog = true
            },

            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C00FF)),
            shape = RoundedCornerShape(8.dp),
            enabled = !isMotivationLoading
        ) {
            if (isMotivationLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    color = Color.White
                )
            } else {
                Icon(Icons.Default.Favorite, contentDescription = null)
                Spacer(Modifier.width(4.dp))
                Text("Motivational Message (AI)")
            }
        }

        if (showMessageDialog) {
            AlertDialog(
                onDismissRequest = { showMessageDialog = false },
                title = { Text("Your Motivational Message") },
                text = { Text(motivationMessage) },
                confirmButton = {
                    Button(
                        onClick = { showMessageDialog = false },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C00FF))
                    ) {
                        Text("OK")
                    }
                }
            )
        }
    }
}
