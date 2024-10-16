//const Employee = require('../models/Employee');
const ffmpeg = require('fluent-ffmpeg');
const employeeRepository = require('../repositories/employee');

// Lấy danh sách tất cả nhân viên
const getAllEmployees = (req, res) => {  
  employeeRepository.getAllEmployees((err, employees) => {    
    if (err) {
      return res.status(500).json({ error: 'Lỗi khi lấy danh sách nhân viên' });
    }
    res.json(employees);
  });
};

// Lấy thông tin một nhân viên bằng ID
const getEmployeeById = (req, res) => {
  // Truy vấn một nhân viên bằng ID từ database và trả về kết quả
  debugger
  const employeeId = req.params.id; // Lấy ID từ tham số trong URL
  // Gọi hàm từ module Employee để lấy thông tin nhân viên theo ID
  employeeRepository.getEmployeeById(employeeId, (err, employee) => {
    if (err) {
      return res.status(500).json({ error: 'Lỗi khi lấy thông tin nhân viên' });
    }
    if (!employee) {
      return res.status(404).json({ error: 'Không tìm thấy nhân viên với ID này' });
    }
    res.json(employee);
  });
};

// Thêm một nhân viên mới
const createEmployee = (req, res) => {
  // Lấy dữ liệu từ req.body và thêm vào database
  const newEmployee = req.body; // Lấy dữ liệu từ req.body

  // Gọi hàm từ module Employee để thêm một nhân viên mới
  employeeRepository.createEmployee(newEmployee, (err, employeeId) => {
    if (err) {
      return res.status(500).json({ error: 'Lỗi khi tạo nhân viên mới' });
    }
    res.json({ message: 'Nhân viên đã được tạo thành công', employeeId });
  });
};

// Cập nhật thông tin một nhân viên bằng ID
const updateEmployee = (req, res) => {
  // Lấy dữ liệu từ req.body và cập nhật thông tin nhân viên trong database
  const employeeId = req.params.id; // Lấy ID từ tham số trong URL
  const updatedEmployee = req.body; // Lấy dữ liệu từ req.body

  // Gọi hàm từ module Employee để cập nhật thông tin nhân viên theo ID
  employeeRepository.updateEmployee(employeeId, updatedEmployee, (err) => {
    if (err) {
      return res.status(500).json({ error: 'Lỗi khi cập nhật thông tin nhân viên' });
    }
    res.json({ message: 'Thông tin nhân viên đã được cập nhật thành công' });
  });
};

// Xóa một nhân viên bằng ID
const deleteEmployee = (req, res) => {
  // Xóa một nhân viên bằng ID từ database
  const employeeId = req.params.id; // Lấy ID từ tham số trong URL

  // Gọi hàm từ module Employee để xóa nhân viên theo ID
  employeeRepository.deleteEmployee(employeeId, (err) => {
    if (err) {
      return res.status(500).json({ error: 'Lỗi khi xóa nhân viên' });
    }
    res.json({ message: 'Nhân viên đã được xóa thành công' });
  });
};

const streamVideo = (req, res) => {
    debugger
    const videoPath = require('path').resolve('./') + '/Video.mp4';
    debugger
    // Sử dụng ffmpeg để xử lý video và stream nó đến phản hồi (res)
    const ffmpegCommand = ffmpeg()
    .input(videoPath)
    .outputFormat('flv'); // Loại video được stream là MP4
    debugger
    // Bắt đầu quá trình stream video
    ffmpegCommand.on('end', () => {
        debugger
        console.log('Streaming ended');
    });
    
    // Pipe dữ liệu từ ffmpeg đến phản hồi (res)
    debugger
    ffmpegCommand.pipe(res, { end: true });
};

module.exports = {
  getAllEmployees,
  getEmployeeById,
  createEmployee,
  updateEmployee,
  deleteEmployee,
  streamVideo
};
