package com.fit2081.irene33624658.utils

import android.content.Context
import com.fit2081.irene33624658.dao.PatientDao
import com.fit2081.irene33624658.models.Patient

object CsvProcessor {
    suspend fun processPatientsCsv(context: Context, dao: PatientDao) {
        //call 1 time, first time !
        //read csv file, then insert to RoomDB
        val patients = CsvReader.readPatientsFromCsv(context).map { user ->
            Patient(
                userId = user.userId,
                phoneNumber = user.phoneNumber,
                sex = user.sex,
                heifaTotalScoreMale = user.heifaTotalScoreMale,
                heifaTotalScoreFemale = user.heifaTotalScoreFemale,
                discretionaryHeifaScoreMale = user.discretionaryHeifaScoreMale,
                discretionaryHeifaScoreFemale = user.discretionaryHeifaScoreFemale,
                discretionaryServeSize = user.discretionaryServeSize,
                vegetablesHeifaScoreMale = user.vegetablesHeifaScoreMale,
                vegetablesHeifaScoreFemale = user.vegetablesHeifaScoreFemale,
                vegetablesWithLegumesAllocatedServeSize = user.vegetablesWithLegumesAllocatedServeSize,
                legumesAllocatedVegetables = user.legumesAllocatedVegetables,
                vegetablesVariationsScore = user.vegetablesVariationsScore,
                vegetablesCruciferous = user.vegetablesCruciferous,
                vegetablesTuberAndBulb = user.vegetablesTuberAndBulb,
                vegetablesOther = user.vegetablesOther,
                legumes = user.legumes,
                vegetablesGreen = user.vegetablesGreen,
                vegetablesRedAndOrange = user.vegetablesRedAndOrange,
                fruitHeifaScoreMale = user.fruitHeifaScoreMale,
                fruitHeifaScoreFemale = user.fruitHeifaScoreFemale,
                fruitServeSize = user.fruitServeSize,
                fruitVariationsScore = user.fruitVariationsScore,
                fruitPome = user.fruitPome,
                fruitTropicalAndSubtropical = user.fruitTropicalAndSubtropical,
                fruitBerry = user.fruitBerry,
                fruitStone = user.fruitStone,
                fruitCitrus = user.fruitCitrus,
                fruitOther = user.fruitOther,
                grainsAndCerealsHeifaScoreMale = user.grainsAndCerealsHeifaScoreMale,
                grainsAndCerealsHeifaScoreFemale = user.grainsAndCerealsHeifaScoreFemale,
                grainsAndCerealsServeSize = user.grainsAndCerealsServeSize,
                grainsAndCerealsNonWholeGrains = user.grainsAndCerealsNonWholeGrains,
                wholeGrainsHeifaScoreMale = user.wholeGrainsHeifaScoreMale,
                wholeGrainsHeifaScoreFemale = user.wholeGrainsHeifaScoreFemale,
                wholeGrainsServeSize = user.wholeGrainsServeSize,
                meatAndAlternativesHeifaScoreMale = user.meatAndAlternativesHeifaScoreMale,
                meatAndAlternativesHeifaScoreFemale = user.meatAndAlternativesHeifaScoreFemale,
                meatAndAlternativesWithLegumesAllocatedServeSize = user.meatAndAlternativesWithLegumesAllocatedServeSize,
                legumesAllocatedMeatAndAlternatives = user.legumesAllocatedMeatAndAlternatives,
                dairyAndAlternativesHeifaScoreMale = user.dairyAndAlternativesHeifaScoreMale,
                dairyAndAlternativesHeifaScoreFemale = user.dairyAndAlternativesHeifaScoreFemale,
                dairyAndAlternativesServeSize = user.dairyAndAlternativesServeSize,
                sodiumHeifaScoreMale = user.sodiumHeifaScoreMale,
                sodiumHeifaScoreFemale = user.sodiumHeifaScoreFemale,
                sodiumMgMilligrams = user.sodiumMgMilligrams,
                alcoholHeifaScoreMale = user.alcoholHeifaScoreMale,
                alcoholHeifaScoreFemale = user.alcoholHeifaScoreFemale,
                alcoholStandardDrinks = user.alcoholStandardDrinks,
                waterHeifaScoreMale = user.waterHeifaScoreMale,
                waterHeifaScoreFemale = user.waterHeifaScoreFemale,
                water = user.water,
                waterTotalMl = user.waterTotalMl,
                beverageTotalMl = user.beverageTotalMl,
                sugarHeifaScoreMale = user.sugarHeifaScoreMale,
                sugarHeifaScoreFemale = user.sugarHeifaScoreFemale,
                sugar = user.sugar,
                saturatedFatHeifaScoreMale = user.saturatedFatHeifaScoreMale,
                saturatedFatHeifaScoreFemale = user.saturatedFatHeifaScoreFemale,
                saturatedFat = user.saturatedFat,
                unsaturatedFatHeifaScoreMale = user.unsaturatedFatHeifaScoreMale,
                unsaturatedFatHeifaScoreFemale = user.unsaturatedFatHeifaScoreFemale,
                unsaturatedFatServeSize = user.unsaturatedFatServeSize
            )
        }

        dao.insertAllPatients(patients)
    }
}