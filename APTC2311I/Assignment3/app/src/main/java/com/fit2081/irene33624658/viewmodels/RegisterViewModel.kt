package com.fit2081.irene33624658.viewmodels

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fit2081.irene33624658.models.Patient
import com.fit2081.irene33624658.repositories.PatientsRepository
import com.fit2081.irene33624658.utils.isValidPassword
import com.fit2081.irene33624658.utils.isValidPhoneNumber
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    private lateinit var repository: PatientsRepository

    // State để theo dõi validation
    val validationState = mutableStateOf(ValidationState())

    data class ValidationState(
        val userIdError: String? = null,
        val phoneError: String? = null,
        val passwordError: String? = null,
        val confirmPasswordError: String? = null
    )

    fun initRepository(context: Context) {
        repository = PatientsRepository(context)
    }

    fun validateUserId(userId: String, onResult: (Boolean) -> Unit) {
        if (userId.isBlank()) {
            validationState.value = validationState.value.copy(
                userIdError = "User ID cannot be empty"
            )
            onResult(false)
            return
        }
        viewModelScope.launch {
            val exists = repository.checkPatientExists(userId)
            if (!exists) {
                validationState.value = validationState.value.copy(
                    userIdError = "User ID not found in system"
                )
            }
            onResult(exists)
        }
    }


    fun validatePassword(password: String, confirmPassword: String): Boolean {
        val passwordValid = when {
            !password.isValidPassword() -> {
                validationState.value = validationState.value.copy(
                    passwordError = "Password must be 6+ characters with letters and numbers"
                )
                false
            }
            else -> true
        }

        val confirmValid = password == confirmPassword
        if (!confirmValid) {
            validationState.value = validationState.value.copy(
                confirmPasswordError = "Passwords do not match"
            )
        }

        return passwordValid && confirmValid
    }

    fun validatePhone(phone: String): Boolean {
        return if (!phone.isValidPhoneNumber()) {
            validationState.value = validationState.value.copy(
                phoneError = "Invalid phone number format (10-15 digits)"
            )
            false
        } else {
            true
        }
    }
    fun register(
        userId: String,
        phoneNumber: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                // Lúc này userId đã được valid trước rồi
                val patient = repository.getPatientById(userId)
                if (patient == null) {
                    onFailure("User not found")
                    return@launch
                }
                // Verify phone
                if (patient.phoneNumber != phoneNumber) {
                    validationState.value = validationState.value.copy(
                        phoneError = "Phone number does not match"
                    )
                    onFailure("Phone mismatch")
                    return@launch
                }
                // Update password
                repository.updatePatient(patient.copy(password = password))
                repository.saveLoginState(userId)
                onSuccess()
            } catch (e: Exception) {
                onFailure("Registration failed: ${e.message}")
            }
        }
    }
}