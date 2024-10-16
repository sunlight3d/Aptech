function getAllStudents(req, res) {
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
    res.send('Insert student')
}

export default {
    getAllStudents,
    getStudentById,
    updateStudent,
    insertStudent
}