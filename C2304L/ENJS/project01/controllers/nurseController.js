const { ObjectId } = require('mongoose').Types;
const Nurse = require('../models/nurse');
const Ward = require('../models/ward');

async function createNurse(name, certification, ward_id) {
  // Kiểm tra tính hợp lệ của ward_id
  if (!ObjectId.isValid(ward_id)) {
    throw new Error('Ward ID không hợp lệ');
  }

  // Kiểm tra xem Ward có tồn tại không
  const wardExists = await Ward.findById(ward_id);
  if (!wardExists) {
    throw new Error(`Ward với ID ${ward_id} không tồn tại`);
  }

  // Tạo Nurse mới
  const nurse = new Nurse({ name, certification, ward_id });
  return await nurse.save();
}

async function getNurseById(nurseId) {
  // Kiểm tra tính hợp lệ của nurseId
  if (!ObjectId.isValid(nurseId)) {
    throw new Error('Nurse ID không hợp lệ');
  }

  // Lấy Nurse theo ID và populate thông tin Ward
  return await Nurse.findById(nurseId).populate('ward_id');
}

async function updateNurse(nurseId, data) {
  // Kiểm tra tính hợp lệ của nurseId
  if (!ObjectId.isValid(nurseId)) {
    throw new Error('Nurse ID không hợp lệ');
  }

  // Nếu có ward_id trong data, kiểm tra tính hợp lệ
  if (data.ward_id) {
    if (!ObjectId.isValid(data.ward_id)) {
      throw new Error('Ward ID không hợp lệ');
    }

    const wardExists = await Ward.findById(data.ward_id);
    if (!wardExists) {
      throw new Error(`Ward với ID ${data.ward_id} không tồn tại`);
    }
  }

  // Cập nhật Nurse
  return await Nurse.findByIdAndUpdate(nurseId, data, { new: true, runValidators: true });
}

async function deleteNurse(nurseId) {
  // Kiểm tra tính hợp lệ của nurseId
  if (!ObjectId.isValid(nurseId)) {
    throw new Error('Nurse ID không hợp lệ');
  }

  // Xóa Nurse theo ID
  return await Nurse.findByIdAndDelete(nurseId);
}

module.exports = { createNurse, getNurseById, updateNurse, deleteNurse };
