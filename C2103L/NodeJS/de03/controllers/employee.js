const connection = require('../connection.js')
function getEmployees(callback) {
    debugger
    connection.query('SELECT * FROM employee', (err, results, fields) => {
        debugger
        callback(err, results)
    })  
}
function getEmployeeById(employeeId, callback) {
    debugger
    connection.query('SELECT * FROM employee WHERE EmployeeID = ?',
        [employeeId],
     (err, results, fields) => {
        debugger
        callback(err, results)
    })  
}
function searchEmployees(searchText, callback) {    
    const sql = "SELECT * FROM employee WHERE Code LIKE ? "+
                "OR FirstName LIKE ? "+
                "OR LastName LIKE ? "+
                "OR Address LIKE ? "+
                "OR Phone LIKE ?"
    debugger                
    connection.query(sql,
        [`%${searchText}%`, `%${searchText}%`,`%${searchText}%`,`%${searchText}%`, `%${searchText}%`],
     (err, results, fields) => {
        debugger
        callback(err, results)
    })  
}
function deleteEmployeeById(employeeId, callback) {
    debugger
    connection.query('DELETE FROM employee WHERE EmployeeID = ?',
        [employeeId],
     (err, results, fields) => {
        debugger
        callback(err, results)
    })  
}
function updateEmployee(id, parameters, callback) {
  const updates = {}
  
  for(let key of Object.keys(parameters)) {
    if(key !== undefined) {
      updates[key] = parameters[key]
    }
  }    
  let sql = 'UPDATE employee SET '              
  const values = []  
  Object.keys(updates).forEach((key, index) => {
    sql += `${key} = ?, `
    values.push(updates[key])
  })
  sql = sql.slice(0, -2)  
  sql += ' WHERE employeeId = ?'
  values.push(id)
  debugger
  connection.execute(sql, values, (err, result) => {
    debugger
    if (err) throw err    
    connection.query(
      'SELECT * FROM employee WHERE employeeId = ? LIMIT 1',
      [id], 
      (err, results, fields) => {
        debugger
        if (err) throw err
        callback(err, results.length > 0 ? results[0] : {})        
      })
  })
}
function insertEmployee(parameters, callback) {
    const sql = "INSERT INTO employee("+              
    "FirstName,"+         
    "Code,"+                
    "LastName,"+            
    "Address,"+             
    "Phone,"+               
    "Mobile,"+              
    "Email ,"+              
    "Photo,"+               
    "CurriculumVitaeType,"+ 
    "CurriculumVitae,"+     
    "OrganizationID,"+      
    "DateofBirth,"+         
    "IndentifyNumber,"+     
    "IssuedPlace,"+         
    "IssuedDate,"+          
    "PresentResidence,"+    
    "RecruitedDate,"+       
    "DateOfEnteringOffice,"+
    "NominatedDate,"+       
    "SexID,"+               
    "PositionID,"+          
    "Status"+
    ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
    debugger
    const {
        FirstName,         
        Code,                
        LastName,            
        Address,             
        Phone,               
        Mobile,              
        Email,              
        Photo,               
        CurriculumVitaeType, 
        CurriculumVitae,     
        OrganizationID,      
        DateofBirth,         
        IndentifyNumber,     
        IssuedPlace,         
        IssuedDate,          
        PresentResidence,    
        RecruitedDate,       
        DateOfEnteringOffice,
        NominatedDate,       
        SexID,               
        PositionID,          
        Status
    } = parameters    
    const values = [        
        FirstName,         
        Code,                
        LastName,            
        Address,             
        Phone,               
        Mobile,              
        Email,              
        Photo,               
        CurriculumVitaeType, 
        CurriculumVitae,     
        OrganizationID,      
        DateofBirth,         
        IndentifyNumber,     
        IssuedPlace,         
        IssuedDate,          
        PresentResidence,    
        RecruitedDate,       
        DateOfEnteringOffice,
        NominatedDate,       
        SexID,               
        PositionID,          
        Status]  
    debugger
    connection.execute(sql, values, (err, result) => {
        debugger
        if (err) {
            callback(err, null)
            return
        }   
        connection.query(
            'SELECT * FROM employee WHERE EmployeeID = ? LIMIT 1',
            [result.insertId], 
            (err, results, fields) => {
                debugger
                callback(err, results.length > 0 ? results[0] : {})            
            }
        )      
    })

}
module.exports = {
    getEmployees,
    insertEmployee,
    getEmployeeById,
    deleteEmployeeById,
    updateEmployee,
    searchEmployees,
}