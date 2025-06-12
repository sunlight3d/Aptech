const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');

const User = sequelize.define('users', {
  user_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    primaryKey: true,
    autoIncrement: true,
    comment: 'Khóa chính người dùng'
  },
  full_name: {
    type: DataTypes.STRING(100),
    allowNull: false,
    comment: 'Họ và tên đầy đủ'
  },
  email: {
    type: DataTypes.STRING(255),
    unique: true,
    allowNull: false,
    comment: 'Địa chỉ email duy nhất'
  },
  password_hash: {
    type: DataTypes.STRING(255),
    allowNull: false,
    comment: 'Mật khẩu đã băm (BCrypt/PBKDF2)'
  },
  role: {
    type: DataTypes.ENUM('ADMIN', 'LECTURER', 'STUDENT'),
    defaultValue: 'STUDENT',
    allowNull: false,
    comment: 'Vai trò hệ thống'
  },
  refresh_token: DataTypes.STRING(512),
  token_expires_at: DataTypes.DATE,
  last_login: DataTypes.DATE
}, {
  timestamps: true,          // tự tạo created_at & updated_at
  createdAt: 'created_at',
  updatedAt: 'updated_at'
});

module.exports = User;
