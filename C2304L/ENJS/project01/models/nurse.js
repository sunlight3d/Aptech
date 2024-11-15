const mongoose = require('../config/database');
const Ward = require('./ward');

const nurseSchema = new mongoose.Schema({
  name: {
    type: String,
    required: [true, 'Tên không được để trống'],
  },
  certification: {
    type: String,
    required: [true, 'Chứng chỉ không được để trống'],
  },
  ward_id: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Ward',
    required: [true, 'Ward ID không được để trống'],
  },
});

const Nurse = mongoose.model('Nurse', nurseSchema);
module.exports = Nurse;
