
const express = require('express')
const router = express.Router()
const connection = require('../connection')

router.get('/', async (req, res) => {
  debugger
  connection.query('SELECT * FROM employees', (err, results, fields) => {
    debugger
    if (err) throw err
    res.json({
      status: 'success',
      data: results
    })  
  })  
})
router.get('/:id', async (req, res) => {
  const id = req.params?.id ?? ''
  connection.query(
    'SELECT * FROM employees WHERE id = ?',
    [id], 
    (err, results, fields) => {
      debugger
      if (err) throw err
      res.json({
        status: 'success',
        count: results.length,
        data: results.length > 0 ? results[0] : {},
        message: 'Find employees details successfully'
      })  
    })
})

router.post('/', async (req, res) => {
  debugger
  const {Name, Age, Address, Salary} = req.body
  debugger
  const sql = 'INSERT INTO employees(Name, Age, Address, Salary) VALUES (?,?,?, ?)'
  const values = [Name, Age, Address, Salary]  
  connection.execute(sql, values, (err, result) => {
    debugger
    if (err) {
      res.status(500).json({
        status: 'error',
        errorCode : err.errno,
        message: err.message
      })
      return
    }   
    connection.query(
      'SELECT * FROM employees WHERE id = ? LIMIT 1',
      [result.insertId], 
      (err, results, fields) => {
        debugger
        if (err) throw err
        res.json(results.length > 0 ? results[0] : {})  
      })
    
  })
  
})
router.put('/:id', async (req, res) => {
  debugger
  const {id} = req.params
  const {Name,Age,Address, Salary} = req.body
  const updates = {}
  if (Name !== undefined) updates.Name = Name
  if (Age !== undefined) updates.Age = Age
  if (Address !== undefined) updates.Address = Address
  if (Salary !== undefined) updates.Salary = Salary  

  if (Object.keys(updates).length === 0) {
    res.status(400).json({ error: 'No fields to update' })
    return
  }

  let sql = 'UPDATE employees SET '              
  const values = []  
  Object.keys(updates).forEach((key, index) => {
    sql += `${key} = ?, `
    values.push(updates[key])
  })
  sql = sql.slice(0, -2)  
  sql += ' WHERE id = ?'
  values.push(id)

  connection.execute(sql, values, (err, result) => {
    debugger
    if (err) throw err    
    connection.query(
      'SELECT * FROM employees WHERE id = ? LIMIT 1',
      [id], 
      (err, results, fields) => {
        debugger
        if (err) throw err
        res.json(results.length > 0 ? results[0] : {})  
      })
  })
})
router.delete('/:id', async (req, res) => {
  const {name, age, address, javaScore,csharpScore} = req.body
  const sql = 'DELETE FROM employees WHERE id = ?'
  const values = [req.params.id]  
  connection.execute(sql, values, (err, result) => {
    debugger
    if (err) throw err    
    res.json({
      message: 'Delete employees successfully'
    })    
  })
})
module.exports = router