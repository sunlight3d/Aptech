const app = require('./app'); // Import ứng dụng từ app.js

// Đặt cổng cho server
const PORT = 3000;

// Khởi động server
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
