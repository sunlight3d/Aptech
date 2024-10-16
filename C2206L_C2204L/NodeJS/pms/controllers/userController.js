const express = require('express');
const router = express.Router();
const connectToDatabase  = require('../db/db');

/**
curl -X GET http://localhost:3001/api/users
 */

// Lấy danh sách tất cả người dùng
router.get('/users', (req, res) => {
  connectToDatabase()
    .then((connection) => {
      return connection.query('SELECT * FROM USERS');
    })
    .then((results) => {
      res.json(results);
    })
    .catch((error) => {
      console.error('Lỗi truy vấn:', error);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
    });
});

// Lấy thông tin một người dùng bằng ID
router.get('/users/:id', (req, res) => {
  const { id } = req.params;

  connectToDatabase()
    .then((connection) => {
      return connection.query('SELECT * FROM USERS WHERE UsersID = ?', [id]);
    })
    .then((results) => {
      if (results.length === 0) {
        res.status(404).json({ error: 'Không tìm thấy người dùng với ID này.' });
        return;
      }
      res.json(results[0]);
    })
    .catch((error) => {
      console.error('Lỗi truy vấn:', error);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
    });
});

// Kiểm tra đăng nhập
router.get('/checkLogin', (req, res) => {
  const { UserName, Password } = req.body;

  connectToDatabase()
    .then((connection) => {
      return connection.query('SELECT * FROM USERS WHERE UserName = ? AND Password = ?', [UserName, Password]);
    })
    .then((results) => {
      if (results.length === 0) {
        res.status(401).json({ error: 'Sai tên đăng nhập hoặc mật khẩu.' });
        return;
      }
      const user = results[0];
      res.json({ message: 'Đăng nhập thành công', user });
    })
    .catch((error) => {
      console.error('Lỗi truy vấn:', error);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
    });
});

// Thêm một người dùng mới
router.post('/users', (req, res) => {
  const userData = req.body;

  connectToDatabase()
    .then((connection) => {
      return connection.query('INSERT INTO USERS SET ?', [userData]);
    })
    .then(() => {
      res.status(201).json({ message: 'Thêm người dùng thành công.' });
    })
    .catch((error) => {
      console.error('Lỗi truy vấn:', error);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
    });
});

// Cập nhật thông tin một người dùng bằng ID
router.put('/users/:id', (req, res) => {
  const { id } = req.params;
  const userData = req.body;

  connectToDatabase()
    .then((connection) => {
      return connection.query('UPDATE USERS SET ? WHERE UsersID = ?', [userData, id]);
    })
    .then(() => {
      res.json({ message: 'Cập nhật thông tin người dùng thành công.' });
    })
    .catch((error) => {
      console.error('Lỗi truy vấn:', error);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
    });
});

// Xóa một người dùng bằng ID
router.delete('/users/:id', (req, res) => {
  const { id } = req.params;

  connectToDatabase()
    .then((connection) => {
      return connection.query('DELETE FROM USERS WHERE UsersID = ?', [id]);
    })
    .then(() => {
      res.json({ message: 'Xóa người dùng thành công.' });
    })
    .catch((error) => {
      console.error('Lỗi truy vấn:', error);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
    });
});

module.exports = router;
