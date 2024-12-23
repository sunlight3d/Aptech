let tasks = [
    "code c and c++",
    'Fix Java bugs',
    'Learn Javascript',
    'ReactJS learn and practice',
    'Go for a wark'
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
    if(tasks.length == 0) {
       const h1Tag = document.createElement('h1')
       h1Tag.innerHTML = 'No task found'
       divTaskList.append(h1Tag)
    }
    for(let i = 0; i < tasks.length; i++) {
        let task = tasks[i]
        debugger
        let divTask = document.createElement('div');
        divTask.id = task
        divTask.style = `width: 500px;`
        divTask.innerHTML = `<div style="
                                display:flex; 
                                flex-direction: row; 
                                margin: 5px; 
                                justify-content:space-between; 
                                align-items: center; 
                                background-color: ${i % 2 == 0 ? 'cyan' : 'coral'};
                            "> 
            <input type="checkbox" id = ${task} name="checkedTask">
            <span>- ${task} </span>
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
    //alert(`edit name : ${taskName}`)
    let newTaskName = prompt('Enter new name : ')
    for(let i = 0; i < tasks.length; i++) {
        let task = tasks[i]
        if(task === taskName) {
            tasks[i] = newTaskName
            reloadTaskList()
        }
    }
}
const deleteTask = (taskName) => {
    //alert(`delete name: ${taskName}`)
    if(confirm(`Do you want to delete this ? `)) {
        tasks = tasks.filter(task => task != taskName)
        reloadTaskList()
    }
}
const deleteTasks = () => {
    debugger
    let inputCheckboxes = document.querySelectorAll('input[name="checkedTask"][type="checkbox"]:checked');
    inputCheckboxes.forEach((checkbox) => {
        tasks = tasks.filter(task => task != checkbox.id)
    });
    reloadTaskList()
}