const Student = require('../models/student');
const errorHandler = require('./errorHandler');
var mongoose = require('mongoose');

// Controller functions
const getStudents = async (req, res) => { 
    debugger   
    const students = await Student.find();
    debugger
    return res.json(students);
};

const getStudentById = async (req, res) => {
  const { id } = req.params;
  const student = await Student.findById(id);
    if (!student) {
      return res.status(404).json({ error: 'Student not found' });
    }
    res.json(student);
};

const createStudent = async (req, res) => {
    debugger
    const { name, email, age, klass_id, phone } = req.body;    
    const student = await Student.create({ 
      name, 
      email, 
      age,       
      phone,
    });
    res.status(201).json(student);
  };
  
const updateStudent = async (req, res) => {
    const { id } = req.params;
    const { name, description } = req.body;
    const student = await Student.findByIdAndUpdate(id, { name, description }, { new: true });
    if (!student) {
       return res.status(404).json({ error: 'Student not found' });
    }
    res.json(student);
  };
const deleteStudent = async (req, res) => {
    const { id } = req.params;
    const student = await Student.findByIdAndDelete(id);
    if (!student) {
      return res.status(404).json({ error: 'Student not found' });
    }
    res.json({ message: 'Student deleted' });
  };

  module.exports = { 
    getStudents: errorHandler(getStudents), 
    getStudentById: errorHandler(getStudentById), 
    createStudent: errorHandler(createStudent),  
    updateStudent: errorHandler(updateStudent), 
    deleteStudent: errorHandler(deleteStudent), 
 };
