const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const studentKlassSchema = new Schema({
  klassId: {
    type: Schema.Types.ObjectId,
    ref: 'Klass', // Reference to the Klass model
    required: true
  },
  studentId: {
    type: Schema.Types.ObjectId,
    ref: 'Student', // Reference to the Student model
    required: true
  }
});

// Create and export StudentKlass model with specified collection name
module.exports = mongoose.model('StudentKlass', studentKlassSchema, 'studentklass');
