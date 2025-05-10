// WelcomeViewModel.kt
package com.fit2081.irene33624658.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fit2081.irene33624658.repositories.PatientsRepository
import kotlinx.coroutines.launch

class WelcomeViewModel : ViewModel() {
    private var repository: PatientsRepository? = null

    /** Khởi tạo repository với context từ Activity/Composable */
    fun initRepository(context: Context) {
        repository = PatientsRepository(context)
    }

    /** Gọi hàm init dữ liệu, dùng viewModelScope để launch coroutine */
    fun initializeAppData(context: Context) {
        viewModelScope.launch {
            repository?.initializeIfFirstRun(context)
        }
    }

    /** Có thể expose thêm các hàm login/logout nếu cần */
    fun isUserLoggedIn(): Boolean = repository?.isUserLoggedIn() ?: false
    fun saveLoginState(userId: String) = repository?.saveLoginState(userId)
    fun clearLoginState() = repository?.clearLoginState()
}
