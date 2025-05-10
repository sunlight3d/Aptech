package com.fit2081.week5_db

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.ViewModelProvider
import androidx.compose.ui.graphics.Color
import com.fit2081.week5_db.data.PatientViewModel
import com.fit2081.week5_db.ui.theme.Week5_dbTheme
import com.fit2081.week5_db.data.Patient


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week5_dbTheme {
                val viewModel: PatientViewModel = ViewModelProvider(
                    this, PatientViewModel.PatientViewModelFactory(this@MainActivity)
                )[PatientViewModel::class.java]

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AddPatientScreen(innerPadding, viewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPatientScreen(paddingValues: PaddingValues, viewModel: PatientViewModel) {
    var patientName by remember { mutableStateOf(TextFieldValue("")) }
    var patientAge by remember { mutableStateOf(TextFieldValue("")) }
    var patientAddress by remember { mutableStateOf(TextFieldValue("")) }
    val numberOfPatients by viewModel.allPatients.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Hospital Management",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )


        OutlinedTextField(
            value = patientName,
            onValueChange = { patientName = it },
            label = { Text("Patient Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = patientAge,
            onValueChange = { patientAge = it },
            label = { Text("Patient Age") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = patientAddress,
            onValueChange = { patientAddress = it },
            label = { Text("Patient Address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Button(onClick = {

                viewModel.insert(
                    Patient(
                        name = patientName.text,
                        age = patientAge.text.toInt(),
                        address = patientAddress.text
                    )
                )
            }) {
                Text("Add Patient")
            }


            Button(
                onClick = { viewModel.deleteAllPatients() }, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                )
            ) { Text(text = "Delete All Patients") }
        }
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(thickness = 4.dp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Number of Patients (${numberOfPatients.size})",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}
