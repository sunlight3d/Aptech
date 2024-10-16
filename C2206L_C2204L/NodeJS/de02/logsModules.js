const axios = require('axios');
const fs = require('fs');
const fileName = "logs.txt";
// Hàm để lưu log vào tệp bất đồng bộ
async function logToFile(message) {
  const timestamp = new Date().toISOString();
  const logMessage = `${timestamp}: ${message}\n`;
  try {
    await fs.promises.appendFile(fileName, logMessage); // Ghi log vào tệp app.log
  } catch (error) {
    console.error('Lỗi khi ghi log vào tệp:', error.message);
  }
}

// Hàm gửi yêu cầu GET và xử lý log
async function fetchEmployeeData() {
  try {
    const response = await axios.get('http://localhost:3001/api/employees');
    if (response.status === 200) {
      await logToFile('OK');
      await logToFile(`Data: ${JSON.stringify(response.data)}`);
    } else {
      await logToFile('Yêu cầu không thành công');
      await logToFile(`Status: ${response.status}`);
      await logToFile(`Data: ${JSON.stringify(response.data)}`);
    }
  } catch (error) {
    await logToFile(`Lỗi khi gửi yêu cầu: ${error.message}`);
  }
}

// Hàm gửi yêu cầu GET bằng ID và xử lý log
async function getEmployeeById(id) {
  try {
    const response = await axios.get(`http://localhost:3001/api/employees/${id}`);
    if (response.status === 200) {
      await logToFile(`GET by ID - OK: Employee ID ${id}`);
      await logToFile(`Data: ${JSON.stringify(response.data)}`);
    } else {
      await logToFile(`GET by ID - Yêu cầu không thành công: Employee ID ${id}`);
      await logToFile(`Status: ${response.status}`);
      await logToFile(`Data: ${JSON.stringify(response.data)}`);
    }
  } catch (error) {
    await logToFile(`GET by ID - Lỗi khi gửi yêu cầu: Employee ID ${id} - ${error.message}`);
  }
}

// Hàm thêm nhân viên mới và xử lý log
async function createEmployee(employeeData) {
  try {
    const response = await axios.post('http://localhost:3001/api/employees', employeeData);
    if (response.status === 201) {
      await logToFile('Thêm nhân viên mới - OK');
      await logToFile(`Data: ${JSON.stringify(response.data)}`);
    } else {
      await logToFile('Thêm nhân viên mới - Yêu cầu không thành công');
      await logToFile(`Status: ${response.status}`);
      await logToFile(`Data: ${JSON.stringify(response.data)}`);
    }
  } catch (error) {
    await logToFile(`Thêm nhân viên mới - Lỗi khi gửi yêu cầu: ${error.message}`);
  }
}

// Hàm cập nhật thông tin nhân viên theo ID và xử lý log
async function updateEmployee(id, employeeData) {
  try {
    const response = await axios.put(`http://localhost:3001/api/employees/${id}`, employeeData);
    if (response.status === 200) {
      await logToFile(`Cập nhật nhân viên - OK: Employee ID ${id}`);
      await logToFile(`Data: ${JSON.stringify(response.data)}`);
    } else {
      await logToFile(`Cập nhật nhân viên - Yêu cầu không thành công: Employee ID ${id}`);
      await logToFile(`Status: ${response.status}`);
      await logToFile(`Data: ${JSON.stringify(response.data)}`);
    }
  } catch (error) {
    await logToFile(`Cập nhật nhân viên - Lỗi khi gửi yêu cầu: Employee ID ${id} - ${error.message}`);
  }
}

// Hàm xóa nhân viên theo ID và xử lý log
async function deleteEmployee(id) {
  try {
    const response = await axios.delete(`http://localhost:3001/api/employees/${id}`);
    if (response.status === 204) {
      await logToFile(`Xóa nhân viên - OK: Employee ID ${id}`);
    } else {
      await logToFile(`Xóa nhân viên - Yêu cầu không thành công: Employee ID ${id}`);
      await logToFile(`Status: ${response.status}`);
      await logToFile(`Data: ${JSON.stringify(response.data)}`);
    }
  } catch (error) {
    await logToFile(`Xóa nhân viên - Lỗi khi gửi yêu cầu: Employee ID ${id} - ${error.message}`);
  }
}

// Gọi hàm để gửi yêu cầu khi module được require
fetchEmployeeData();
