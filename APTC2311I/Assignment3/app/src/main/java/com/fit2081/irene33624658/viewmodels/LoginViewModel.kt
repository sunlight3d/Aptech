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
            repository
                .getAllPatients()
                .collect { listOfPatients ->
                    _patientIds.value = listOfPatients
                        .map { it.userId }
                        .sortedBy { it.toIntOrNull() ?: Int.MAX_VALUE } // sắp xếp theo số
                }
        }
    }

    fun saveLoginState(userId: String) {
        viewModelScope.launch {
            repository.saveLoginState(userId)
        }
    }
    /*
    //Not necessary, we authenticate using Google Auth
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

     */
    suspend fun getPhoneNumberByUserId(userId: String): String? {
        val patient = repository.getPatientById(userId)
        return patient?.phoneNumber
    }


    fun isUserLoggedIn(context: Context): Boolean {
        return repository.isUserLoggedIn()
    }
}