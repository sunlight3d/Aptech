import { studentRepository } from "../repositories/index.js"

async function getAllStudents(req, res) {
    debugger
    let students = await studentRepository.getAllStudents()
    res.json({        
        message: "Get student list successfully",
        count: students.length,
        data: students,        
    })
}
async function getStudentById(req, res) {    
    res.status(200).json({
        result: `get student infor from student's id = ${req.params.id} `
    })
}
async function updateStudent(req, res) {
    res.send(`Update a student with id = ${req.params.id}`)
}
async function insertStudent(req, res) { 
    //validate ? YES    
    try {
        debugger
        let student = studentRepository.insertStudent(req.body)
        res.json({
            data: student,
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