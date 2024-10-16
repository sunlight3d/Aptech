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

export {
    getAllStudents,
    insertStudent,
    deleteStudent,    
}