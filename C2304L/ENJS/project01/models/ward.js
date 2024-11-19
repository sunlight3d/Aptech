const mongoose = require('../config/database');

const wardSchema = new mongoose.Schema({
  name: {
    type: String,
    required: [true, 'Tên không được để trống'],
    unique: true, // Đảm bảo name là duy nhất
    trim: true, // Loại bỏ khoảng trắng đầu và cuối
  },
  capacity: {
    type: Number,
    required: [true, 'Sức chứa không được để trống'],
    min: [1, 'Sức chứa phải lớn hơn 0'], // Giá trị nhỏ nhất là 1
  },
}, {
  timestamps: true, // Tự động thêm createdAt và updatedAt
});

// Đảm bảo unique được kiểm tra ở mức cơ sở dữ liệu
wardSchema.index({ name: 1 }, { unique: true });

module.exports = mongoose.model('Ward', wardSchema);
