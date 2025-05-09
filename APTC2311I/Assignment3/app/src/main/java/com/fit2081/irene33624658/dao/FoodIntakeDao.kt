package com.fit2081.irene33624658.dao
import androidx.room.*
import com.fit2081.irene33624658.models.FoodIntake
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodIntakeDao {
    // Insert a new food intake record
    @Insert
    suspend fun insert(foodIntake: FoodIntake)

    // Update an existing food intake record
    @Update
    suspend fun update(foodIntake: FoodIntake)

    // Option 1: Delete by ID using query
    @Query("DELETE FROM food_intakes WHERE id = :id")
    suspend fun deleteById(id: Int)

    // Option 2: Or keep the entity-based delete if needed
    @Delete
    suspend fun delete(foodIntake: FoodIntake)

    // Delete all food intake records for a specific patient
    @Query("DELETE FROM food_intakes WHERE patientId = :patientId")
    suspend fun deleteAllForPatient(patientId: String)

    // Get all food intake records for a specific patient
    @Query("SELECT * FROM food_intakes WHERE patientId = :patientId ORDER BY createdAt DESC")
    fun getFoodIntakesForPatient(patientId: String): Flow<List<FoodIntake>>

    // Get a specific food intake record by ID
    @Query("SELECT * FROM food_intakes WHERE id = :id")
    suspend fun getFoodIntakeById(id: Int): FoodIntake?

    // Get food intakes containing specific food category
    @Query("SELECT * FROM food_intakes WHERE foodCategories LIKE '%' || :category || '%'")
    fun getByFoodCategory(category: String): Flow<List<FoodIntake>>

    // Get the most recent food intake for a patient
    @Query("SELECT * FROM food_intakes WHERE patientId = :patientId ORDER BY createdAt DESC LIMIT 1")
    suspend fun getLatestForPatient(patientId: String): FoodIntake?
}