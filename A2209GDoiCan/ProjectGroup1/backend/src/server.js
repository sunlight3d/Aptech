const express = require('express');
const app = express();
const port = process.env.PORT || 3000;
const { sequelize } = require('./models');

// Body-parser
app.use(express.json());

// demo route
app.get('/', (req, res) => res.send('Assignment API 🌟'));

// import router mẫu
// src/server.js
app.use('/api/classes', require('./routes/class.routes'));
app.use('/api/assignments', require('./routes/assignment.routes'));   // đã có
app.use('/api/submissions', require('./routes/submission.routes'));
app.use('/api/notifications', require('./routes/notilog.routes'));



(async () => {
  try {
    await sequelize.authenticate();
    console.log('✅  Đã kết nối MySQL');
    // Chỉ dùng sync() khi phát triển (tạo bảng tự động):
    // await sequelize.sync({ alter: true });
    app.listen(port, () => console.log(`🚀  Server chạy http://localhost:${port}`));
  } catch (err) {
    console.error('❌  Lỗi kết nối DB: ', err);
  }
})();
