let tasks = [
    "code c and c++"
]
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
        let divTask = document.createElement('div');
        divTask.id = task
        divTask.style = `width: 500px;`
        divTask.innerHTML = `<div style="display:flex; flex-direction: row; margin: 5px; justify-content:space-between; align-items: center; background-color: red;"> 
            <span>- ${task} - </span>
            <div>
                <button class="btnEditTask" onClick="editTask('${task}')">Edit</button>
                <button class="btnDeleteTask" onClick="deleteTask('${task}')">Delete</button>
            </div>
        </div>`;
    
        divTaskList.appendChild(divTask)
    }
}
reloadTaskList()
const editTask = (taskName) => {
    alert('editTask')
}
const deleteTask = (taskName) => {
    alert('deleteTask')
}