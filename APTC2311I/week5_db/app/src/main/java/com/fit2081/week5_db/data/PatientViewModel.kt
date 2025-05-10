package com.fit2081.week5_db.data

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PatientViewModel(context: Context) : ViewModel() {


    //creates a repo object that will be used to interact with the database
    private val patientRepo = PatientsRepository(context)
    //gets all the patients stored in the repo
    val allPatients: Flow<List<Patient>> = patientRepo.getAllPatients()

    //inserts a patient into the repo
    fun insert(patient: Patient) = viewModelScope.launch {
        patientRepo.insert(patient)
    }
    //deletes a patient from the repo
    fun delete(patient: Patient) = viewModelScope.launch {
        patientRepo.delete(patient)
    }
    //updates a patient in the repo
    fun update(patient: Patient) = viewModelScope.launch {
        patientRepo.update(patient)
        }
    //deletes all the patients in the repo
    fun deleteAllPatients() = viewModelScope.launch {
        patientRepo.deleteAllPatients()
    }
    //a view model factory that sets the context for the viewmodel
    //The ViewModelProvider.Factory interface is used to create view models.
    class PatientViewModelFactory(context: Context) : ViewModelProvider.Factory {
        private val context = context.applicationContext

        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            PatientViewModel(context) as T
    }
}