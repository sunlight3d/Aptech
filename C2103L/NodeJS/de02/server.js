const express = require('express')
const app = express();
const cors = require('cors');
const studentRoutes = require('./routes/employee.js')
const bodyParser = require('body-parser');
const path = require('path')

//const __dirname = path.dirname(path.resolve());
app.use(cors());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use('/api/employees', studentRoutes);

app.use('/', async (req, res) => {
    debugger
    res.sendFile(path.join(__dirname, 'index.html'));
})


app.listen(8081, () => {
  console.log('Server listening on port 8081');
});