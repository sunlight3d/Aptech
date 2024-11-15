const mongoose = require('../config/database');

const wardSchema = new mongoose.Schema({
  name: {
    type: String,
    required: [true, 'Tên không được để trống'],
  },
  capacity: {
    type: Number,
    required: [true, 'Sức chứa không được để trống'],
    min: [1, 'Sức chứa phải lớn hơn 0'],
  },
});

const Ward = mongoose.model('Ward', wardSchema);
module.exports = Ward;
