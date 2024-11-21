const connectionPromise = require('../config/database');
const Ward = {
  // Tạo ward mới
  create: async (data) => {
    try {
      const sql = `INSERT INTO wards (name, capacity, created_at, updated_at) VALUES (?, ?, NOW(), NOW())`;
      const connection = await connectionPromise;
      const [result] = await connection.query(sql, [data.name, data.capacity]);

      return { id: result.insertId, ...data };
    } catch (err) {
      console.error(err);
      throw new Error('Lỗi khi tạo ward');
    }
  },

  // Lấy danh sách tất cả wards
  findAll: async () => {
    try {
      const sql = `SELECT * FROM wards`;
      const connection = await connectionPromise;
      const [rows] = await connection.query(sql);

      return rows;
    } catch (err) {
      console.error(err);
      throw new Error('Lỗi khi lấy danh sách wards');
    }
  },

  // Lấy ward theo ID
  findById: async (id) => {
    try {
      const sql = `SELECT * FROM wards WHERE id = ?`;
      const connection = await connectionPromise;
      const [rows] = await connection.query(sql, [id]);

      return rows[0] || null;
    } catch (err) {
      console.error(err);
      throw new Error('Lỗi khi lấy thông tin ward');
    }
  },

  // Cập nhật ward theo ID
  update: async (id, data) => {
    try {
      const sql = `UPDATE wards SET name = ?, capacity = ?, updated_at = NOW() WHERE id = ?`;
      const connection = await connectionPromise;
      const [result] = await connection.query(sql, [data.name, data.capacity, id]);

      if (result.affectedRows === 0) {
        throw new Error(`Ward với ID ${id} không tồn tại`);
      }

      return await Ward.findById(id); // Trả về ward sau khi cập nhật
    } catch (err) {
      console.error(err);
      throw new Error('Lỗi khi cập nhật ward');
    }
  },

  // Xóa ward theo ID
  delete: async (id) => {
    try {
      const sql = `DELETE FROM wards WHERE id = ?`;
      const connection = await connectionPromise;
      const [result] = await connection.query(sql, [id]);

      if (result.affectedRows === 0) {
        throw new Error(`Ward với ID ${id} không tồn tại`);
      }

      return { message: `Ward với ID ${id} đã bị xóa` };
    } catch (err) {
      console.error(err);
      throw new Error('Lỗi khi xóa ward');
    }
  },
};

module.exports = Ward;

