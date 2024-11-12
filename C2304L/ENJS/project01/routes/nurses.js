const express = require('express');
const router = express.Router();

// GET: Lấy danh sách nurses
router.get('/', (req, res) => {
    res.send('Get all nurses');
});

router.get('/:id', (req, res) => {    
    const {id} = req.params
    res.json({
        message: `Your id is : ${id}`
    })
    
});

// POST: Thêm mới một nurse
router.post('/', (req, res) => {
    debugger
    const {name, certification, ward_id} = req.body
    res.json({
        name, certification, ward_id
    })
});

// PUT: Cập nhật thông tin một nurse
router.put('/:id', (req, res) => {
    
    res.send(`Update nurse with ID ${req.params.id}`);
});

// DELETE: Xóa một nurse
router.delete('/:id', (req, res) => {
    res.send(`Delete nurse with ID ${req.params.id}`);
});

module.exports = router;
