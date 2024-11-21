const connectionPromise = require('../config/database');
const Nurse = {
  // Tạo nurse mới
  create: async (data) => {
    try {
      const connection = await connectionPromise;
      const query = `INSERT INTO nurses (name, certification, ward_id, created_at, updated_at) VALUES (?, ?, ?, NOW(), NOW())`;
      const [result] = await connection.query(query, [data.name, data.certification, data.ward_id]);

      return { id: result.insertId, ...data };
    } catch (err) {
      console.error(err);
      throw new Error('Lỗi khi tạo nurse');
    }
  },

  // Lấy danh sách tất cả nurses
  findAll: async () => {
    try {
      const query = `SELECT nurses.*, wards.name AS ward_name FROM nurses 
                     INNER JOIN wards ON nurses.ward_id = wards.id`;
      const connection = await connectionPromise;                     
      const [rows] = await connection.query(query);

      return rows;
    } catch (err) {
      console.error(err);
      throw new Error('Lỗi khi lấy danh sách nurses');
    }
  },

  // Lấy nurse theo ID
  findById: async (id) => {
    try {
      const query = `SELECT * FROM nurses WHERE id = ?`;
      const connection = await connectionPromise;
      const [rows] = await connection.query(query, [id]);

      return rows[0] || null;
    } catch (err) {
      console.error(err);
      throw new Error('Lỗi khi lấy thông tin nurse');
    }
  },

  // Cập nhật nurse theo ID
  update: async (id, data) => {
    try {
      const query = `UPDATE nurses SET name = ?, certification = ?, ward_id = ?, updated_at = NOW() WHERE id = ?`;
      const connection = await connectionPromise;
      const [result] = await connection.query(query, [data.name, data.certification, data.ward_id, id]);

      if (result.affectedRows === 0) {
        throw new Error(`Nurse với ID ${id} không tồn tại`);
      }

      return await Nurse.findById(id); // Trả về nurse sau khi cập nhật
    } catch (err) {
      console.error(err);
      throw new Error('Lỗi khi cập nhật nurse');
    }
  },

  // Xóa nurse theo ID
  delete: async (id) => {
    try {
      const query = `DELETE FROM nurses WHERE id = ?`;
      const connection = await connectionPromise;
      const [result] = await connection.query(query, [id]);

      if (result.affectedRows === 0) {
        throw new Error(`Nurse với ID ${id} không tồn tại`);
      }

      return { message: `Nurse với ID ${id} đã bị xóa` };
    } catch (err) {
      console.error(err);
      throw new Error('Lỗi khi xóa nurse');
    }
  },
};

module.exports = Nurse;

