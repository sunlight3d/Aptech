// controllers/wardController.js
const Ward = require('../models/ward');

async function createWard(name, capacity) {
  debugger
  const ward = new Ward({ name, capacity });    
  return await ward.save();
}

async function getWardById(wardId) {
  return await Ward.findById(wardId);
}

async function updateWard(wardId, data) {
  return await Ward.findByIdAndUpdate(wardId, data, { new: true, runValidators: true });
}

async function deleteWard(wardId) {
  return await Ward.findByIdAndDelete(wardId);
}

module.exports = { createWard, getWardById, updateWard, deleteWard };
