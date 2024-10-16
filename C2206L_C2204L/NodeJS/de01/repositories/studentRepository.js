const db = require('../db/db');
const Student = require('../models/student');

// Hàm lấy tất cả sinh viên
async function getAllStudents() {
  try {
    const connection = await db.getConnection();
    debugger
    const [rows] = await connection.query('SELECT * FROM students');
    connection.release();

    // Chuyển đổi kết quả từ mảng dòng thành danh sách đối tượng Student
    const students = rows.map(
      (row) =>
        new Student(
          row.Id,
          row.Name,
          row.Age,
          row.Address,
          row.JavaScore,
          row.CSharpScore
        )
    );

    return students;
  } catch (error) {
    throw error;
  }
}

// Hàm lấy sinh viên theo ID
async function getStudentById(id) {
  try {
    const connection = await db.getConnection();
    const [rows] = await connection.query('SELECT * FROM students WHERE Id = ?', [
      id,
    ]);
    connection.release();

    // Kiểm tra xem có sinh viên nào được tìm thấy không
    if (rows.length === 0) {
      return null;
    }

    const row = rows[0];
    const student = new Student(
      row.Id,
      row.Name,
      row.Age,
      row.Address,
      row.JavaScore,
      row.CSharpScore
    );

    return student;
  } catch (error) {
    throw error;
  }
}

// Hàm thêm sinh viên mới
async function createStudent(studentData) {
  const { name, age, address, javaScore, cSharpScore } = studentData;
  try {
    const connection = await db.getConnection();
    await connection.query(
      'INSERT INTO students (Name, Age, Address, JavaScore, CSharpScore) VALUES (?, ?, ?, ?, ?)',
      [name, age, address, javaScore, cSharpScore]
    );
    connection.release();
  } catch (error) {
    throw error;
  }
}

// Hàm cập nhật thông tin sinh viên
async function updateStudent(id, studentData) {
  const { name, age, address, javaScore, cSharpScore } = studentData;
  try {
    const connection = await db.getConnection();
    const [result] = await connection.query(
      'UPDATE students SET Name = ?, Age = ?, Address = ?, JavaScore = ?, CSharpScore = ? WHERE Id = ?',
      [name, age, address, javaScore, cSharpScore, id]
    );
    connection.release();

    return result;
  } catch (error) {
    throw error;
  }
}

// Hàm xóa sinh viên theo ID
async function deleteStudent(id) {
  try {
    const connection = await db.getConnection();
    const [result] = await connection.query('DELETE FROM students WHERE Id = ?', [
      id,
    ]);
    connection.release();

    return result;
  } catch (error) {
    throw error;
  }
}

module.exports = {
  getAllStudents,
  getStudentById,
  createStudent,
  updateStudent,
  deleteStudent,
};
