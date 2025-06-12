const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');

const NotiLog = sequelize.define('notification_log', {
  notification_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    primaryKey: true,
    autoIncrement: true
  },
  user_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    allowNull: false
  },
  assignment_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    allowNull: false
  },
  notification_type: {
    type: DataTypes.ENUM('REMIND_BEFORE', 'REMIND_DEADLINE'),
    allowNull: false
  }
}, {
  timestamps: true,
  createdAt: 'sent_at',
  updatedAt: false,
  freezeTableName: true
});

module.exports = NotiLog;
