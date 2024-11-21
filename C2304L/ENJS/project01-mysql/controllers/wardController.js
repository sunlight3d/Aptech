// controllers/wardController.js
const {ObjectId} = require('mongoose').Types;

const Ward = require('../models/ward');

async function createWard(name, capacity) {
  // Tạo ward mới
  return await Ward.create({ name, capacity });
}

async function getWardById(id) {
  // Lấy thông tin ward theo ID
  const ward = await Ward.findById(id);
  if (!ward) {
    throw new Error(`Ward với ID ${id} không tồn tại`);
  }
  return ward;
}

async function getAllWards() {
  // Lấy danh sách tất cả wards
  return await Ward.findAll();
}

async function updateWard(wardId, data) {
  // Cập nhật ward theo ID
  const updatedWard = await Ward.update(wardId, data);
  if (!updatedWard) {
    throw new Error(`Ward với ID ${wardId} không tồn tại`);
  }
  return updatedWard;
}

async function deleteWard(id) {
  // Xóa ward theo ID
  const result = await Ward.delete(id);
  if (!result) {
    throw new Error(`Ward với ID ${id} không tồn tại`);
  }
  return { message: `Ward với ID ${id} đã bị xóa` };
}

module.exports = { createWard, getWardById, updateWard, deleteWard, getAllWards };
