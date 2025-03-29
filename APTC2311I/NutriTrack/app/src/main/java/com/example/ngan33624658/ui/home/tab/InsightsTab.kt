package com.example.ngan33624658.ui.home.tab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.ui.text.font.FontWeight

@Composable
fun InsightsTab() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Insights: Food Score",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(16.dp))

        val foodScores = listOf(
            "Vegetables" to 10,
            "Fruits" to 10,
            "Grains & Cereals" to 10,
            "Whole Grains" to 10,
            "Meat & Alternatives" to 10,
            "Dairy" to 10,
            "Water" to 2,
            "Unsaturated Fats" to 10,
            "Sodium" to 10,
            "Sugar" to 10,
            "Alcohol" to 2,
            "Discretionary Foods" to 8
        )
        val products = listOf(
            "Laptop", "Smartphone", "Headphones", "Smartwatch",
            "Camera", "Tablet", "Speaker", "Monitor"
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Hiển thị 2 cột
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(products.size) { index ->
                ProductItem(products[index])
            }
        }

//        foodScores.forEach { (food, score) ->
//            FoodScoreRow(food, score)
//            Spacer(modifier = Modifier.height(8.dp))
//        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Total Food Quality Score",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        ScoreSlider(score = 40, maxScore = 100)

        Spacer(modifier = Modifier.height(20.dp))

        // Buttons
        Button(
            onClick = { /* Share action */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
        ) {
            Icon(Icons.Default.Share, contentDescription = "Share", tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Share with someone", color = Color.White)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { /* Improve diet action */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
        ) {
            Icon(Icons.Default.Star, contentDescription = "Improve", tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Improve my diet!", color = Color.White)
        }

        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun FoodScoreRow(food: String, score: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(0.9f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("dsjdiusjh", modifier = Modifier.weight(1f), fontSize = 16.sp)
        ScoreSlider(score, 10)
        Text("$score/10", fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ScoreSlider(score: Int, maxScore: Int) {
    Slider(
        value = score.toFloat(),
        onValueChange = {},
        valueRange = 0f..maxScore.toFloat(),
        colors = SliderDefaults.colors(
            thumbColor = Color(0xFF6200EE), // Màu tím cho nút kéo
            activeTrackColor = Color(0xFF6200EE), // Thanh tím bên trái
            inactiveTrackColor = Color(0xFFD1C4E9) // Thanh nhạt bên phải
        ),
        enabled = true
    )
}

@Composable
fun ProductItem(productName: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF6200EE))
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = productName,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
