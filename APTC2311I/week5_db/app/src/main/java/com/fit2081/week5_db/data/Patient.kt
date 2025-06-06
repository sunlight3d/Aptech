package com.fit2081.week5_db.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a patient entity in the database.
 *
 * This data class is annotated with `@Entity` to
 * indicate that it represents a table in the database.
 * The `tableName` property specifies the name
 * of the table as "patient".
 */
@Entity(tableName = "patients")
data class Patient(
    /**
     * The unique identifier for the patient.
     * It is automatically generated by the database.
     */
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    /**
     * The name of the patient.
     */
    val name: String,
    /** The age of the patient */
    val age: Int,
    /** The address of the patient */
    val address: String,
)



