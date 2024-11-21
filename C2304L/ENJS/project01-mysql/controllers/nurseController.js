const { ObjectId } = require('mongoose').Types;
const Nurse = require('../models/nurse');
const Ward = require('../models/ward');

// Tạo nurse mới
async function createNurse(name, certification, ward_id) {
  // Kiểm tra xem ward_id có tồn tại
  const ward = await Ward.findById(ward_id);
  if (!ward) {
    throw new Error(`Ward với ID ${ward_id} không tồn tại`);
  }

  // Chèn nurse mới
  const nurse = await Nurse.create({ name, certification, ward_id });
  return nurse;
}

// Lấy danh sách tất cả nurses
async function getAllNurses() {
  const nurses = await Nurse.findAll();
  if (!nurses.length) {
    throw new Error('Không có nurse nào trong danh sách.');
  }

  // Lấy thông tin ward cho từng nurse
  const nursesWithWard = await Promise.all(
    nurses.map(async (nurse) => {
      const ward = await Ward.findById(nurse.ward_id);
      return { ...nurse, ward };
    })
  );

  return nursesWithWard;
}
// Lấy thông tin nurse theo ID
async function getNurseById(nurseId) {
  // Lấy thông tin nurse và ward
  const nurse = await Nurse.findById(nurseId);
  if (!nurse) {
    throw new Error(`Nurse với ID ${nurseId} không tồn tại`);
  }

  // Lấy thông tin chi tiết ward liên quan
  const ward = await Ward.findById(nurse.ward_id);
  if (ward) {
    nurse.ward = ward; // Thêm thông tin ward vào nurse
  }

  return nurse;
}

// Cập nhật nurse
async function updateNurse(nurseId, data) {
  // Kiểm tra nurse tồn tại
  const nurse = await Nurse.findById(nurseId);
  if (!nurse) {
    throw new Error(`Nurse với ID ${nurseId} không tồn tại`);
  }

  // Nếu có ward_id trong data, kiểm tra ward tồn tại
  if (data.ward_id) {
    const ward = await Ward.findById(data.ward_id);
    if (!ward) {
      throw new Error(`Ward với ID ${data.ward_id} không tồn tại`);
    }
  }

  // Cập nhật thông tin nurse
  const updatedNurse = await Nurse.update(nurseId, data);
  return updatedNurse;
}

// Xóa nurse
async function deleteNurse(nurseId) {
  // Kiểm tra nurse tồn tại
  const nurse = await Nurse.findById(nurseId);
  if (!nurse) {
    throw new Error(`Nurse với ID ${nurseId} không tồn tại`);
  }

  // Xóa nurse
  await Nurse.delete(nurseId);
  return { message: `Nurse với ID ${nurseId} đã bị xóa` };
}

module.exports = { 
  createNurse, 
  getAllNurses,
  getNurseById, updateNurse, deleteNurse };

