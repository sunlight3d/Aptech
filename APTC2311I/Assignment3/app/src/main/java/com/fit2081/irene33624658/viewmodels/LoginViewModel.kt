package com.fit2081.irene33624658.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fit2081.irene33624658.repositories.PatientsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private lateinit var repository: PatientsRepository
    private val _patientIds = MutableStateFlow<List<String>>(emptyList())
    val patientIds: StateFlow<List<String>> = _patientIds

    fun initRepository(context: Context) {
        repository = PatientsRepository(context)
        viewModelScope.launch {
            // collect flow Patients rồi map sang userId
            repository
                .getAllPatients()
                .collect { listOfPatients ->
                    _patientIds.value = listOfPatients.map { it.userId }
                }
        }
    }

    fun login(userId: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        viewModelScope.launch {
            val patient = repository.getPatientById(userId)
            if (patient != null && patient.password == password) {
                repository.saveLoginState(userId)
                onSuccess()
            } else {
                onFailure("Invalid user ID or password")
            }
        }
    }

    fun isUserLoggedIn(context: Context): Boolean {
        return repository.isUserLoggedIn()
    }
}