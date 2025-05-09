package com.fit2081.irene33624658.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fit2081.irene33624658.models.FoodIntake
import com.fit2081.irene33624658.models.Patient
@Database(
    entities = [Patient::class, FoodIntake::class],
    version = 5,  // Incremented version
    exportSchema = false
)
abstract class HospitalDatabase : RoomDatabase() {
    abstract fun patientDao(): PatientDao
    abstract fun foodIntakeDao(): FoodIntakeDao

    companion object {
        @Volatile
        private var Instance: HospitalDatabase? = null

        fun getDatabase(context: Context): HospitalDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    HospitalDatabase::class.java,
                    "hospital_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}