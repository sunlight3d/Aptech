const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');

const Attachment = sequelize.define('assignment_attachments', {
  attachment_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    primaryKey: true,
    autoIncrement: true
  },
  assignment_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    allowNull: false
  },
  file_url: {
    type: DataTypes.STRING(512),
    allowNull: false
  }
}, {
  timestamps: true,
  createdAt: 'uploaded_at',
  updatedAt: false,
  freezeTableName: true
});

module.exports = Attachment;
