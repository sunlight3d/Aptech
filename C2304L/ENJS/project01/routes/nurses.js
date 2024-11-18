const express = require('express');
const router = express.Router();
const nurseController = require('../controllers/nurseController');

// GET: Lấy danh sách nurses
router.get('/', async (req, res) => {
    try {
        const nurses = await nurseController.getAllNurses();
        res.json(nurses);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

// GET: Lấy thông tin chi tiết của một nurse
router.get('/:id', async (req, res) => {
    try {
        const nurse = await nurseController.getNurseById(req.params.id);
        res.json(nurse);
    } catch (error) {
        res.status(404).json({ error: error.message });
    }
});

// POST: Thêm mới một nurse
router.post('/', async (req, res) => {
    debugger
    const { name, certification, ward_id } = req.body;
    try {
        const newNurse = await nurseController.createNurse(name, certification, ward_id);
        res.status(201).json(newNurse);
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
});

// PUT: Cập nhật thông tin một nurse
router.put('/:id', async (req, res) => {
    try {
        const updatedNurse = await nurseController.updateNurse(req.params.id, req.body);
        res.json(updatedNurse);
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
});

// DELETE: Xóa một nurse
router.delete('/:id', async (req, res) => {
    try {
        await nurseController.deleteNurse(req.params.id);
        res.status(204).send();
    } catch (error) {
        res.status(404).json({ error: error.message });
    }
});

module.exports = router;
