const mongoose = require('mongoose');
const uri = 'mongodb://localhost:27017/hospital';
const options = {
    autoIndex : true,
    serverSelectionTimeoutMS: 50000
};

mongoose.connect(uri, options).then(
  () => {
    console.log('Successfully connected to MongoDB');
  },
  (err) => {
    console.error('Connection error:', err);
  }
);
module.exports = mongoose;
