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

    fun authenticateClinician(key: String) {
        _isAuthenticated.value = key == validClinicianKey
        if (_isAuthenticated.value) {
            loadPatientData()
        }
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
                    Analyze this patient's nutrition scores and identify 3 significant data patterns:
                    Patient ${patient.userId}:
                    - HEIFA Score: ${patient.heifaTotalScore}
                    - Vegetables: ${patient.vegetablesHeifaScoreMale}
                    - Fruits: ${patient.fruitHeifaScoreMale}
                    - Grains: ${patient.grainsAndCerealsHeifaScoreMale}
                    - Protein: ${patient.meatAndAlternativesHeifaScoreMale}
                    - Dairy: ${patient.dairyAndAlternativesHeifaScoreMale}
                    
                    Provide the response as 3 bullet points with clear insights and recommendations.
                """.trimIndent()

                // Call Gemini API
                val response = withContext(Dispatchers.IO) {
                    geminiRepository.generateAnalysis(prompt)
                }

                // Parse response into 3 points
                _dataPatterns.value = response.split("\n")
                    .take(3)
                    .map { it.replace("- ", "").trim() }
            } finally {
                _isLoading.value = false
            }
        }
    }
}