package com.fit2081.irene33624658.dao

import androidx.room.*
import com.fit2081.irene33624658.models.FoodIntake
import com.fit2081.irene33624658.models.NutriCoachTip
import com.fit2081.irene33624658.models.Patient
import kotlinx.coroutines.flow.Flow

@Dao
interface PatientDao {
    // Patient operations
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(patient: Patient)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPatients(patients: List<Patient>)

    @Update
    suspend fun update(patient: Patient)

    @Delete
    suspend fun delete(patient: Patient)

    @Query("DELETE FROM patients")
    suspend fun deleteAllPatients()

    @Query("SELECT * FROM patients WHERE userId = :userId")
    suspend fun getPatientById(userId: String): Patient?

    @Query("SELECT * FROM patients")
    fun getAllPatients(): Flow<List<Patient>>

    // FoodIntake operations
    @Insert
    suspend fun insertFoodIntake(foodIntake: FoodIntake)

    @Update
    suspend fun updateFoodIntake(foodIntake: FoodIntake)

    @Delete
    suspend fun deleteFoodIntake(foodIntake: FoodIntake)

    @Query("DELETE FROM food_intakes WHERE patientId = :patientId")
    suspend fun deleteAllFoodIntakesForPatient(patientId: String)

    @Query("SELECT * FROM food_intakes WHERE patientId = :patientId ORDER BY createdAt DESC")
    fun getFoodIntakesForPatient(patientId: String): Flow<List<FoodIntake>>

    @Query("SELECT * FROM food_intakes WHERE id = :id")
    suspend fun getFoodIntakeById(id: Int): FoodIntake?

    @Query("SELECT userId FROM patients")
    suspend fun getAllPatientIds(): List<String>

    // Add these to PatientDao.kt
    @Insert
    suspend fun insertMotivationalMessage(message: NutriCoachTip)

    @Query("SELECT * FROM nutri_coach_tips WHERE userId = :userId ORDER BY createdAt DESC")
    fun getMotivationalMessagesForUser(userId: String): Flow<List<NutriCoachTip>>

    @Query("DELETE FROM nutri_coach_tips WHERE userId = :userId")
    suspend fun deleteMotivationalMessagesForUser(userId: String)

}