// controllers/studentController.js
const studentRepository = require('../repositories/studentRepository');

// Controller để xử lý các yêu cầu HTTP liên quan đến sinh viên
async function getAllStudents(req, res) {
  try {
    const students = await studentRepository.getAllStudents();
    res.json(students);
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Lỗi trong quá trình truy vấn cơ sở dữ liệu' });
  }
}

async function getStudentById(req, res) {
  const studentId = req.params.id;
  try {
    const student = await studentRepository.getStudentById(studentId);
    if (!student) {
      res.status(404).json({ error: 'Không tìm thấy sinh viên với ID này' });
    } else {
      res.json(student);
    }
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Lỗi trong quá trình truy vấn cơ sở dữ liệu' });
  }
}

async function createStudent(req, res) {
  debugger
  const studentData = req.body;
  try {
    await studentRepository.createStudent(studentData);
    res.status(201).json({ message: 'Thêm sinh viên thành công' });
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Lỗi trong quá trình truy vấn cơ sở dữ liệu' });
  }
}

async function updateStudent(req, res) {
  const studentId = req.params.id;
  const studentData = req.body;
  try {
    const result = await studentRepository.updateStudent(studentId, studentData);
    if (result.affectedRows === 0) {
      res.status(404).json({ error: 'Không tìm thấy sinh viên với ID này' });
    } else {
      res.json({ message: 'Cập nhật thông tin sinh viên thành công' });
    }
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Lỗi trong quá trình truy vấn cơ sở dữ liệu' });
  }
}

async function deleteStudent(req, res) {
  const studentId = req.params.id;
  try {
    const result = await studentRepository.deleteStudent(studentId);
    if (result.affectedRows === 0) {
      res.status(404).json({ error: 'Không tìm thấy sinh viên với ID này' });
    } else {
      res.json({ message: 'Xóa sinh viên thành công' });
    }
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Lỗi trong quá trình truy vấn cơ sở dữ liệu' });
  }
}

module.exports = {
  getAllStudents,
  getStudentById,
  createStudent,
  updateStudent,
  deleteStudent,
};
