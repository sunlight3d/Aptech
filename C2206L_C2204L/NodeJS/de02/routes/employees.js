const express = require('express');
const router = express.Router();
const employeeController = require('../controllers/employeeController'); //import
// Lấy danh sách tất cả nhân viên
router.get('/', employeeController.getAllEmployees);
//router.get('/stream_video', employeeController.streamVideo);

// Lấy thông tin một nhân viên bằng ID
router.get('/:id', employeeController.getEmployeeById);

// Thêm một nhân viên mới
router.post('/', employeeController.createEmployee);

// Cập nhật thông tin một nhân viên bằng ID
router.put('/:id', employeeController.updateEmployee);

// Xóa một nhân viên bằng ID
router.delete('/:id', employeeController.deleteEmployee);



module.exports = router;
