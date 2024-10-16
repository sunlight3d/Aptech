const mysql = require('mysql2');
const connection = mysql.createConnection({
    host: 'localhost',
    port: 3316,
    user: 'root',
    password: '',
    database: 'studentManagements'
  });
  connection.connect((err) => {
    if (err) throw err;
    console.log('Connected to MySQL server!');
  });
  module.exports = connection;