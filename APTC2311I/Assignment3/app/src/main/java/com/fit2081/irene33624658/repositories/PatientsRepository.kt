// PatientsRepository.kt
package com.fit2081.irene33624658.repositories

import android.content.Context
import androidx.core.content.edit
import com.fit2081.irene33624658.dao.HospitalDatabase
import com.fit2081.irene33624658.dao.PatientDao
import com.fit2081.irene33624658.models.Patient
import com.fit2081.irene33624658.utils.CsvProcessor
import com.fit2081.irene33624658.utils.SharedPreferencesHelper
import kotlinx.coroutines.flow.Flow

class PatientsRepository(private val context: Context) {
    private val patientDao: PatientDao
    private val prefsHelper = SharedPreferencesHelper(context)

    init {
        val db = HospitalDatabase.getDatabase(context)
        patientDao = db.patientDao()
    }

    /** Chỉ chạy 1 lần đầu: đọc CSV và lưu vào Room */
    suspend fun initializeIfFirstRun(context: Context) {
        if (prefsHelper.isFirstRun()) {
            // truyền đúng context và dao vào processor
            CsvProcessor.processPatientsCsv(context, patientDao)
            prefsHelper.setFirstRunCompleted()
        }
    }

    // ==== Patient CRUD ====
    suspend fun registerPatient(patient: Patient) = patientDao.insert(patient)
    suspend fun updatePatient(patient: Patient) = patientDao.update(patient)
    suspend fun deletePatient(patient: Patient) = patientDao.delete(patient)
    fun getAllPatients(): Flow<List<Patient>> = patientDao.getAllPatients()
    suspend fun getPatientById(userId: String): Patient? {
        return patientDao.getPatientById(userId) // phải là suspend fun từ Room DAO
    }
    suspend fun isUserIdAvailable(id: String): Boolean = getPatientById(id) == null

    // ==== Login State ====
    fun saveLoginState(userId: String) = prefsHelper.saveLoginState(userId)
    fun clearLoginState() = prefsHelper.clearLoginState()
    fun isUserLoggedIn(): Boolean = prefsHelper.isUserLoggedIn()
    fun getLoggedInUserId(): String? = prefsHelper.getLoggedInUserId()

    /** Hàm bổ sung: kiểm tra xem userId đã có trong DB hay chưa */
    suspend fun checkPatientExists(userId: String): Boolean {
        return patientDao.getPatientById(userId) != null
    }
}
