const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');

const Submission = sequelize.define('submissions', {
  submission_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    primaryKey: true,
    autoIncrement: true
  },
  assignment_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    allowNull: false
  },
  student_id: {
    type: DataTypes.BIGINT.UNSIGNED,
    allowNull: false
  },
  attempt: {
    type: DataTypes.SMALLINT.UNSIGNED,
    allowNull: false,
    defaultValue: 1
  },
  submitted_at: {
    type: DataTypes.DATE,
    allowNull: false,
    defaultValue: DataTypes.NOW
  },
  note: DataTypes.TEXT,
  file_url: {
    type: DataTypes.STRING(512),
    allowNull: false
  },
  score: DataTypes.DECIMAL(5, 2),
  feedback_text: DataTypes.TEXT,
  feedback_file_url: DataTypes.STRING(512),
  graded_by: DataTypes.BIGINT.UNSIGNED,
  graded_at: DataTypes.DATE
}, {
  timestamps: false,
  freezeTableName: true
});

module.exports = Submission;
