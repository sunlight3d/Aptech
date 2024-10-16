const mysql = require('mysql2');
const connection = mysql.createConnection({
    host: 'localhost',
    port: 3306,
    user: 'root',
    password: '',
    database: 'c2108g2'
  });
  connection.connect((err) => {    
    debugger
    if (err) throw err;
    console.log('Connected to MySQL server!');
  });
  module.exports = connection;