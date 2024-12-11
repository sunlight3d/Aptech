const klassNames = ['C1234L', 'C2409G', 'C2234L']
const students = [
    {
        name: 'Nguyen Van X',
        klass: 'C1234L',
        dob: '12-10-2001',
        gender: 'female',
        language: 'English, Japanese'
    },
    {
        name: 'Nguyen Van Y',
        klass: 'C9876L',
        dob: '15-10-2002',
        gender: 'male',
        language: 'English, Vietnamese'
    }
];
let klassSelectTag = document.getElementById("klass");
function deleteStudent(studentName) {
    alert('haha')
}


let studentListTable = document.getElementById('studentList');

for(let i = 0; i < students.length; i++) {
    let student = students[i]
    let row = studentListTable.insertRow();

    let tdName = row.insertCell(0);
    tdName.className = "each-td";
    tdName.innerHTML = student.name;
    
    let tdKlass = row.insertCell(1);
    tdKlass.className = "each-td"
    tdKlass.innerHTML = student.klass;
    
    
    let tdDOB = row.insertCell(2);
    tdDOB.className = "each-td"
    tdDOB.innerHTML = student.dob;
    
    let tdGender = row.insertCell(3);
    tdGender.className = "each-td"
    tdGender.innerHTML = student.gender;
    
    
    let tdLanguage = row.insertCell(4);
    tdLanguage.className = "each-td"
    tdLanguage.innerHTML = student.language;
    
    let tdButton = row.insertCell(5);
    tdButton.className = "each-td"
    tdButton.innerHTML = `<a href='#' onClick="deleteStudent('${tdName.innerHTML}')">Delete</a>`;

}


function addKlass(){
    let newKlass = prompt(`Enter class"s name :`)
    klassNames.push(newKlass)
    debugger
    reloadKlasses()
}

/*
let option = document.createElement("option");
option.text = "C1234L";
option.value = "C1234L"; 
*/
function reloadKlasses(){
    klassSelectTag.innerText = null;
    for(let i = 0; i < klassNames.length; i++) {
        let option = document.createElement("option");
        option.text = klassNames[i];
        option.value = klassNames[i]; 
        klassSelectTag.add(option);
    }
}
reloadKlasses()
function addStudent() {
    const name = document.getElementById('name')?.value?.trim()
    const dob = document.getElementById('dob')?.value?.trim()
    const gender = document.getElementById('gender')?.value?.trim()
    const languages = document.getElementsByName('language')
    
    const checkedLanguages = []
    for(let i = 0; i < languages.length; i++) {
        if(languages[i].checked === true) {
            checkedLanguages.push(languages[i].value)
        }
    }
    debugger
}