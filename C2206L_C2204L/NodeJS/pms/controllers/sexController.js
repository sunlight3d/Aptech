const express = require('express');
const router = express.Router();
const connectToDatabase = require('../db/db');

// Lấy danh sách tất cả giới tính
router.get('/sexes', (req, res) => {
  connectToDatabase()
    .then((connection) => {
      return connection.query('SELECT * FROM SEX');
    })
    .then((results) => {
      res.json(results);
    })
    .catch((error) => {
      console.error('Lỗi truy vấn:', error);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
    });
});

// Lấy thông tin một giới tính bằng ID
router.get('/sexes/:id', (req, res) => {
  const { id } = req.params;

  connectToDatabase()
    .then((connection) => {
      return connection.query('SELECT * FROM SEX WHERE SexID = ?', [id]);
    })
    .then((results) => {
      if (results.length === 0) {
        res.status(404).json({ error: 'Không tìm thấy giới tính với ID này.' });
        return;
      }
      res.json(results[0]);
    })
    .catch((error) => {
      console.error('Lỗi truy vấn:', error);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
    });
});

module.exports = router;
