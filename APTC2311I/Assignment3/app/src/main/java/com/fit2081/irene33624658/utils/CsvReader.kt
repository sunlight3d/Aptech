package com.fit2081.irene33624658.utils

import android.content.Context
import com.fit2081.irene33624658.models.Patient
import java.io.BufferedReader
import java.io.InputStreamReader

object CsvReader {
    private const val EXPECTED_COLUMNS = 63

    fun readPatientsFromCsv(context: Context, fileName: String = "data.csv"): List<Patient> {
        val users = mutableListOf<Patient>()

        try {
            context.assets.open(fileName).use { inputStream ->
                BufferedReader(InputStreamReader(inputStream)).use { reader ->
                    // skip header line
                    reader.readLine()

                    var line: String?
                    while (reader.readLine().also {line = it} != null) {
                        line?.let { csvLine ->
                            parseUserFromCsvLine(csvLine)?.let { user ->
                                users.add(user)
                            }

                        }
                    }

                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return users
    }

    private fun parseUserFromCsvLine(csvLine: String): Patient? {
        // handle quoted fields and commas within fields
        val tokens = parseCsvLine(csvLine)

        if (tokens.size < EXPECTED_COLUMNS) {
            return null
        }

        return try {
            Patient(
                phoneNumber = tokens[0],
                userId = tokens[1],
                name = "",
                sex = tokens[2],
                heifaTotalScoreMale = tokens[3].toDouble(),
                heifaTotalScoreFemale = tokens[4].toDouble(),
                discretionaryHeifaScoreMale = tokens[5].toDouble(),
                discretionaryHeifaScoreFemale = tokens[6].toDouble(),
                discretionaryServeSize = tokens[7].toDouble(),
                vegetablesHeifaScoreMale = tokens[8].toDouble(),
                vegetablesHeifaScoreFemale = tokens[9].toDouble(),
                vegetablesWithLegumesAllocatedServeSize = tokens[10].toDouble(),
                legumesAllocatedVegetables = tokens[11].toDouble(),
                vegetablesVariationsScore = tokens[12].toDouble(),
                vegetablesCruciferous = tokens[13].toDouble(),
                vegetablesTuberAndBulb = tokens[14].toDouble(),
                vegetablesOther = tokens[15].toDouble(),
                legumes = tokens[16].toDouble(),
                vegetablesGreen = tokens[17].toDouble(),
                vegetablesRedAndOrange = tokens[18].toDouble(),
                fruitHeifaScoreMale = tokens[19].toDouble(),
                fruitHeifaScoreFemale = tokens[20].toDouble(),
                fruitServeSize = tokens[21].toDouble(),
                fruitVariationsScore = tokens[22].toDouble(),
                fruitPome = tokens[23].toDouble(),
                fruitTropicalAndSubtropical = tokens[24].toDouble(),
                fruitBerry = tokens[25].toDouble(),
                fruitStone = tokens[26].toDouble(),
                fruitCitrus = tokens[27].toDouble(),
                fruitOther = tokens[28].toDouble(),
                grainsAndCerealsHeifaScoreMale = tokens[29].toDouble(),
                grainsAndCerealsHeifaScoreFemale = tokens[30].toDouble(),
                grainsAndCerealsServeSize = tokens[31].toDouble(),
                grainsAndCerealsNonWholeGrains = tokens[32].toDouble(),
                wholeGrainsHeifaScoreMale = tokens[33].toDouble(),
                wholeGrainsHeifaScoreFemale = tokens[34].toDouble(),
                wholeGrainsServeSize = tokens[35].toDouble(),
                meatAndAlternativesHeifaScoreMale = tokens[36].toDouble(),
                meatAndAlternativesHeifaScoreFemale = tokens[37].toDouble(),
                meatAndAlternativesWithLegumesAllocatedServeSize = tokens[38].toDouble(),
                legumesAllocatedMeatAndAlternatives = tokens[39].toDouble(),
                dairyAndAlternativesHeifaScoreMale = tokens[40].toDouble(),
                dairyAndAlternativesHeifaScoreFemale = tokens[41].toDouble(),
                dairyAndAlternativesServeSize = tokens[42].toDouble(),
                sodiumHeifaScoreMale = tokens[43].toDouble(),
                sodiumHeifaScoreFemale = tokens[44].toDouble(),
                sodiumMgMilligrams = tokens[45].toDouble(),
                alcoholHeifaScoreMale = tokens[46].toDouble(),
                alcoholHeifaScoreFemale = tokens[47].toDouble(),
                alcoholStandardDrinks = tokens[48].toDouble(),
                waterHeifaScoreMale = tokens[49].toDouble(),
                waterHeifaScoreFemale = tokens[50].toDouble(),
                water = tokens[51].toDouble(),
                waterTotalMl = tokens[52].toDouble(),
                beverageTotalMl = tokens[53].toDouble(),
                sugarHeifaScoreMale = tokens[54].toDouble(),
                sugarHeifaScoreFemale = tokens[55].toDouble(),
                sugar = tokens[56].toDouble(),
                saturatedFatHeifaScoreMale = tokens[57].toDouble(),
                saturatedFatHeifaScoreFemale = tokens[58].toDouble(),
                saturatedFat = tokens[59].toDouble(),
                unsaturatedFatHeifaScoreMale = tokens[60].toDouble(),
                unsaturatedFatHeifaScoreFemale = tokens[61].toDouble(),
                unsaturatedFatServeSize = tokens[62].toDouble()
            )
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Basic CSV line parser that handles:
     * - Standard comma-separated values
     * - Quoted fields containing commas
     * - Empty fields
     */
    private fun parseCsvLine(line: String): List<String> {
        val result = mutableListOf<String>()
        var current = StringBuilder()
        var inQuotes = false
        var i = 0  // manual index control

        while (i < line.length) {
            when {
                line[i] == '"' -> {
                    if (inQuotes && i + 1 < line.length && line[i + 1] == '"') {
                        // escaped quote
                        current.append('"')
                        i += 2  // skip both quotes
                        continue
                    } else {
                        inQuotes = !inQuotes
                        i++
                    }
                }
                !inQuotes && line[i] == ',' -> {
                    result.add(current.toString())
                    current = StringBuilder()
                    i++
                }
                else -> {
                    current.append(line[i])
                    i++
                }
            }
        }
        result.add(current.toString())
        return result
    }
}