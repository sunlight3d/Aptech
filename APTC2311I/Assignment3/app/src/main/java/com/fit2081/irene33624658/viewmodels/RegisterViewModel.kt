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
        val confirmPasswordError: String? = null,
        val nameError: String? = null
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
        name: String,
        phoneNumber: String,
        password: String,
        confirmPassword: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        // Reset lỗi
        validationState.value = ValidationState()

        viewModelScope.launch {
            try {
                // Validate User ID
                if (userId.isBlank()) {
                    validationState.value = validationState.value.copy(
                        userIdError = "User ID cannot be empty"
                    )
                    onFailure("Please enter a valid User ID")
                    return@launch
                }

                val exists = repository.checkPatientExists(userId)
                if (!exists) {
                    validationState.value = validationState.value.copy(
                        userIdError = "User ID not found in system"
                    )
                    onFailure("User ID not found")
                    return@launch
                }

                // Validate name
                if (name.isBlank()) {
                    validationState.value = validationState.value.copy(
                        nameError = "Name cannot be empty"
                    )
                    onFailure("Please enter your name")
                    return@launch
                }

                // Validate phone
                if (!validatePhone(phoneNumber)) {
                    onFailure("Invalid phone number")
                    return@launch
                }

                // Validate password + confirm password
                val passwordValid = validatePassword(password, confirmPassword)
                if (!passwordValid) {
                    onFailure("Password validation failed")
                    return@launch
                }

                // Lấy thông tin bệnh nhân từ hệ thống
                val patient = repository.getPatientById(userId)
                if (patient == null) {
                    onFailure("User not found in repository")
                    return@launch
                }

                // Kiểm tra số điện thoại có trùng
                if (patient.phoneNumber != phoneNumber) {
                    validationState.value = validationState.value.copy(
                        phoneError = "Phone number does not match our record"
                    )
                    onFailure("Phone mismatch")
                    return@launch
                }

                // Cập nhật mật khẩu và tên
                val updatedPatient = patient.copy(
                    password = password,
                    name = name
                )
                repository.updatePatient(updatedPatient)
                repository.saveLoginState(userId)
                onSuccess()
            } catch (e: Exception) {
                onFailure("Registration failed: ${e.message}")
            }
        }
    }
}