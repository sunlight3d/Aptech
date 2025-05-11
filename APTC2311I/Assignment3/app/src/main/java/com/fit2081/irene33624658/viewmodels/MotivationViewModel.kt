package com.fit2081.irene33624658.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fit2081.irene33624658.models.MotivationalMessage
import com.fit2081.irene33624658.repositories.GeminiRepository
import com.fit2081.irene33624658.repositories.PatientsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MotivationViewModel(
    private val geminiRepository: GeminiRepository,
    private val patientsRepository: PatientsRepository
) : ViewModel() {
    private val _message = MutableStateFlow("")
    val message: StateFlow<String> = _message

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun generateMotivationalMessage() {
        val userId = patientsRepository.getLoggedInUserId() ?: return

        viewModelScope.launch {
            _isLoading.value = true
            try {
                _message.value = geminiRepository.generateMotivationalMessage(userId)
            } finally {
                _isLoading.value = false
            }
        }
    }
}