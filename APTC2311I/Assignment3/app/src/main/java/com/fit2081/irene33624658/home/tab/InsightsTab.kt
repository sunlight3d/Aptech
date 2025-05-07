package com.fit2081.irene33624658.home.tab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// data to represent each food score item
data class FoodScoreItem(
    val name: String,
    val score: Int,
    val maxScore: Int
)

@Composable
fun InsightsTab() {
    // sample data (can be replaced with dynamic user data)
    val foodScores = listOf(
        FoodScoreItem("Vegetables", 10, 10),
        FoodScoreItem("Fruits", 10, 10),
        FoodScoreItem("Grains & Cereals", 10, 10),
        FoodScoreItem("Whole Grains", 10, 10),
        FoodScoreItem("Meat & Alternatives", 10, 10),
        FoodScoreItem("Dairy", 10, 10),
        FoodScoreItem("Water", 2, 5),
        FoodScoreItem("Unsaturated Fats", 10, 10),
        FoodScoreItem("Sodium", 2, 10),
        FoodScoreItem("Sugar", 3, 10),
        FoodScoreItem("Alcohol", 1, 10),
        FoodScoreItem("Discretionary Foods", 8, 10)
    )

    // state for sliders (each score is individually adjustable
    val sliderValues = remember {
        foodScores.map { mutableStateOf(it.score.toFloat()) }
    }

    // calculate total current score from all sliders
    val totalScore = sliderValues.sumOf { it.value.toInt() }
    val maxTotalScore = foodScores.sumOf { it.maxScore }

    // main container
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header title
        Text(
            text = "Insights: Food Score",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(vertical = 8.dp),
            fontWeight = FontWeight.Bold
        )

        // scrollable list of food score items and total score
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            // display each food score item
            itemsIndexed(foodScores) { index, item ->
                FoodScoreRow(item = item, sliderValue = sliderValues[index])
            }
            // show the total score as a disabled slider for visual summary
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Total Food Quality Score",
                    style = MaterialTheme.typography.titleMedium
                )
                Slider(
                    value = totalScore.toFloat(),
                    onValueChange = { },
                    valueRange = 0f..maxTotalScore.toFloat(),
                    enabled = false,
                    modifier = Modifier.fillMaxWidth(),
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFF6EC9D5),
                        activeTrackColor = Color(0xFF6EC9D5),
                        inactiveTrackColor = Color(0xFF6EC9D5).copy(alpha = 0.24f)
                    )
                )
                Text(
                    text = "$totalScore / $maxTotalScore",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            // share and improve buttons at the bottom
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally // Căn giữa theo chiều ngang
                ) {
                    // share button
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6EC9D5)),
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Share",
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            ) // <- Thêm dấu đóng ngoặc ở đây
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Share with someone", color = Color.White)
                        }
                    }

                    // improve diet button
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6EC9D5)
                        ),
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Improve",
                                tint = Color.White,
                                modifier = Modifier.size(20.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "Improve my diet!",
                                color = Color.White
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun FoodScoreRow(item: FoodScoreItem, sliderValue: MutableState<Float>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // food group name
            Text(
                text = item.name,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
            // score out of max
            Text(
                text = "${sliderValue.value.toInt()}/${item.maxScore}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        // slider to adjust the score for that food group
        Slider(
            value = sliderValue.value,
            onValueChange = { newValue -> sliderValue.value = newValue },
            valueRange = 0f..item.maxScore.toFloat(),
            modifier = Modifier.fillMaxWidth(),
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF6EC9D5),       // thumb color
                activeTrackColor = Color(0xFF6EC9D5), // active track color
                inactiveTrackColor = Color(0xFF6EC9D5).copy(alpha = 0.24f) // inactive track
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InsightsTabPreview() {
    InsightsTab()
}