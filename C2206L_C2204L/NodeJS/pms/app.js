const express = require('express');
const employeeRoutes = require('./routes/employeeRoutes');
const userRoutes = require('./routes/userRoutes');
const sexRoutes = require('./routes/sexRoutes');
const organizationRoutes = require('./routes/organizationRoutes');
const positionRoutes = require('./routes/positionRoutes');


const app = express();
const port = 3001;

app.use(express.json());

// Sử dụng tuyến đường cho thực thể "employees"
app.use('/api', employeeRoutes);
app.use('/api', userRoutes);
app.use('/api', organizationRoutes);
app.use('/api', sexRoutes);
app.use('/api', positionRoutes);


app.listen(port, () => {
  console.log(`Server đang lắng nghe tại cổng ${port}`);
});
