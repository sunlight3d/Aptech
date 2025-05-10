package com.fit2081.week5_db.data

import android.content.Context
import kotlinx.coroutines.flow.Flow

class PatientsRepository {

    // Property to hold the PatientDao instance.
    var patientDao: PatientDao
    // Constructor to initialize the PatientDao.
    constructor(context: Context) {
        // Get the PatientDao instance from the HospitalDatabase.
        patientDao = HospitalDatabase.getDatabase(context).patientDao()
    }
    // Function to insert a patient into the database.
    suspend fun insert(patient: Patient) {
        // Call the insert function from the PatientDao.
        patientDao.insert(patient)
    }
    // Function to delete a patient from the database.
    suspend fun delete(patient: Patient) {
        // Call the delete function from the PatientDao.
        patientDao.delete(patient)
    }
    // Function to update a patient in the database.
    suspend fun update(patient: Patient) {
        // Call the update function from the PatientDao.
        patientDao.update(patient)
    }
    // Function to delete all patients from the database.
    suspend fun deleteAllPatients() {
        // Call the deleteAllPatients function from the PatientDao.
        patientDao.deleteAllPatients()
    }
    // Function to get all patients from the database as a Flow.
    fun getAllPatients():   Flow<List<Patient>> = patientDao.getAllPatients()
}

