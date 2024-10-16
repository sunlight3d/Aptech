// routes/studentRoutes.js
const express = require('express');
const studentController = require('../controllers/studentController');

const router = express.Router();
const {
    getAllStudents, 
    getStudentById, 
    createStudent, 
    updateStudent, 
    deleteStudent
} = studentController
// Tạo tuyến đường GET để lấy tất cả sinh viên
router.get('/students', getAllStudents);

// Tạo tuyến đường GET để lấy sinh viên theo ID
router.get('/students/:id', getStudentById);

// Tạo tuyến đường POST để thêm sinh viên mới
router.post('/students', createStudent);

// Tạo tuyến đường PUT để cập nhật thông tin sinh viên
router.put('/students/:id', updateStudent);

// Tạo tuyến đường DELETE để xóa sinh viên theo ID
router.delete('/students/:id', deleteStudent);

module.exports = router;
