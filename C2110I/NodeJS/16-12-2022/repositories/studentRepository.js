import { Student } from "../models/index.js"
/*
let fakedStudents = [
    {
        id: "efexa",
        name: "Nguyen Van A",
        age: 18, 
        languages: ["English", "Vietnamese"],
        gender: 'male',
        phoneNumber: '0122224545',
        address: 'Address A, bb',
        class: 'C2009I'
    },
    {
        id: "ffexf",
        name: "Nguyen Van A",
        age: 18, 
        languages: ["English", "Vietnamese"],
        gender: 'male',
        phoneNumber: '0122224545',
        address: 'Address A, bb',
        class: 'C2009I'
    }
]
function getAllStudents() {
    return fakedStudents
}
const insertStudent = ({
    id,
    name, age, 
    languages, 
    gender,
    phoneNumber, 
    address, 
    klass}) =>  {
        fakedStudents.push({
            id,
            name, age, 
            languages, 
            gender,
            phoneNumber, 
            address, 
            klass})
}
const deleteStudent = (id) => {
    fakedStudents = fakedStudents
                        .filter((value, index, array) => value.id != id)
}
*/
const getAllStudents = async () => {
    try {
        let students = await Student.find().exec()
        return students
    }catch(error) {
        print('Cannot students from DB'+error)        
        throw new Error('Cannot students from DB'+error)
    }
}
const insertStudent = async ({
    name, email, languages, gender, phoneNumber,address
}) => {
    try {
        debugger
        let student = await Student
                        .create({name, email, languages, gender, phoneNumber,address})        
        debugger
        console.log('jhaha')  
    }catch(error) {
        debugger
        if(!!error.errors) {
            //loi do validation
        } else {
            //loi do db
            print('Cannot students from DB'+error)        
            throw new Error('Cannot students from DB'+error)
        }                
    }
}
export default {
    getAllStudents,
    insertStudent,
    //deleteStudent,    
}