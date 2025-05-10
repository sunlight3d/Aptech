package com.fit2081.irene33624658.repositories

import android.content.Context
import com.fit2081.irene33624658.dao.FoodIntakeDao

import com.fit2081.irene33624658.utils.CsvProcessor

import com.fit2081.irene33624658.dao.HospitalDatabase
import com.fit2081.irene33624658.dao.PatientDao
import com.fit2081.irene33624658.models.FoodIntake
import com.fit2081.irene33624658.models.Patient
import com.fit2081.irene33624658.utils.SharedPreferencesHelper
import kotlinx.coroutines.flow.Flow
import androidx.core.content.edit


class PatientsRepository {
    // Property to hold the PatientDao instance
    var patientDao: PatientDao
    // Property to hold the FoodIntakeDao instance
    var foodIntakeDao: FoodIntakeDao
    // Property for SharedPreferences
    val sharedPrefHelper: SharedPreferencesHelper

    // Constructor to initialize the DAOs and SharedPreferencesHelper
    constructor(context: Context) {
        val database = HospitalDatabase.getDatabase(context)
        patientDao = database.patientDao()
        foodIntakeDao = database.foodIntakeDao()
        sharedPrefHelper = SharedPreferencesHelper(context)
    }

    // Patient operations
    suspend fun insert(patient: Patient) {
        patientDao.insert(patient)
    }

    suspend fun getAllPatientIds(): List<String> {
        return patientDao.getAllPatientIds()
    }

    suspend fun delete(patient: Patient) {
        patientDao.delete(patient)
    }

    suspend fun update(patient: Patient) {
        patientDao.update(patient)
    }

    suspend fun deleteAllPatients() {
        patientDao.deleteAllPatients()
    }

    fun getAllPatients(): Flow<List<Patient>> = patientDao.getAllPatients()

    suspend fun getPatientById(userId: String): Patient? {
        return patientDao.getPatientById(userId)
    }

    // FoodIntake operations
    suspend fun insertFoodIntake(foodIntake: FoodIntake) {
        foodIntakeDao.insert(foodIntake)
    }

    fun getFoodIntakesForPatient(patientId: String): Flow<List<FoodIntake>> {
        return foodIntakeDao.getFoodIntakesForPatient(patientId)
    }

    // Option 2: If you need both deletion methods
    suspend fun deleteFoodIntake(id: Int) {
        // First get the entity by ID, then delete it
        foodIntakeDao.getFoodIntakeById(id)?.let { foodIntake ->
            foodIntakeDao.delete(foodIntake)
        }
    }


    suspend fun initializeIfFirstRun(context: Context) {
        val isFirstRun = sharedPrefHelper.getSharedPreferences().getBoolean("is_first_run", true)
        if (isFirstRun) {
            CsvProcessor.processPatientsCsv(context, patientDao)
            sharedPrefHelper.getSharedPreferences().edit {
                putBoolean("is_first_run", false)
            }
        }
    }

    //Login
    // Thêm vào class PatientsRepository
    fun saveLoginState(userId: String) {
        sharedPrefHelper.getSharedPreferences().edit {
            putString("logged_in_user_id", userId)
            putBoolean("is_logged_in", true)
            apply()
        }
    }

    fun clearLoginState() {
        sharedPrefHelper.getSharedPreferences().edit {
            remove("logged_in_user_id")
            putBoolean("is_logged_in", false)
            apply()
        }
    }

    fun isUserLoggedIn(): Boolean {
        return sharedPrefHelper.getSharedPreferences().getBoolean("is_logged_in", false)
    }

    fun getLoggedInUserId(): String? {
        return sharedPrefHelper.getSharedPreferences().getString("logged_in_user_id", null)
    }
}