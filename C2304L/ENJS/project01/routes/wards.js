const express = require('express');
const router = express.Router();
const wardController = require('../controllers/wardController');

// GET: Lấy danh sách wards
router.get('/', async (req, res) => {
    try {
        const wards = await wardController.getAllWards();
        res.json(wards);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

// GET: Lấy thông tin chi tiết của một ward
router.get('/:id', async (req, res) => {
    try {
        const ward = await wardController.getWardById(req.params.id);
        res.json(ward);
    } catch (error) {
        res.status(404).json({ error: error.message });
    }
});

// POST: Thêm mới một ward
router.post('/', async (req, res) => {
    debugger
    const { name, capacity } = req.body;
    try {
        const newWard = await wardController.createWard(name, capacity);
        res.status(201).json(newWard);
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
});

// PUT: Cập nhật thông tin một ward
router.put('/:id', async (req, res) => {
    try {
        const updatedWard = await wardController.updateWard(req.params.id, req.body);
        res.json(updatedWard);
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
});

// DELETE: Xóa một ward
router.delete('/:id', async (req, res) => {
    try {
        const {id} = req.params
        await wardController.deleteWard(id);
        res.status(204).send();
    } catch (error) {
        res.status(404).json({ error: error.message });
    }
});

module.exports = router;
