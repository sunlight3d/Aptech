package com.example.ngan33624658.utils

import android.content.Context
import com.example.ngan33624658.models.User
import java.io.BufferedReader
import java.io.InputStreamReader

object CsvReader {
    fun readUsersFromCsv(context: Context): List<User> {
        val users = mutableListOf<User>()

        try {
            val inputStream = context.assets.open("data.csv")
            val reader = BufferedReader(InputStreamReader(inputStream))

            // Bỏ qua dòng tiêu đề
            reader.readLine()

            var line: String?
            while (reader.readLine().also { line = it } != null) {
                line?.let {
                    val tokens = it.split(",")
                    if (tokens.size >= 56) { // Đảm bảo có đủ các trường
                        val user = User(
                            phoneNumber = tokens[0],
                            userId = tokens[1],
                            sex = tokens[2],//depends on sex
                            heifaTotalScoreMale = tokens[3].toDoubleOrNull() ?: 0.0,
                            heifaTotalScoreFemale = tokens[4].toDoubleOrNull() ?: 0.0,
                            discretionaryHeifaScoreMale = tokens[5].toDoubleOrNull() ?: 0.0,
                            discretionaryHeifaScoreFemale = tokens[6].toDoubleOrNull() ?: 0.0,
                            discretionaryServeSize = tokens[7].toDoubleOrNull() ?: 0.0,
                            vegetablesHeifaScoreMale = tokens[8].toDoubleOrNull() ?: 0.0,
                            vegetablesHeifaScoreFemale = tokens[9].toDoubleOrNull() ?: 0.0,
                            vegetablesWithLegumesAllocatedServeSize = tokens[10].toDoubleOrNull() ?: 0.0,
                            legumesAllocatedVegetables = tokens[11].toDoubleOrNull() ?: 0.0,
                            vegetablesVariationsScore = tokens[12].toDoubleOrNull() ?: 0.0,
                            vegetablesCruciferous = tokens[13].toDoubleOrNull() ?: 0.0,
                            vegetablesTuberAndBulb = tokens[14].toDoubleOrNull() ?: 0.0,
                            vegetablesOther = tokens[15].toDoubleOrNull() ?: 0.0,
                            legumes = tokens[16].toDoubleOrNull() ?: 0.0,
                            vegetablesGreen = tokens[17].toDoubleOrNull() ?: 0.0,
                            vegetablesRedAndOrange = tokens[18].toDoubleOrNull() ?: 0.0,
                            fruitHeifaScoreMale = tokens[19].toDoubleOrNull() ?: 0.0,
                            fruitHeifaScoreFemale = tokens[20].toDoubleOrNull() ?: 0.0,
                            fruitServeSize = tokens[21].toDoubleOrNull() ?: 0.0,
                            fruitVariationsScore = tokens[22].toDoubleOrNull() ?: 0.0,
                            fruitPome = tokens[23].toDoubleOrNull() ?: 0.0,
                            fruitTropicalAndSubtropical = tokens[24].toDoubleOrNull() ?: 0.0,
                            fruitBerry = tokens[25].toDoubleOrNull() ?: 0.0,
                            fruitStone = tokens[26].toDoubleOrNull() ?: 0.0,
                            fruitCitrus = tokens[27].toDoubleOrNull() ?: 0.0,
                            fruitOther = tokens[28].toDoubleOrNull() ?: 0.0,
                            grainsAndCerealsHeifaScoreMale = tokens[29].toDoubleOrNull() ?: 0.0,
                            grainsAndCerealsHeifaScoreFemale = tokens[30].toDoubleOrNull() ?: 0.0,
                            grainsAndCerealsServeSize = tokens[31].toDoubleOrNull() ?: 0.0,
                            grainsAndCerealsNonWholeGrains = tokens[32].toDoubleOrNull() ?: 0.0,
                            wholeGrainsHeifaScoreMale = tokens[33].toDoubleOrNull() ?: 0.0,
                            wholeGrainsHeifaScoreFemale = tokens[34].toDoubleOrNull() ?: 0.0,
                            wholeGrainsServeSize = tokens[35].toDoubleOrNull() ?: 0.0,
                            meatAndAlternativesHeifaScoreMale = tokens[36].toDoubleOrNull() ?: 0.0,
                            meatAndAlternativesHeifaScoreFemale = tokens[37].toDoubleOrNull() ?: 0.0,
                            meatAndAlternativesWithLegumesAllocatedServeSize = tokens[38].toDoubleOrNull() ?: 0.0,
                            legumesAllocatedMeatAndAlternatives = tokens[39].toDoubleOrNull() ?: 0.0,
                            dairyAndAlternativesHeifaScoreMale = tokens[40].toDoubleOrNull() ?: 0.0,
                            dairyAndAlternativesHeifaScoreFemale = tokens[41].toDoubleOrNull() ?: 0.0,
                            dairyAndAlternativesServeSize = tokens[42].toDoubleOrNull() ?: 0.0,
                            sodiumHeifaScoreMale = tokens[43].toDoubleOrNull() ?: 0.0,
                            sodiumHeifaScoreFemale = tokens[44].toDoubleOrNull() ?: 0.0,
                            sodiumMgMilligrams = tokens[45].toDoubleOrNull() ?: 0.0,
                            alcoholHeifaScoreMale = tokens[46].toDoubleOrNull() ?: 0.0,
                            alcoholHeifaScoreFemale = tokens[47].toDoubleOrNull() ?: 0.0,
                            alcoholStandardDrinks = tokens[48].toDoubleOrNull() ?: 0.0,
                            waterHeifaScoreMale = tokens[49].toDoubleOrNull() ?: 0.0,
                            waterHeifaScoreFemale = tokens[50].toDoubleOrNull() ?: 0.0,
                            water = tokens[51].toDoubleOrNull() ?: 0.0,
                            waterTotalMl = tokens[52].toDoubleOrNull() ?: 0.0,
                            beverageTotalMl = tokens[53].toDoubleOrNull() ?: 0.0,
                            sugarHeifaScoreMale = tokens[54].toDoubleOrNull() ?: 0.0,
                            sugarHeifaScoreFemale = tokens[55].toDoubleOrNull() ?: 0.0,
                            sugar = tokens[56].toDoubleOrNull() ?: 0.0,
                            saturatedFatHeifaScoreMale = tokens[57].toDoubleOrNull() ?: 0.0,
                            saturatedFatHeifaScoreFemale = tokens[58].toDoubleOrNull() ?: 0.0,
                            saturatedFat = tokens[59].toDoubleOrNull() ?: 0.0,
                            unsaturatedFatHeifaScoreMale = tokens[60].toDoubleOrNull() ?: 0.0,
                            unsaturatedFatHeifaScoreFemale = tokens[61].toDoubleOrNull() ?: 0.0,
                            unsaturatedFatServeSize = tokens[62].toDoubleOrNull() ?: 0.0
                        )
                        users.add(user)
                    }
                }
            }
            reader.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return users
    }
}