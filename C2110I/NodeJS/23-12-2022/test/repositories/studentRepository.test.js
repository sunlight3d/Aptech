//one test suite has many test cases
import { Student } from "../../models/index.js"
import userRepository from "../../repositories/userRepository.js"
import studentRepository from "../../repositories/studentRepository.js"

describe("Suite: Test insert, update, delete students", () => {
  it("-Test number of students", async () => {         
    let students = await studentRepository.getAllStudents()
    expect(students.length > 0).toEqual(true);
  })
})
