
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