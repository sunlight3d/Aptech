 // Đường dẫn đến module kết nối cơ sở dữ liệu
const createDBConnection = require('../db/db');

// Tạo kết nối cơ sở dữ liệu
const dbConnection = createDBConnection();

// Module Employee
const employeeRepository = {
    // Lấy danh sách tất cả nhân viên
    getAllEmployees(callback) {
        debugger
        const query = 'SELECT * FROM employees';
        dbConnection.query(query, (err, results) => {
        if (err) {
            callback(err, null);
        } else {
            callback(null, results);
        }
        });
    },
  // Hàm tạo một Employee mới
    createEmployee(employee, callback) {
    // Sử dụng dbConnection để thực hiện thao tác với cơ sở dữ liệu
    const { name, age, address, salary } = employee;//extract fields
    const query = 'INSERT INTO employees (name, age, address, salary) VALUES (?, ?, ?, ?)';
    dbConnection.query(query, [name, age, address, salary], (err, results) => {
        if (err) {
            callback(err, null);
        } else {
        callback(null, results.insertId); // Trả về ID của bản ghi mới được tạo
        }
    });    
  },
  
  // Hàm đọc thông tin Employee dựa trên ID
  getEmployeeById(id, callback) {
    // Sử dụng dbConnection để thực hiện thao tác với cơ sở dữ liệu    
    const query = 'SELECT * FROM employees WHERE id = ?';
    dbConnection.query(query, [id], (err, results) => {
        if (err) {
        callback(err, null);
        } else {
        if (results.length > 0) {
            callback(null, results[0]);
        } else {
            callback(new Error('Không tìm thấy Employee với ID này'), null);
        }
        }
    });
  },
  
  // Hàm cập nhật thông tin Employee dựa trên ID
  updateEmployee(id, updatedEmployee, callback) {
    // Sử dụng dbConnection để thực hiện thao tác với cơ sở dữ liệu    
    const { name, age, address, salary } = updatedEmployee;
    const query = 'UPDATE employees SET name = ?, age = ?, address = ?, salary = ? WHERE id = ?';
    dbConnection.query(query, [name, age, address, salary, id], (err, results) => {
        if (err) {
        callback(err);
        } else {
        callback(null);
        }
    });
  },
  
  // Hàm xóa Employee dựa trên ID
  deleteEmployee(id, callback) {    
    // Sử dụng dbConnection để thực hiện thao tác với cơ sở dữ liệu
    debugger
    const query = 'DELETE FROM employees WHERE id = ?';
    dbConnection.query(query, [id], (err, results) => {
        debugger
        if (err) {
            callback(err);
        } else {
            callback(null);
        }
    });
  },
};

module.exports = employeeRepository;
