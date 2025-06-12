const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');

const ClassStudent = sequelize.define('class_students', {
  class_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    primaryKey: true
  },
  student_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    primaryKey: true
  },
  joined_at: {
    type: DataTypes.DATE,
    defaultValue: DataTypes.NOW
  }
}, {
  timestamps: false,
  freezeTableName: true
});

module.exports = ClassStudent;
