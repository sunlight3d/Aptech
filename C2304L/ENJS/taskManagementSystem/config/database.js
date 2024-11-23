const mysql = require('mysql2/promise');

const connectionPromise = mysql
  .createConnection({
    host: 'localhost',
    port: 3309, // Thay đổi cổng nếu cần
    user: 'root', // Thay đổi user nếu cần
    password: '', // Thay đổi mật khẩu
    database: 'C2304L',
  })
  .then((conn) => {
    console.log('Successfully connected to MySQL');
    return conn; // Trả về đối tượng connection
  })
  .catch((err) => {
    console.error('Connection error:', err);
    throw err; // Ném lỗi để xử lý ở nơi sử dụng
  });

module.exports = connectionPromise;