// controllers/nurseController.js
const Nurse = require('../models/nurse');

async function createNurse(name, certification, ward_id) {
  debugger
  const nurse = new Nurse({ name, certification, ward_id });
  return await nurse.save();
}

async function getNurseById(nurseId) {
  return await Nurse.findById(nurseId).populate('ward_id');
}

async function updateNurse(nurseId, data) {
  return await Nurse.findByIdAndUpdate(nurseId, data, { new: true, runValidators: true });
}

async function deleteNurse(nurseId) {
  return await Nurse.findByIdAndDelete(nurseId);
}

module.exports = { createNurse, getNurseById, updateNurse, deleteNurse };
