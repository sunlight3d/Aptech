import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Slider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon

import androidx.compose.ui.unit.dp

// Data class chứa thông tin cho mỗi mục Food Score
data class FoodScoreItem(
    val name: String,
    val score: Int,
    val maxScore: Int
)

@Composable
fun InsightsTab() {
    // Dữ liệu mẫu
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

    // Tạo list các state cho giá trị slider của từng mục
    val sliderValues = remember {
        foodScores.map { mutableStateOf(it.score.toFloat()) }
    }

    // Tính tổng điểm từ các slider hiện tại
    val totalScore = sliderValues.sumOf { it.value.toInt() }
    val maxTotalScore = foodScores.sumOf { it.maxScore }

    // Container chính với Column
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header: Tiêu đề Insights
        Text(
            text = "Insights: Food Score",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        // Sử dụng LazyColumn để hiển thị danh sách các mục cùng phần tổng điểm
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            // Hiển thị từng mục, với chỉ số được cập nhật từ sliderValues
            itemsIndexed(foodScores) { index, item ->
                FoodScoreRow(item = item, sliderValue = sliderValues[index])
            }
            // Phần hiển thị Total Food Quality Score (chỉ hiển thị tổng, không cho thay đổi)
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Total Food Quality Score",
                    style = MaterialTheme.typography.titleMedium
                )
                Slider(
                    value = totalScore.toFloat(),
                    onValueChange = { /* Không xử lý thay đổi vì đây là tổng điểm */ },
                    valueRange = 0f..maxTotalScore.toFloat(),
                    enabled = false,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "$totalScore / $maxTotalScore",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            // Hai nút hành động ở cuối màn hình
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally // Căn giữa theo chiều ngang
                ) {
                    Button(
                        onClick = { /* Xử lý chia sẻ */ },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE)),
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

                    Button(
                        onClick = { /* Xử lý cải thiện chế độ ăn */ },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6200EE)
                        ),
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(horizontal = 16.dp) // Căn đều 2 bên
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
            Text(
                text = item.name,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
            // Hiển thị giá trị slider hiện tại và điểm tối đa
            Text(
                text = "${sliderValue.value.toInt()}/${item.maxScore}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        // Slider cho phép người dùng điều chỉnh giá trị
        Slider(
            value = sliderValue.value,
            onValueChange = { newValue -> sliderValue.value = newValue },
            valueRange = 0f..item.maxScore.toFloat(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InsightsTabPreview() {
    InsightsTab()
}