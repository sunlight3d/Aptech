/**
 * npm init
 * npm install express cors body-parser path
 */
const express = require('express')
const app = express();
const cors = require('cors');
const studentRoutes = require('./routes/employee.js')
const bodyParser = require('body-parser');
const path = require('path')
require('dotenv').config();

//const __dirname = path.dirname(path.resolve());
app.use(cors());
app.use(bodyParser.json());//sử dụng middlewware json để đọc json object
app.use(bodyParser.urlencoded({ extended: true }));
app.use('/api/employees', studentRoutes);

app.use('/', async (req, res) => {
    debugger
    res.sendFile(path.join(__dirname, 'index.html'));
})

const port = process.env.PORT || 3000
app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});