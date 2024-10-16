const express = require('express');
const router = express.Router();
const connectToDatabase = require('../db/db');

// Lấy danh sách tất cả vị trí công việc
router.get('/positions', (req, res) => {
  connectToDatabase()
    .then((connection) => {
      return connection.query('SELECT * FROM POSITION');
    })
    .then((results) => {
      res.json(results);
    })
    .catch((error) => {
      console.error('Lỗi truy vấn:', error);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
    });
});

// Lấy thông tin một vị trí công việc bằng ID
router.get('/positions/:id', (req, res) => {
  const { id } = req.params;

  connectToDatabase()
    .then((connection) => {
      return connection.query('SELECT * FROM POSITION WHERE PositionID = ?', [id]);
    })
    .then((results) => {
      if (results.length === 0) {
        res.status(404).json({ error: 'Không tìm thấy vị trí công việc với ID này.' });
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
