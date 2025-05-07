package com.fit2081.irene33624658.dao

import androidx.room.*
import com.fit2081.irene33624658.models.Patient
import kotlinx.coroutines.flow.Flow

@Dao
interface PatientDao {
    // Patient operations
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPatient(patient: Patient)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPatients(patients: List<Patient>)

    @Query("SELECT * FROM patients")
    fun getAllPatients(): Flow<List<Patient>>

    // FoodIntake operations
    @Insert
    suspend fun insertFoodIntake(foodIntake: FoodIntake)

    @Query("SELECT * FROM food_intakes WHERE userID = :userID")
    fun getFoodIntakesForPatient(userID: String): Flow<List<FoodIntake>>

    // Add other queries as needed
}