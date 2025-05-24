package com.fit2081.irene33624658.viewmodels

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.fit2081.irene33624658.models.Patient
import com.fit2081.irene33624658.repositories.PatientsRepository
import androidx.lifecycle.viewModelScope
import com.fit2081.irene33624658.models.Fruit
import com.fit2081.irene33624658.repositories.FruitRepository
import com.fit2081.irene33624658.services.LoggerService
import com.fit2081.irene33624658.services.ToastService
import com.fit2081.irene33624658.utils.SharedPreferencesHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private lateinit var repository: PatientsRepository

    private val _user = MutableStateFlow<Patient?>(null)
    val user: StateFlow<Patient?> = _user

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun initRepository(context: Context) {
        repository = PatientsRepository(context)
    }

    fun loadUser(context: Context) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val prefsHelper = SharedPreferencesHelper(context)
                val userId = prefsHelper.getLoggedInUserId() ?: ""

                if (userId.isNotEmpty()) {
                    val patient = repository.getPatientById(userId)
                    _user.value = patient
                } else {
                    LoggerService.error("User ID is empty", tag = "HomeViewModel")
                }
            } catch (e: Exception) {
                LoggerService.error("Error loading user", throwable = e)
            } finally {
                _isLoading.value = false // ✅ Đảm bảo luôn tắt loading
            }
        }
    }
}
