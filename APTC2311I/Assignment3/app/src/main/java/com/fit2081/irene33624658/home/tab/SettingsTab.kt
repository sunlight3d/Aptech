// SettingsTab.kt
package com.fit2081.irene33624658.home

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ExitToApp
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
import com.fit2081.irene33624658.LoginActivity

@Composable
fun SettingsTab(
    context: Context = LocalContext.current,
    navController: NavController,
    vm: SettingsViewModel = viewModel()
) {
    val patient by vm.patient.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Settings", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(24.dp))
        Text("ACCOUNT", style = MaterialTheme.typography.labelSmall)

        patient?.let { p ->
            Spacer(modifier = Modifier.height(12.dp))
            // Name
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Person, contentDescription = null)
                Spacer(Modifier.width(16.dp))
                Text("Irene Nguyen", fontSize = 16.sp)
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
                    vm.logout {
                        // Dùng Intent để chuyển về Login Activity
                        val intent = Intent(context, LoginActivity::class.java).apply {
                            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK  // Xóa hết back stack
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
                    navController.navigate("clinician_login")
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
