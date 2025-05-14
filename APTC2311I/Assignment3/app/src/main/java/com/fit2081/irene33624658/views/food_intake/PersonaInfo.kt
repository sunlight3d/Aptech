package com.fit2081.irene33624658.views.food_intake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.fit2081.irene33624658.views.food_intake.ui.theme.Assignment1Theme

class PersonaInfo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // same list of personas
                    val personaOptions = listOf("Option 1", "Option 2", "Option 3")

                    // currently selected persona state
                    var selectedPersona by remember { mutableStateOf(personaOptions[0]) }

                    // display the dropdown menu selector
                    DropdownPersonaSelector( personas = personaOptions,
                        selectedPersona = selectedPersona,
                        onPersonaSelected = { newPersona ->
                            selectedPersona = newPersona // update selection
                        })
                }
            }

        }
    }
}

@Composable
fun DropdownPersonaSelector (
    personas: List<String>, // list of persona options
    selectedPersona: String, // currently selected option
    onPersonaSelected: (String) -> Unit // callback when a new option is selected
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = selectedPersona,
            onValueChange = {},
            label = { Text("Select Option") },
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Dropdown")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true } // tapping the field opens the dropdown
        )

        // dropdown with persona options
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            personas.forEach { persona ->
                DropdownMenuItem(
                    text = { Text(persona) },
                    onClick = {
                        onPersonaSelected(persona) // pass selected value to parent
                        expanded = false // close dropdown
                    }
                )
            }
        }
    }
}


