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
                    Text("Patient ID: ${patient.userId}", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("HEIFA Score: ${"%.1f".format(patient.heifaTotalScore)}",
                        style = MaterialTheme.typography.bodyLarge)
                    // Add more patient details as needed
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
            Text("Analyze Nutrition Patterns")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else if (dataPatterns.isNotEmpty()) {
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Nutrition Insights:", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    dataPatterns.forEach { pattern ->
                        Text("• $pattern")
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        }
    }
}