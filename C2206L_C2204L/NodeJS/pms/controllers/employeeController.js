const express = require('express');
const router = express.Router();
const connection = require('../db/db');

// Lấy danh sách tất cả nhân viên
router.get('/employees', (req, res) => {
  connection.query('SELECT * FROM EMPLOYEE', (err, results) => {
    if (err) {
      console.error('Lỗi truy vấn:', err);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
      return;
    }
    res.json(results);
  });
});

// Tìm kiếm nhân viên dựa trên Code, FullName, Address, và Phone
router.get('/employees/search', (req, res) => {
  const { strsearch } = req.query;
  const searchValue = `%${strsearch}%`;
  connection.query(
    'SELECT * FROM EMPLOYEE WHERE Code LIKE ? OR FullName LIKE ? OR Address LIKE ? OR Phone LIKE ?',
    [searchValue, searchValue, searchValue, searchValue],
    (err, results) => {
      if (err) {
        console.error('Lỗi truy vấn:', err);
        res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
        return;
      }
      res.json(results);
    }
  );
});


// Lấy thông tin một nhân viên bằng ID
router.get('/employees/:id', (req, res) => {
  const { id } = req.params;
  connection.query('SELECT * FROM EMPLOYEE WHERE EmployeeID = ?', [id], (err, results) => {
    if (err) {
      console.error('Lỗi truy vấn:', err);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
      return;
    }
    if (results.length === 0) {
      res.status(404).json({ error: 'Không tìm thấy nhân viên với ID này.' });
      return;
    }
    res.json(results[0]);
  });
});

// Thêm một nhân viên mới
router.post('/employees', (req, res) => {
  const employeeData = req.body;
  connection.query('INSERT INTO EMPLOYEE SET ?', [employeeData], (err, results) => {
    if (err) {
      console.error('Lỗi truy vấn:', err);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
      return;
    }
    res.status(201).json({ message: 'Thêm nhân viên thành công.' });
  });
});

// Cập nhật thông tin một nhân viên bằng ID
router.put('/employees/:id', (req, res) => {
  const { id } = req.params;
  const employeeData = req.body;
  connection.query('UPDATE EMPLOYEE SET ? WHERE EmployeeID = ?', [employeeData, id], (err, results) => {
    if (err) {
      console.error('Lỗi truy vấn:', err);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
      return;
    }
    res.json({ message: 'Cập nhật thông tin nhân viên thành công.' });
  });
});

// Xóa một nhân viên bằng ID
router.delete('/employees/:id', (req, res) => {
  const { id } = req.params;
  connection.query('DELETE FROM EMPLOYEE WHERE EmployeeID = ?', [id], (err, results) => {
    if (err) {
      console.error('Lỗi truy vấn:', err);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
      return;
    }
    res.json({ message: 'Xóa nhân viên thành công.' });
  });
});

module.exports = router;
