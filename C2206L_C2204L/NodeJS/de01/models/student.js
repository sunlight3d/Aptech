// models/student.js
const db = require('../db/db');

class Student {
  constructor(id, name, age, address, javaScore, cSharpScore) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.address = address;
    this.javaScore = javaScore;
    this.cSharpScore = cSharpScore;
  }
}

module.exports = Student;
