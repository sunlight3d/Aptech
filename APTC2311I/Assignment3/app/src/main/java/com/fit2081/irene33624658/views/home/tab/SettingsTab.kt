// SettingsTab.kt
package com.fit2081.irene33624658.home

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fit2081.irene33624658.viewmodels.SettingsViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.fit2081.irene33624658.viewmodels.ClinicianViewModel
import com.fit2081.irene33624658.views.LoginActivity
import com.fit2081.irene33624658.views.clinician.ClinicianDashboard
import com.fit2081.irene33624658.views.clinician.ClinicianLogin
import com.fit2081.irene33624658.services.LoggerService
import com.fit2081.irene33624658.services.ToastService
import com.fit2081.irene33624658.views.WelcomeActivity


@Composable
fun SettingsTab(
    context: Context = LocalContext.current,
    navController: NavController,
    settingsViewModel: SettingsViewModel = viewModel(),
    clinicianViewModel: ClinicianViewModel = viewModel()
) {
    val patient by settingsViewModel.patient.collectAsState()
    var showClinicianLogin by remember { mutableStateOf(false) }
    var showClinicianDashboard by remember { mutableStateOf(false) }

    if (showClinicianDashboard) {
        ClinicianDashboard(
            viewModel = clinicianViewModel,
            onLogout = {
                showClinicianDashboard = false
                showClinicianLogin = false
            }
        )
    } else if (showClinicianLogin) {
        ClinicianLogin(
            onAuthenticated = { showClinicianDashboard = true },
            viewModel = clinicianViewModel
        )
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Settings",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))
            Text("ACCOUNT", style = MaterialTheme.typography.labelSmall)

            patient?.let { p ->
                Spacer(modifier = Modifier.height(12.dp))
                // Name
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Person, contentDescription = null)
                    Spacer(Modifier.width(16.dp))
                    Text(patient!!.name, fontSize = 16.sp)
                }
                Spacer(Modifier.height(8.dp))
                // Phone
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Call, contentDescription = null)
                    Spacer(Modifier.width(16.dp))
                    Text(p.phoneNumber, fontSize = 16.sp)
                }
                Spacer(Modifier.height(8.dp))
                // ID
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.AccountBox, contentDescription = "ID", tint = MaterialTheme.colorScheme.primary)
                    Spacer(Modifier.width(16.dp))
                    Text(p.userId, fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(24.dp))
            Text("OTHER SETTINGS", style = MaterialTheme.typography.labelSmall)

            // Logout
            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        settingsViewModel.logout {
                            LoggerService.info("User logged out", tag = "SettingsTab")
                            ToastService.showSuccess("Logged out successfully")
                            val intent = Intent(context, WelcomeActivity::class.java).apply {
                                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            }
                            context.startActivity(intent)
                        }
                    }
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = null)
                Spacer(Modifier.width(16.dp))
                Text("Logout", modifier = Modifier.weight(1f))
                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
            }

            // Clinician Login (nếu có)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        showClinicianLogin = true // This will trigger the ClinicianLogin composable
                    }
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Person, contentDescription = null)
                Spacer(Modifier.width(16.dp))
                Text("Clinician Login", modifier = Modifier.weight(1f))
                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
            }
        }
    }


}
