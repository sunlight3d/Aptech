const express = require('express');
const router = express.Router();

// GET: Lấy danh sách wards
router.get('/', (req, res) => {
    res.send('Get all wards');
});

router.get('/:id', (req, res) => {
    debugger
    res.send('Get detailsssss');
});

// POST: Thêm mới một ward
router.post('/', (req, res) => {
    res.send('Create a new ward');
});

// PUT: Cập nhật thông tin một ward
router.put('/:id', (req, res) => {
    res.send(`Update ward with ID ${req.params.id}`);
});

// DELETE: Xóa một ward
router.delete('/:id', (req, res) => {
    res.send(`Delete ward with ID ${req.params.id}`);
});

module.exports = router;
