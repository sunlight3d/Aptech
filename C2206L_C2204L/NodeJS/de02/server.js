/*
console.log('cao ca c ban');
function sum(x, y) {
    console.log('jaahaha')
    debugger
    return x + y
}
let z = sum(2, 3)
console.log('Gia tri z = '+z)
console.log(`c ac abc acb dia tri z = ${z}`);
*/
const express = require('express');
const app = express();
const dotenv = require('dotenv');
// Đọc giá trị cổng từ tệp .env
dotenv.config();

app.get('/', (req, res) => {
    res.sendFile(__dirname + '/welcome.html');
});

const bodyParser = require('body-parser');
const employeesRouter = require('./routes/employees');//router
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.use('/api/employees', employeesRouter);

const port = process.env.PORT ?? 3000;
app.listen(port, () => {    
    console.log(`Server is running on port ${port}`);
});
