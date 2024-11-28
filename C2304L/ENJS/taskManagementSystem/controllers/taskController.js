const Task = require('../models/task');

// Tạo task mới
async function createTask({ title, description, status }) {
  // Kiểm tra giá trị của status
  const validStatuses = ['Pending', 'In Progress', 'Completed'];
  if (!validStatuses.includes(status)) {
    throw new Error(`Status không hợp lệ. Chỉ chấp nhận các giá trị: ${validStatuses.join(', ')}`);
  }

  // Tạo task mới
  const task = await Task.create({ title, description, status });
  return task;
}

// Lấy danh sách tất cả tasks
async function getAllTasks() {
  const tasks = await Task.findAll();
  if (!tasks.length) {
    throw new Error('Không có task nào trong danh sách.');
  }

  return tasks;
}

// Lấy thông tin task theo ID
async function getTaskById(taskId) {
  // Lấy thông tin task
  const task = await Task.findById(taskId);
  if (!task) {
    throw new Error(`Task với ID ${taskId} không tồn tại`);
  }

  return task;
}

// Cập nhật task
async function updateTask(taskId, { title, description, status }) {
  // Kiểm tra task tồn tại
  const task = await Task.findById(taskId);
  if (!task) {
    throw new Error(`Task với ID ${taskId} không tồn tại`);
  }

  // Nếu có `status` trong data, kiểm tra giá trị hợp lệ
  if (status) {
    const validStatuses = ['Pending', 'In Progress', 'Completed'];
    if (!validStatuses.includes(status)) {
      throw new Error(`Status không hợp lệ. Chỉ chấp nhận các giá trị: ${validStatuses.join(', ')}`);
    }
  }

  // Cập nhật thông tin task
  const updatedTask = await Task.update(taskId, { title, description, status });
  return updatedTask;
}

// Xóa task
async function deleteTask(taskId) {
  // Kiểm tra task tồn tại
  const task = await Task.findById(taskId);
  if (!task) {
    throw new Error(`Task với ID ${taskId} không tồn tại`);
  }

  // Xóa task
  await Task.delete(taskId);
  return { message: `Task với ID ${taskId} đã bị xóa` };
}

module.exports = {
  createTask,
  getAllTasks,
  getTaskById,
  updateTask,
  deleteTask,
};
