// ClinicianViewModel.kt
package com.fit2081.irene33624658.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.fit2081.irene33624658.models.Patient
import com.fit2081.irene33624658.repositories.GeminiRepository
import com.fit2081.irene33624658.repositories.PatientsRepository
import com.fit2081.irene33624658.utils.SharedPreferencesHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ClinicianViewModel(
    application: Application
) : AndroidViewModel(application) {
    private val repository = PatientsRepository(application)
    private val prefs = SharedPreferencesHelper(application)
    private val geminiRepository = GeminiRepository(application)
    private val validClinicianKey = "dollar-entry-apples"

    // UI states
    private val _isAuthenticated = MutableStateFlow(false)
    val isAuthenticated: StateFlow<Boolean> = _isAuthenticated

    private val _patientData = MutableStateFlow<Patient?>(null)
    val patientData: StateFlow<Patient?> = _patientData

    private val _dataPatterns = MutableStateFlow<List<String>>(emptyList())
    val dataPatterns: StateFlow<List<String>> = _dataPatterns

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _avgHeifaMale = MutableStateFlow(0.0)
    val avgHeifaMale: StateFlow<Double> = _avgHeifaMale

    private val _avgHeifaFemale = MutableStateFlow(0.0)
    val avgHeifaFemale: StateFlow<Double> = _avgHeifaFemale

    fun loadAverageHeifaScores() {
        viewModelScope.launch {
            _avgHeifaMale.value = repository.getAverageHeifaMale()
            _avgHeifaFemale.value = repository.getAverageHeifaFemale()
        }
    }


    fun authenticateClinician(key: String): Boolean {
        val isValid = key == validClinicianKey
        _isAuthenticated.value = isValid
        if (isValid) {
            loadPatientData()
            loadAverageHeifaScores()
        }
        return isValid
    }

    private fun loadPatientData() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // Get logged in user ID from prefs
                val userId = prefs.getLoggedInUserId()
                if (userId != null) {
                    _patientData.value = repository.getPatientById(userId)
                }
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun findDataPatterns() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val patient = _patientData.value ?: return@launch

                // Prepare prompt for Gemini using the specific patient's data
                val prompt = """
                    Please analyze this patient's nutrition scores and return exactly 3 insights as bullet points.
                    
                    Each bullet should have a short bolded **title**, followed by a colon and a clear explanation.
                    
                    Use the following format:
                    Title 1: Description...
                    Title 2: Description...
                    Title 3: Description...
                    
                    Here is the patient data:
                    - HEIFA Score: ${patient.heifaTotalScore}
                    - Vegetables: ${patient.vegetablesHeifaScoreMale}
                    - Fruits: ${patient.fruitHeifaScoreMale}
                    - Grains: ${patient.grainsAndCerealsHeifaScoreMale}
                    - Protein: ${patient.meatAndAlternativesHeifaScoreMale}
                    - Dairy: ${patient.dairyAndAlternativesHeifaScoreMale}
                    
                    Only include 3 insights. Do not use markdown bullet points or numbered lists.
                    """.trimIndent()


                // Call Gemini API
                val response = withContext(Dispatchers.IO) {
                    geminiRepository.generateAnalysis(prompt)
                }

                // Parse response into 3 points
                _dataPatterns.value = response.split("\n")
                    .filter { it.contains(":") }
                    .map {
                        val parts = it.split(":", limit = 2)
                        val title = parts[0].removePrefix("**").removeSuffix("**").trim()
                        val description = parts.getOrElse(1) { "" }.trim()
                        "$title: $description"
                    }

                print("test")

            } finally {
                _isLoading.value = false
            }
        }
    }
}