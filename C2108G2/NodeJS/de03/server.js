//npm install --save axios body-parser chalk cors express mysql2
const express = require('express')
const app = express();
const cors = require('cors');
const bodyParser = require('body-parser');
app.use(cors());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

const employeeRoutes = require('./routes/employee.js')
const userRoutes = require('./routes/user.js')
/*
const organizationRoutes = require('./routes/organization.js')
const positionRoutes = require('./routes/position.js')
const sexRoutes = require('./routes/sex.js')
const usersRoutes = require('./routes/users.js')      
*/

app.use('/api/employees', employeeRoutes);
app.use('/api/users', userRoutes);
/*
app.use('/api/organizations', organizationRoutes);
app.use('/api/positions', positionRoutes);
app.use('/api/sexs', sexRoutes);
app.use('/api/users', usersRoutes);
*/

app.listen(8081, () => {
  console.log('Server listening on port 8081');
});