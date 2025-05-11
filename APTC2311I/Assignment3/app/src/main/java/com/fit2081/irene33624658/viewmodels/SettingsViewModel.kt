// SettingsViewModel.kt
package com.fit2081.irene33624658.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.fit2081.irene33624658.models.Patient
import com.fit2081.irene33624658.repositories.PatientsRepository
import com.fit2081.irene33624658.utils.SharedPreferencesHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = PatientsRepository(app)
    private val prefs = SharedPreferencesHelper(app)

    // StateFlow chứa Patient hiện tại (có thể null nếu chưa load)
    private val _patient = MutableStateFlow<Patient?>(null)
    val patient: StateFlow<Patient?> = _patient

    init {
        // load ngay khi khởi tạo
        viewModelScope.launch {
            // đọc userId từ prefs
            val userId = prefs.getLoggedInUserId()
            if (userId != null) {
                // lấy từ Room
                _patient.value = repo.getPatientById(userId)
            }
        }
    }

    /** Gọi khi user bấm Logout */
    fun logout(onLoggedOut: () -> Unit) {
        // xóa login state
        repo.clearLoginState()
        onLoggedOut()
    }
}
