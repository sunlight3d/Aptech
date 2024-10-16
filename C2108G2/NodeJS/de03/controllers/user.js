const connection = require('../connection.js')
function getUsers(callback) {
    debugger
    connection.query('SELECT * FROM users', (err, results, fields) => {
        debugger
        callback(err, results)
    })  
}
function insertUser(parameters, callback) {
    const sql = "INSERT INTO users("+              
    "UserName,"+         
    "Password,"+                
    "Discription,"+            
    "EmployeeID"+                 
    ") VALUES (?,?,?,?)"
    debugger
    const {         
        UserName,   
        Password ,  
        Discription,
        EmployeeID
    } = parameters    
    const values = [                
        UserName,   
        Password ,  
        Discription,
        EmployeeID,
    ]  
    debugger
    connection.execute(sql, values, (err, result) => {
        debugger
        if (err) {
            callback(err, null)
            return
        }   
        connection.query(
            'SELECT * FROM users WHERE UsersID = ? LIMIT 1',
            [result.insertId], 
            (err, results, fields) => {
                debugger
                callback(err, results.length > 0 ? results[0] : {})            
            }
        )      
    })
}
function updateUser(id, parameters, callback) {
    const updates = {}    
    debugger
    for(let key of Object.keys(parameters)) {
      if(key !== undefined) {
        updates[key] = parameters[key]
      }
    }    
    let sql = 'UPDATE users SET '              
    const values = []  
    Object.keys(updates).forEach((key, index) => {
      sql += `${key} = ?, `
      values.push(updates[key])
    })
    sql = sql.slice(0, -2)  
    sql += ' WHERE UsersID = ?'
    values.push(id)
    debugger
    connection.execute(sql, values, (err, result) => {
      debugger
      if (err) throw err    
      connection.query(
        'SELECT * FROM users WHERE UsersID = ? LIMIT 1',
        [id], 
        (err, results, fields) => {
          debugger
          if (err) throw err
          callback(err, results.length > 0 ? results[0] : {})        
        })
    })
}
function deleteUserById(userId, callback) {
    debugger
    connection.query('DELETE FROM users WHERE UsersID = ?',
        [userId],
     (err, results, fields) => {
        debugger
        callback(err, results)
    })  
}
function checkLogin(parameters, callback) {
    const {userName, password} = parameters    
    debugger
    connection.query('SELECT * FROM users WHERE LOWER(UserName) = LOWER(?) AND Password = ?',
        [userName, password],
     (err, results, fields) => {
        debugger
        callback(err, results.length > 0)
    })  
}
module.exports = {
    getUsers,
    insertUser,
    updateUser,
    deleteUserById,
    checkLogin,
}