package com.fit2081.irene33624658.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.fit2081.irene33624658.converters.DateConverter
import com.fit2081.irene33624658.models.FoodIntake
import com.fit2081.irene33624658.models.NutriCoachTip
import com.fit2081.irene33624658.models.Patient
@Database(
    entities = [
        Patient::class,
        FoodIntake::class,
        NutriCoachTip::class  // Thêm dòng này
    ],
    version = 8,  // Incremented version
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class HospitalDatabase : RoomDatabase() {
    abstract fun patientDao(): PatientDao
    abstract fun foodIntakeDao(): FoodIntakeDao
    abstract fun nutriCoachTipDao(): NutriCoachTipDao

    companion object {
        @Volatile
        private var Instance: HospitalDatabase? = null

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("""
                    CREATE TABLE nutri_coach_tips (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        userId TEXT NOT NULL,
                        message TEXT NOT NULL,
                        createdAt INTEGER NOT NULL
                    )
                """)
            }
        }
        fun getDatabase(context: Context): HospitalDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    HospitalDatabase::class.java,
                    "hospital_database"
                )
//                    .fallbackToDestructiveMigration()
                    .addMigrations(MIGRATION_1_2)  // Thêm migration
                    .build()
                    .also { Instance = it }
            }
        }
    }
}