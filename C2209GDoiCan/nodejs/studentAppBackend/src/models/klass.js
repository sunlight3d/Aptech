// models/klass.js

const mongoose = require('mongoose');
const Schema = mongoose.Schema;

// Define schema for Klass
const klassSchema = new Schema({
  name: {
    type: String,
    required: true,
    trim: true
  },
  description: {
    type: String,
    trim: true
  }
});

// Create and export Klass model with specified collection name
module.exports = mongoose.model('Klass', klassSchema, 'klasses');
