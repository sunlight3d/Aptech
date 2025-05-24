// ClinicianDashboard.kt
package com.fit2081.irene33624658.views.clinician

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fit2081.irene33624658.services.LoggerService
import com.fit2081.irene33624658.services.ToastService
import com.fit2081.irene33624658.viewmodels.ClinicianViewModel

@Composable
fun ClinicianDashboard(
    viewModel: ClinicianViewModel = viewModel(),
    onLogout: () -> Unit
) {
    val patientData by viewModel.patientData.collectAsState()
    val dataPatterns by viewModel.dataPatterns.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val avgMale by viewModel.avgHeifaMale.collectAsState()
    val avgFemale by viewModel.avgHeifaFemale.collectAsState()


    LaunchedEffect(Unit) {
        LoggerService.debug("ClinicianDashboard screen launched")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Clinician Dashboard", style = MaterialTheme.typography.headlineMedium)
            Button(
                onClick = {
                    LoggerService.debug("Clinician logging out")
                    ToastService.showShort("Logging out...")
                    onLogout()
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                )
            ) {
                Text("Logout")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        // Stats Card
        patientData?.let { patient ->
            LoggerService.debug("Displaying patient data: ${patient.userId}")
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Average HEIFA (Male): ${"%.1f".format(avgMale)}", style = MaterialTheme.typography.bodyMedium)
                    Text("Average HEIFA (Female): ${"%.1f".format(avgFemale)}", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }?: run {
            LoggerService.warning("No patient data available")
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { viewModel.findDataPatterns() },
            enabled = !isLoading && patientData != null,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ),
        ) {
            Text("Find Data Patterns")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else if (dataPatterns.isNotEmpty()) {
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    dataPatterns.forEach { pattern ->
                        val parts = pattern.split(":", limit = 2)
                        val title = parts.getOrNull(0)?.trim() ?: ""
                        val body = parts.getOrNull(1)?.trim() ?: ""

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                // Title in bold
                                Text(
                                    text = title,
                                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                                )
                                if (body.isNotBlank()) {
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = body,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))

                    // ✅ DONE button
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        Button(
                            onClick = {
                                ToastService.show("Welcome to NutriApp")
                            },
                            modifier = Modifier.width(140.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = Color.White
                            )
                        ) {
                            Text("Done")
                        }
                    }
                }
            }
        }
    }
}