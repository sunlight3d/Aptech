const connectionPromise = require('../config/database');

const Task = {
  // Tạo task mới
  create: async (data) => {
    try {
      const connection = await connectionPromise;
      const query = `INSERT INTO tasks (title, description, status) VALUES (?, ?, ?)`;
      const [result] = await connection.query(query, [data.title, data.description, data.status]);

      return { id: result.insertId, ...data };
    } catch (err) {
      console.error(err);
      throw new Error('Lỗi khi tạo task');
    }
  },

  // Lấy danh sách tất cả tasks
  findAll: async () => {
    try {
      const query = `SELECT * FROM tasks`;
      const connection = await connectionPromise;
      const [rows] = await connection.query(query);

      return rows;
    } catch (err) {
      console.error(err);
      throw new Error('Lỗi khi lấy danh sách tasks');
    }
  },

  // Lấy task theo ID
  findById: async (id) => {
    try {
      const query = `SELECT * FROM tasks WHERE id = ?`;
      const connection = await connectionPromise;
      const [rows] = await connection.query(query, [id]);

      return rows[0] || null;
    } catch (err) {
      console.error(err);
      throw new Error('Lỗi khi lấy thông tin task');
    }
  },

  // Cập nhật task theo ID
  update: async (id, data) => {
    try {
      const query = `UPDATE tasks SET title = ?, description = ?, status = ? WHERE id = ?`;
      const connection = await connectionPromise;
      const [result] = await connection.query(query, [data.title, data.description, data.status, id]);

      if (result.affectedRows === 0) {
        throw new Error(`Task với ID ${id} không tồn tại`);
      }

      return await Task.findById(id); // Trả về task sau khi cập nhật
    } catch (err) {
      console.error(err);
      throw new Error('Lỗi khi cập nhật task');
    }
  },

  // Xóa task theo ID
  delete: async (id) => {
    try {
      const query = `DELETE FROM tasks WHERE id = ?`;
      const connection = await connectionPromise;
      const [result] = await connection.query(query, [id]);

      if (result.affectedRows === 0) {
        throw new Error(`Task với ID ${id} không tồn tại`);
      }

      return { message: `Task với ID ${id} đã bị xóa` };
    } catch (err) {
      console.error(err);
      throw new Error('Lỗi khi xóa task');
    }
  },
};

module.exports = Task;
