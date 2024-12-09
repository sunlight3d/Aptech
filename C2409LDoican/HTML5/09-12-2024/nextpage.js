const klassNames = ['C1234L', 'C2409G', 'C2234L']
let klassSelectTag = document.getElementById("klass");

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