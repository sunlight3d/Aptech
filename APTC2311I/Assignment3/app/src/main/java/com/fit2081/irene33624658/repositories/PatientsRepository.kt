package com.fit2081.irene33624658.repositories

import android.content.Context

import com.fit2081.irene33624658.utils.CsvProcessor
import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.fit2081.irene33624658.dao.HospitalDatabase
import com.fit2081.irene33624658.models.Patient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

private val Context.dataStore by preferencesDataStore(name = "app_preferences")

class PatientsRepository(context: Context) {
    // Property to hold the PatientDao instance
    private val patientDao: PatientDao
    // Property to hold the FoodIntakeDao instance
    private val foodIntakeDao: FoodIntakeDao
    // Property for DataStore
    private val dataStore = context.dataStore

    // Constructor to initialize the DAOs
    init {
        val database = HospitalDatabase.getDatabase(context)
        patientDao = database.patientDao()
        foodIntakeDao = database.foodIntakeDao()
    }

    // Patient operations
    suspend fun insert(patient: Patient) {
        patientDao.insert(patient)
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

    suspend fun deleteFoodIntake(id: Int) {
        foodIntakeDao.deleteFoodIntake(id)
    }

    // CSV initialization
    suspend fun initializeIfFirstRun(context: Context) {
        val isFirstRun = dataStore.data.first()[PreferencesKeys.IS_FIRST_RUN] ?: true
        if (isFirstRun) {
            CsvProcessor.processPatientsCsv(context, patientDao)
            dataStore.edit { preferences ->
                preferences[PreferencesKeys.IS_FIRST_RUN] = false
            }
        }
    }

    private object PreferencesKeys {
        val IS_FIRST_RUN = booleanPreferencesKey("is_first_run")
    }
}