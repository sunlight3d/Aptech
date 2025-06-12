const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');

const Assignment = sequelize.define('assignments', {
  assignment_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    primaryKey: true,
    autoIncrement: true
  },
  class_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    allowNull: false
  },
  title: {
    type: DataTypes.STRING(255),
    allowNull: false
  },
  description: DataTypes.TEXT,
  due_at: {
    type: DataTypes.DATE,
    allowNull: false
  },
  max_score: {
    type: DataTypes.DECIMAL(5, 2),
    allowNull: false
  },
  assignment_type: {
    type: DataTypes.ENUM('INDIVIDUAL', 'GROUP'),
    allowNull: false,
    defaultValue: 'INDIVIDUAL'
  },
  time_bound: {
    type: DataTypes.TINYINT,
    allowNull: false,
    defaultValue: 0
  },
  allow_resubmit: {
    type: DataTypes.TINYINT,
    allowNull: false,
    defaultValue: 0
  }
}, {
  timestamps: true,
  createdAt: 'created_at',
  updatedAt: false,
  freezeTableName: true
});

module.exports = Assignment;
