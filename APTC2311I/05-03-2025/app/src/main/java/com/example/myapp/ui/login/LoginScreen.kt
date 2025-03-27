package com.example.myapp.ui.login
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.R
import com.example.myapp.ui.widgets.CustomAlertDialog
import com.example.myapp.utils.alert


//Android Composable = JAVA => NO !
//Android Composable = Kotlin => YES !

//Apple = SwiftUI = Swift => YES !
//Apple = SwiftUI = Objective C => NO !
@Composable
fun LoginScreen() {
    //Composable function LIKE "Functional Component" in React
    //we have 3 states
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") } //LazyColumn
    val context = LocalContext.current // Lấy context hiện tại

    // Màu gradient từ tím đậm đến tím nhạt
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(197, 163, 255), // Màu tím nhạt (RGB: 197, 163, 255)
            Color(147, 171, 253)  // Màu xanh nhạt (RGB: 147, 171, 253)
        ),
        startY = 0f, // Bắt đầu từ trên cùng
        endY = Float.POSITIVE_INFINITY // Kết thúc ở dưới cùng
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBrush) // Áp dụng nền gradient
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Tiêu đề
        Text(
            text = "Welcome,",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Glad to see you!",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Email Address
        OutlinedTextField( //EditText có outline
            value = email,
            onValueChange = { email = it }, //update state = change state
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Forgot Password?
        ClickableText(
            text = AnnotatedString("Forgot Password?"),
            onClick = { /* Xử lý khi nhấn vào Forgot Password */ },
            modifier = Modifier.align(Alignment.End),
            style = MaterialTheme.typography.bodySmall.copy(color = Color.Blue)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Login Button
        Button(
            onClick = {
                if(email.isEmpty() || password.isEmpty()) {
                    alert(context, "You must enter email and password");
                    //shared functions, placed in utils
                    return@Button;
                }
                alert(context, "You typed email : $email, password = $password");
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Or Login with
        Text(
            text = "Or Login with",
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Social Login Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Google Button
            OutlinedButton(
                onClick = {
                    alert(context, "Login with google")
                },
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google), // Thay bằng icon Google
                        contentDescription = "Google",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Google")
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Facebook Button
            OutlinedButton(
                onClick = {
                    alert(context, "You press Login Facebook")
                },
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_facebook), // Thay bằng icon Facebook
                        contentDescription = "Facebook",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Facebook")
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Don't have an account? Sign Up Now
        ClickableText(
            text = AnnotatedString("Don't have an account? Sign Up Now"),
            onClick = {
                alert(context, "Sign up now")
            },
            style = MaterialTheme.typography.bodySmall.copy(color = Color.Blue),
            modifier = Modifier.padding(8.dp)
        )
    }
}