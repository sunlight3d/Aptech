const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');

const SubComment = sequelize.define('submission_comments', {
  comment_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    primaryKey: true,
    autoIncrement: true
  },
  submission_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    allowNull: false
  },
  user_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    allowNull: false
  },
  content: {
    type: DataTypes.TEXT,
    allowNull: false
  }
}, {
  timestamps: true,
  createdAt: 'created_at',
  updatedAt: false,
  freezeTableName: true
});

module.exports = SubComment;
