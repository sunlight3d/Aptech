const express = require('express');
const router = express.Router();
const connectToDatabase  = require('../db/db');

// Lấy danh sách tất cả tổ chức
router.get('/organizations', (req, res) => {
  connectToDatabase()
    .then((connection) => {
      return connection.query('SELECT * FROM ORGANIZATION');
    })
    .then((results) => {
      res.json(results);
    })
    .catch((error) => {
      console.error('Lỗi truy vấn:', error);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
    });
});

// Lấy thông tin một tổ chức bằng ID
router.get('/organizations/:id', (req, res) => {
  const { id } = req.params;

  connectToDatabase()
    .then((connection) => {
      return connection.query('SELECT * FROM ORGANIZATION WHERE OrganizationID = ?', [id]);
    })
    .then((results) => {
      if (results.length === 0) {
        res.status(404).json({ error: 'Không tìm thấy tổ chức với ID này.' });
        return;
      }
      res.json(results[0]);
    })
    .catch((error) => {
      console.error('Lỗi truy vấn:', error);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
    });
});

// Thêm một tổ chức mới
router.post('/organizations', (req, res) => {
  const organizationData = req.body;

  connectToDatabase()
    .then((connection) => {
      return connection.query('INSERT INTO ORGANIZATION SET ?', [organizationData]);
    })
    .then(() => {
      res.status(201).json({ message: 'Thêm tổ chức thành công.' });
    })
    .catch((error) => {
      console.error('Lỗi truy vấn:', error);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
    });
});

// Cập nhật thông tin một tổ chức bằng ID
router.put('/organizations/:id', (req, res) => {
  const { id } = req.params;
  const organizationData = req.body;

  connectToDatabase()
    .then((connection) => {
      return connection.query('UPDATE ORGANIZATION SET ? WHERE OrganizationID = ?', [organizationData, id]);
    })
    .then(() => {
      res.json({ message: 'Cập nhật thông tin tổ chức thành công.' });
    })
    .catch((error) => {
      console.error('Lỗi truy vấn:', error);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
    });
});

// Xóa một tổ chức bằng ID
router.delete('/organizations/:id', (req, res) => {
  const { id } = req.params;

  connectToDatabase()
    .then((connection) => {
      return connection.query('DELETE FROM ORGANIZATION WHERE OrganizationID = ?', [id]);
    })
    .then(() => {
      res.json({ message: 'Xóa tổ chức thành công.' });
    })
    .catch((error) => {
      console.error('Lỗi truy vấn:', error);
      res.status(500).json({ error: 'Lỗi truy vấn cơ sở dữ liệu.' });
    });
});

module.exports = router;
