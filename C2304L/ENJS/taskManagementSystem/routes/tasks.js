const express = require('express');
const router = express.Router();
const taskController = require('../controllers/taskController');

// GET: Lấy danh sách tasks
router.get('/', async (req, res) => {
    try {
        const tasks = await taskController.getAllTasks();
        res.json({
            message: 'Lấy danh sách tasks thành công',
            data: tasks,
        });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

// GET: Lấy thông tin chi tiết của một task
router.get('/:id', async (req, res) => {
    try {
        const task = await taskController.getTaskById(req.params.id);
        res.json({
            message: 'Lấy thông tin task thành công',
            data: task,
        });
    } catch (error) {
        res.status(404).json({ error: error.message });
    }
});

// POST: Thêm mới một task
router.post('/', async (req, res) => {
    const { title, description, status } = req.body; // Đảm bảo các trường đúng
    try {
        const newTask = await taskController.createTask({ title, description, status }); // Truyền object vào
        res.status(201).json({
            message: 'Tạo task mới thành công',
            data: newTask,
        });
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
});

// PUT: Cập nhật thông tin một task
router.put('/:id', async (req, res) => {
    try {
        const updatedTask = await taskController.updateTask(req.params.id, req.body); // req.body chứa thông tin cập nhật
        res.json({
            message: 'Cập nhật task thành công',
            data: updatedTask,
        });
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
});

// DELETE: Xóa một task
router.delete('/:id', async (req, res) => {
    try {
        await taskController.deleteTask(req.params.id);
        res.status(200).json({
            message: `Xóa task với ID ${req.params.id} thành công`,
        });
    } catch (error) {
        res.status(404).json({ error: error.message });
    }
});

module.exports = router;
