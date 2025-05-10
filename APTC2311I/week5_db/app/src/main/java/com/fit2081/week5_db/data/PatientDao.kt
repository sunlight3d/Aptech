package com.fit2081.week5_db.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// This interface defines the data access object (DAO) for the Patient entity.
@Dao
interface PatientDao {
    // Inserts a new patient into the database.
    //suspend is a coroutine function that can be paused and resumed at a later time.
    //suspend is used to indicate that the function will be called from a coroutine.
    @Insert
    suspend fun insert(patient: Patient)

    // Updates an existing patient in the database.
    @Update
    suspend fun update(patient: Patient)

    // Deletes a specific patient from the database.
    @Delete
    suspend fun delete(patient: Patient)

    // Deletes all patients from the database.
    @Query("DELETE FROM patients")
    suspend fun deleteAllPatients()

    // Retrieves all patients from the database, ordered by their ID in ascending order.
    //The return type is a Flow, which is a data stream that can be observed for changes.
    @Query("SELECT * FROM patients ORDER BY id ASC")
    fun getAllPatients(): Flow<List<Patient>>
}

