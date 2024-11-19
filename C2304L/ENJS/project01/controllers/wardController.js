// controllers/wardController.js
const {ObjectId} = require('mongoose').Types;

const Ward = require('../models/ward');


async function createWard(name, capacity) {
  debugger
  const ward = new Ward({ name, capacity });    
  return await ward.save();
}

async function getWardById(id) {
  return await Ward.findOne({ _id: id });
}

async function getAllWards() {
  return await Ward.find();
}

async function updateWard(wardId, data) {
  return await Ward.findByIdAndUpdate(wardId, data, { new: true, runValidators: true });
}

async function deleteWard(id) {
  return await Ward.findByIdAndDelete(id);
}

module.exports = { createWard, getWardById, updateWard, deleteWard, getAllWards };
