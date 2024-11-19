const mongoose = require('../config/database');
const Ward = require('./ward');

const nurseSchema = new mongoose.Schema({
  name: {
    type: String,
    required: [true, 'Tên không được để trống'],
    trim: true, // Xóa khoảng trắng đầu và cuối
    minlength: [3, 'Tên phải có ít nhất 3 ký tự'], // Tên tối thiểu 3 ký tự
    maxlength: [50, 'Tên không được vượt quá 50 ký tự'], // Tên tối đa 50 ký tự
  },
  certification: {
    type: String,
    required: [true, 'Chứng chỉ không được để trống'],
    trim: true, // Xóa khoảng trắng đầu và cuối
    enum: {
      values: ['Bác sĩ', 'Y tá', 'Hộ lý', 'Kỹ thuật viên'], // Các chứng chỉ hợp lệ
      message: 'Chứng chỉ không hợp lệ', // Thông báo lỗi khi chứng chỉ không hợp lệ
    },
  },
  ward_id: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Ward',
    required: [true, 'Ward ID không được để trống'],
    validate: {
      validator: async function (value) {
        // Kiểm tra xem ward_id có tồn tại không
        const ward = await Ward.findById(value);
        return !!ward; // Trả về true nếu Ward tồn tại
      },
      message: 'Ward ID không hợp lệ hoặc không tồn tại', // Thông báo lỗi
    },
  },
}, {
  timestamps: true, // Tự động thêm createdAt và updatedAt
});

// Tạo chỉ mục unique nếu cần (ví dụ: không cho phép tên trùng lặp trong cùng một ward)
nurseSchema.index({ name: 1, ward_id: 1 }, { unique: true, sparse: true });

const Nurse = mongoose.model('Nurse', nurseSchema);
module.exports = Nurse;

