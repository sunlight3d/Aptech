package com.example.myapp.utils
import android.content.Context
import com.example.myapp.models.User
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
                    if (tokens.size >= 3) {
                        val user = User(
                            phoneNumber = tokens[0],
                            userId = tokens[1],
                            sex = tokens[2],
                            heifaTotalScore = if (tokens[2] == "Male") tokens[3].toDouble() else tokens[4].toDouble()
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