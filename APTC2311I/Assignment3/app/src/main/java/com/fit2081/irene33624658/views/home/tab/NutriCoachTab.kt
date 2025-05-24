package com.fit2081.irene33624658.views.home.tab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.fit2081.irene33624658.utils.SharedPreferencesHelper
import kotlinx.coroutines.flow.collectLatest
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
    var showMotivationalText by remember { mutableStateOf(false) }

    var showTipsDialog by remember { mutableStateOf(false) }
    var tipsText by remember { mutableStateOf("") }


    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text("NutriCoach", style = MaterialTheme.typography.headlineSmall)
            }

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
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = Color.White
                    ),
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
                    if (detail?.family != null &&
                        detail?.nutritions?.calories != null &&
                        detail?.nutritions?.fat != null &&
                        detail?.nutritions?.sugar != null &&
                        detail?.nutritions?.carbohydrates != null &&
                        detail?.nutritions?.protein != null
                    ) {
                        LoggerService.info("Generating motivational message", tag = "NutriCoach")
                        motivationViewModel.generateMotivationalMessage()
                        showMotivationalText = true
                    } else {
                        LoggerService.warning("Detail info is incomplete or missing", tag = "NutriCoach")
                        ToastService.showError("Please fetch fruit details first before generating a message.")
                    }
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                enabled = !isMotivationLoading
            ) {
                if (isMotivationLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        color = Color.White
                    )
                } else {
                    Text("\u2661", fontSize = 28.sp, color = Color.White)
                    Spacer(Modifier.width(4.dp))
                    Text("Motivational Message (AI)")
                }
            }

            if (showMotivationalText && motivationMessage.isNotBlank()) {
                Spacer(Modifier.height(12.dp))
                Text(
                    text = motivationMessage,
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        val coroutineScope = rememberCoroutineScope() // ✅ Di chuyển ra ngoài FloatingActionButton

        FloatingActionButton(
            onClick = {
                val userId = SharedPreferencesHelper(context).getLoggedInUserId()
                if (userId != null) {
                    val tipsFlow = motivationViewModel.getTipsForUser(userId)

                    coroutineScope.launch {
                        tipsFlow.collectLatest { tips ->
                            if (tips.isNotEmpty()) {
                                tipsText = tips.joinToString("\n\n") { "• ${it.message}" }
                                showTipsDialog = true
                            } else {
                                ToastService.showShort("No tips found.")
                            }
                        }
                    }
                } else {
                    ToastService.showError("User not logged in")
                }
            },
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(10.dp)
        ) {
            Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                Text("Show All Tips")
            }
        }
        if (showTipsDialog) {
            AlertDialog(
                onDismissRequest = { showTipsDialog = false },
                title = { Text("All Motivational Tips") },
                text = {
                    Column(
                        modifier = Modifier
                            .heightIn(min = 100.dp, max = 400.dp)
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            text = tipsText,
                            fontSize = 14.sp,
                            lineHeight = 20.sp
                        )
                    }
                },
                confirmButton = {
                    Button(
                        onClick = { showTipsDialog = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        Text("OK")
                    }
                }
            )
        }



    }
}

