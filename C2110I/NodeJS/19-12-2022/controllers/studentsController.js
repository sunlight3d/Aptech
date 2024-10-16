import { studentRepository } from "../repositories/index.js"

function getAllStudents(req, res) {
    let students = studentRepository.getAllStudents
    res.json({
        result: 'get all students',
        message: "haha"
    })
}
function getStudentById(req, res) {    
    res.status(200).json({
        result: `get student infor from student's id = ${req.params.id} `
    })
}
function updateStudent(req, res) {
    res.send(`Update a student with id = ${req.params.id}`)
}
function insertStudent(req, res) { 
    //validate ? YES    
    try {
        debugger
        let student = studentRepository.insertStudent(req.body)
        res.json({
            student,
            message: 'Insert student successfully'
        })
    }catch(error) {
        res.status(500).json({
            message: 'Cannot insert student:'+error
        })
    }
}

export default {
    getAllStudents,
    getStudentById,
    updateStudent,
    insertStudent
}