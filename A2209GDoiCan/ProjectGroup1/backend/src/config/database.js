require('dotenv').config();
const { Sequelize } = require('sequelize');

const sequelize = new Sequelize(
  process.env.DB_NAME,
  process.env.DB_USER,
  process.env.DB_PASS,
  {
    host: process.env.DB_HOST,
    port: process.env.DB_PORT,
    dialect: 'mysql',
    define: {
      underscored: true,         // tên cột dùng snake_case
      freezeTableName: true       // không tự thêm 's' vào tên bảng
    },
    logging: false               // bật nếu cần debug SQL
  }
);

module.exports = sequelize;
