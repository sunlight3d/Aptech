const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');

const Class = sequelize.define('classes', {
  class_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    primaryKey: true,
    autoIncrement: true
  },
  class_code: {
    type: DataTypes.STRING(50),
    allowNull: false,
    unique: true
  },
  class_name: {
    type: DataTypes.STRING(100),
    allowNull: false
  },
  description: DataTypes.TEXT,
  semester: {
    type: DataTypes.STRING(20),
    allowNull: false
  },
  lecturer_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    allowNull: false
  }
}, {
  timestamps: true,
  createdAt: 'created_at',
  updatedAt: false,
  freezeTableName: true
});

module.exports = Class;
