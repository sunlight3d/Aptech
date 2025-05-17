// ClinicianLogin.kt
package com.fit2081.irene33624658.views.clinician

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fit2081.irene33624658.viewmodels.ClinicianViewModel

@Composable
fun ClinicianLogin(
    onAuthenticated: () -> Unit,
    viewModel: ClinicianViewModel = viewModel()
) {
    var clinicianKey by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Clinician Login", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = clinicianKey,
            onValueChange = { clinicianKey = it },
            label = { Text("Clinician Key") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                viewModel.authenticateClinician(clinicianKey)
                onAuthenticated()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}