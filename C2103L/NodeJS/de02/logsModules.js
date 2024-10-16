const axios = require('axios');
const {print, LOG_TYPE} = require('./LOG')

const SERVER_NAME = 'localhost'
const SERVER_PORT = 8081
const URL_EMPLOYEES = () => `http://${SERVER_NAME}:${SERVER_PORT}/api/employees`
const URL_DETAIL_EMPLOYEE = (id) => `http://${SERVER_NAME}:${SERVER_PORT}/api/employees/${id}`
const URL_INSERT_EMPLOYEE = () => `http://${SERVER_NAME}:${SERVER_PORT}/api/employees`
const URL_UPDATE_EMPLOYEE = (id) => `http://${SERVER_NAME}:${SERVER_PORT}/api/employees/${id}`
const URL_DELETE_EMPLOYEE = (id) => `http://${SERVER_NAME}:${SERVER_PORT}/api/employees/${id}`


const getAllEmployees = async () => {  
  try {
      let response = await axios.get(URL_EMPLOYEES())
      debugger
      //print("Status: " + response.status, LOG_TYPE.INFO)
  }catch(error) {
    debugger
    print("Status: " + response.status, LOG_TYPE.ERROR)      
  }   
}
const insertEmployee = async ({Name, Age, Address, Salary}) => {
    try {
      let response = await axios.post(
        URL_INSERT_EMPLOYEE(),
        {Name, Age, Address, Salary})
        debugger
        print("Status: " + response.status, LOG_TYPE.INFO)
    }catch(error) {
      debugger
      print("Status: " + error.message, LOG_TYPE.ERROR)      
    }      
}
const getDetailEmployee = async (id) => {
  try {
    let response = await axios.get(URL_DETAIL_EMPLOYEE(id))
    debugger
    print("Status: " + response.status+', data: '+JSON.stringify(response?.data?.data), 
      LOG_TYPE.INFO)
  }catch(error) {
    debugger
    print("Status: " + error.message, LOG_TYPE.ERROR)      
  }      
}
const updateEmployee = async ({Id, Name, Age, Address, Salary}) => {
  try {
    let response = await axios.put(URL_UPDATE_EMPLOYEE(Id), { Name, Age, Address, Salary})
    debugger
    print("Status: " + response.status+', data: '+JSON.stringify(response?.data), 
      LOG_TYPE.INFO)
  }catch(error) {
    debugger
    print("Status: " + error.message, LOG_TYPE.ERROR)      
  }        
}
const deleteEmployee = async (id) => {
  try {
    let response = await axios.delete(URL_DELETE_EMPLOYEE(id))
    print("Status: " + response.status, LOG_TYPE.INFO)
    debugger
  }catch(error) {
    debugger
    print("Status: " + error.message, LOG_TYPE.ERROR)      
  }  
}
module.exports = {
    getAllEmployees,
    insertEmployee,
    updateEmployee,
    deleteEmployee
}
//node logsModules.js 
//run test
const testAll = async () => {
  await getAllEmployees()
  await getDetailEmployee(2)
  await insertEmployee({Name: 'Nguyen Van Y', Age: 19, Address: '123 nha a ngo B', Salary: 1122})
  await updateEmployee({
    Id: 26, 
    Name: 'Nguyen Van Y', 
    Age: 19, 
    Address: '123 nha a ngo B', 
    Salary: 1122
  })
  //await deleteEmployee(2)
}
testAll()