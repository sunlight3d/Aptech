package com.example.myapp.ui.counter
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CounterScreen() {
    // State để lưu giá trị count
    val count = remember { mutableStateOf(0) }

    // Giao diện màn hình Counter
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // Căn giữa theo chiều ngang
        verticalArrangement = Arrangement.Center // Căn giữa theo chiều dọc
    ) {
        // Row chứa các nút và Text
        Row(
            modifier = Modifier
                .fillMaxWidth() // Chiếm toàn bộ chiều rộng
                .wrapContentHeight(), // Chiều cao vừa đủ
            verticalAlignment = Alignment.CenterVertically, // Căn giữa các thành phần theo chiều dọc
            horizontalArrangement = Arrangement.Center // Căn giữa các thành phần theo chiều ngang
        ) {
            // Nút Decrease
            Button(
                onClick = { count.value-- }, // Giảm giá trị count, change state = setState
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Decrease")
            }

            // Hiển thị giá trị count
            Text(
                text = "${count.value}",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )

            // Nút Increase
            Button(
                onClick = { count.value++ }, // Tăng giá trị count
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Increase")
            }
        }
    }
}