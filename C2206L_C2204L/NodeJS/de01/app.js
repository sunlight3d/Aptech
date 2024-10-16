const express = require('express');
const cors = require('cors'); // Import cors
const studentRoutes = require('./routes/studentRoutes');

const app = express();
const port = 3001;

// Sử dụng cors middleware
app.use(cors());

app.use(express.json());

// Sử dụng tuyến đường cho thực thể "students"
app.use('/api', studentRoutes);

app.listen(port, () => {
  console.log(`Server đang lắng nghe tại cổng ${port}`);
});

