package com.example.ngan33624658.ui.home.tab
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.ui.text.font.FontWeight

@Composable
fun HomeTab() {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text("Hello,", fontSize = 24.sp)
        Text("Rosie", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Text("You've already filled in your Food Intake Questionnaire, but you can change details here:")

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { /* Handle Edit action */ }) {
            Text("Edit")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("My Score", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        TextButton(onClick = { /* Navigate to all scores */ }) {
            Text("See all scores")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Your Food Quality score", fontSize = 20.sp)
        Text("80/100", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Text("What is the Food Quality Score?", fontSize = 20.sp)
        Text(
            "Your Food Quality Score provides a snapshot of how well your eating patterns align with established food guidelines, helping you identify both strengths and opportunities for improvement in your diet.",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "This personalized measurement considers various food groups including vegetables, fruits, whole grains, and proteins to give you practical insights for making healthier food choices.",
            fontSize = 16.sp
        )
    }
}
