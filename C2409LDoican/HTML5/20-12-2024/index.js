let tasks = []
/*
function addTask() {
    alert('ahahah')
}
*/
const addTask = () => {
    let taskName = document.getElementById("name").value
    tasks.push(taskName)
    document.getElementById("name").value = ''
    reloadTaskList()
}
const reloadTaskList = () => {
    let divTaskList = document.getElementById("taskList")
    divTaskList.innerText = '';
    for(let task of tasks) {
        debugger
        let pTag = document.createElement('p');
        pTag.id = task
        pTag.innerText = task
        divTaskList.appendChild(pTag)
    }
    
}