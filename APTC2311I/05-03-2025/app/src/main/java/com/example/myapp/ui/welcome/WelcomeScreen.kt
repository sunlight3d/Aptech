package com.example.myapp.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.R
import com.example.myapp.ui.widgets.CustomAlertDialog
import kotlinx.coroutines.delay

@Composable //annotations, @Composable = JetPack composable
fun WelcomeScreen() {
    //state showAlert nhan 1 trong 2 gia trị, mặc định là false
    val showAlert = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(5000) // Delay 5 giây
        showAlert.value = true // Hiển thị AlertDialog
        //navigate sang man hinh khac sau 5 giay
    }
    if (showAlert.value) {

        CustomAlertDialog(
            title = "Thông báo",
            message = "Đây là thông báo từ popup!",
            onDismissRequest = {
                showAlert.value = false // Đóng AlertDialog khi người dùng nhấn bên ngoài
            },
            onConfirm = {
                showAlert.value = false // Đóng AlertDialog khi người dùng nhấn "OK"
            }
        )
    }
    //VD: có 1 màn hình hiển thị số bấm bấm nút. Mỗi lần bấm giá trị tăng lên 1, tên của state sẽ đặt count, remember
    // Sử dụng Box để chồng các thành phần lên nhau
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center //bat chuoc Flutter
    ) {
        // Ảnh nền
        Image(
            painter = painterResource(id = R.drawable.background), // Thay "background" bằng tên file ảnh của bạn
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Cắt ảnh để vừa với màn hình
        )

        // Dòng chữ "Welcome to MyApp"
        Text(
            text = "Welcome to MyApp",
            color = Color.Black,
            fontSize = 24.sp, //hay dung cho font chu, dp: dynamic point = pixel
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp))
    }
}