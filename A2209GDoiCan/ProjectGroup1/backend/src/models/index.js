// src/models/index.js
const sequelize = require('../config/database');
const { DataTypes } = require('sequelize');

/* ====== Users ====== */
const User = sequelize.define('users', {
  user_id: { type: DataTypes.BIGINT.UNSIGNED, primaryKey: true, autoIncrement: true },
  full_name: { type: DataTypes.STRING(100), allowNull: false },
  email: { type: DataTypes.STRING(255), allowNull: false, unique: true },
  password_hash: { type: DataTypes.STRING(255), allowNull: false },
  role: { type: DataTypes.ENUM('ADMIN','LECTURER','STUDENT'), allowNull: false, defaultValue:'STUDENT' },
  refresh_token: DataTypes.STRING(512),
  token_expires_at: DataTypes.DATE,
  last_login: DataTypes.DATE
}, { timestamps:true, createdAt:'created_at', updatedAt:'updated_at' });

/* ====== Classes ====== */
const Class = sequelize.define('classes', {
  class_id: { type: DataTypes.BIGINT.UNSIGNED, primaryKey: true, autoIncrement: true },
  class_code: { type: DataTypes.STRING(50), allowNull:false, unique:true },
  class_name: { type: DataTypes.STRING(100), allowNull:false },
  description: DataTypes.TEXT,
  semester: { type: DataTypes.STRING(20), allowNull:false }
}, { timestamps:true, createdAt:'created_at', updatedAt:false });

/* ====== ClassStudents (N-N) ====== */
const ClassStudent = sequelize.define('class_students', {
  joined_at: { type: DataTypes.DATE, defaultValue: DataTypes.NOW }
}, { timestamps:false });

/* ====== Assignments ====== */
const Assignment = sequelize.define('assignments', {
  assignment_id: { type: DataTypes.BIGINT.UNSIGNED, primaryKey:true, autoIncrement:true },
  title: { type: DataTypes.STRING(255), allowNull:false },
  description: DataTypes.TEXT,
  due_at: { type: DataTypes.DATE, allowNull:false },
  max_score: { type: DataTypes.DECIMAL(5,2), allowNull:false },
  assignment_type: { type: DataTypes.ENUM('INDIVIDUAL','GROUP'), allowNull:false, defaultValue:'INDIVIDUAL' },
  time_bound: { type: DataTypes.TINYINT, allowNull:false, defaultValue:0 },
  allow_resubmit: { type: DataTypes.TINYINT, allowNull:false, defaultValue:0 }
}, { timestamps:true, createdAt:'created_at', updatedAt:false });

/* ====== AssignmentAttachments ====== */
const Attachment = sequelize.define('assignment_attachments', {
  attachment_id: { type: DataTypes.BIGINT.UNSIGNED, primaryKey:true, autoIncrement:true },
  file_url: { type: DataTypes.STRING(512), allowNull:false }
}, { timestamps:true, createdAt:'uploaded_at', updatedAt:false });

/* ====== Submissions ====== */
const Submission = sequelize.define('submissions', {
  submission_id: { type: DataTypes.BIGINT.UNSIGNED, primaryKey:true, autoIncrement:true },
  attempt: { type: DataTypes.SMALLINT.UNSIGNED, allowNull:false, defaultValue:1 },
  submitted_at: { type: DataTypes.DATE, allowNull:false, defaultValue: DataTypes.NOW },
  note: DataTypes.TEXT,
  file_url: { type: DataTypes.STRING(512), allowNull:false },
  score: DataTypes.DECIMAL(5,2),
  feedback_text: DataTypes.TEXT,
  feedback_file_url: DataTypes.STRING(512),
  graded_at: DataTypes.DATE
}, { timestamps:false });

/* ====== SubmissionComments ====== */
const SubComment = sequelize.define('submission_comments', {
  comment_id: { type: DataTypes.BIGINT.UNSIGNED, primaryKey:true, autoIncrement:true },
  content: { type: DataTypes.TEXT, allowNull:false }
}, { timestamps:true, createdAt:'created_at', updatedAt:false });

/* ====== NotificationLog ====== */
const NotiLog = sequelize.define('notification_log', {
  notification_id: { type: DataTypes.BIGINT.UNSIGNED, primaryKey:true, autoIncrement:true },
  notification_type: { type: DataTypes.ENUM('REMIND_BEFORE','REMIND_DEADLINE'), allowNull:false }
}, { timestamps:true, createdAt:'sent_at', updatedAt:false });

/* === Associations === */
// User (LECTURER) 1-N Class
User.hasMany(Class, { foreignKey:'lecturer_id' });
Class.belongsTo(User, { as:'lecturer', foreignKey:'lecturer_id' });

// Many-to-Many Class <-> User (STUDENT)
User.belongsToMany(Class, { through:ClassStudent, foreignKey:'student_id' });
Class.belongsToMany(User, { through:ClassStudent, foreignKey:'class_id' });

// Class 1-N Assignment
Class.hasMany(Assignment, { foreignKey:'class_id' });
Assignment.belongsTo(Class, { foreignKey:'class_id' });

// Assignment 1-N Attachment
Assignment.hasMany(Attachment, { foreignKey:'assignment_id' });
Attachment.belongsTo(Assignment, { foreignKey:'assignment_id' });

// Assignment 1-N Submission
Assignment.hasMany(Submission, { foreignKey:'assignment_id' });
Submission.belongsTo(Assignment, { foreignKey:'assignment_id' });

// User (STUDENT) 1-N Submission
User.hasMany(Submission, { foreignKey:'student_id' });
Submission.belongsTo(User, { as:'student', foreignKey:'student_id' });

// User (LECTURER) 1-N graded Submission
User.hasMany(Submission, { foreignKey:'graded_by' });
Submission.belongsTo(User, { as:'grader', foreignKey:'graded_by' });

// Submission 1-N SubComment
Submission.hasMany(SubComment, { foreignKey:'submission_id' });
SubComment.belongsTo(Submission, { foreignKey:'submission_id' });

// User 1-N SubComment
User.hasMany(SubComment, { foreignKey:'user_id' });
SubComment.belongsTo(User, { foreignKey:'user_id' });

// User 1-N NotiLog
User.hasMany(NotiLog, { foreignKey:'user_id' });
NotiLog.belongsTo(User, { foreignKey:'user_id' });

// Assignment 1-N NotiLog
Assignment.hasMany(NotiLog, { foreignKey:'assignment_id' });
NotiLog.belongsTo(Assignment, { foreignKey:'assignment_id' });

module.exports = {
  sequelize,
  User, Class, ClassStudent,
  Assignment, Attachment,
  Submission, SubComment,
  NotiLog
};
