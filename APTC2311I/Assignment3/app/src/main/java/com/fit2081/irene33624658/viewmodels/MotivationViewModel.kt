package com.fit2081.irene33624658.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fit2081.irene33624658.models.NutriCoachTip
import com.fit2081.irene33624658.repositories.GeminiRepository
import com.fit2081.irene33624658.repositories.PatientsRepository
import com.fit2081.irene33624658.services.LoggerService
import kotlinx.coroutines.flow.Flow
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
                val generatedMessage = geminiRepository.generateMotivationalMessage(userId)
                _message.value = generatedMessage
            } catch (e: Exception) {
                LoggerService.error("Failed to generate motivational message", throwable = e)
            } finally {
                _isLoading.value = false
            }
        }
    }
    // ✅ Hàm mới để lấy toàn bộ tips theo user
    fun getTipsForUser(userId: String): Flow<List<NutriCoachTip>> {
        return geminiRepository.getTipsForUser(userId)
    }

}