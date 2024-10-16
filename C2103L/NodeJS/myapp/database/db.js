const Sequelize = require('sequelize');
const sequelize = new Sequelize('c2103l', 'root', '', {
  host: 'localhost',
  port: 3316,
  dialect: 'mysql'
});
async function connect() {
  try {
    await sequelize.authenticate();       
    console.log('Connection has been established successfully.');
  } catch (error) {
    console.error('Unable to connect to the database:', error);
    console.log('Retrying in 5 seconds...');
    setTimeout(connect, 5000);
  }
}
module.exports = {
  sequelize,
  connect
}
