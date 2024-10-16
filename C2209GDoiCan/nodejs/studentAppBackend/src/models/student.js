// models/student.js

const mongoose = require('mongoose');
const {Schema} = mongoose;

// Define schema for Student
const studentSchema = new Schema({
  name: {
    type: String,
    required: true,
    trim: true
  },
  age: {
    type: Number,
    required: true,
    min: 0
  },
  email: {
    type: String,
    required: true,
    unique: true,
    trim: true
  },
  phone: {
    type: String,
    required: true,
    trim: true
  },  
});

// Create and export Student model with specified collection name
module.exports = mongoose.model('Student', studentSchema, 'students');
