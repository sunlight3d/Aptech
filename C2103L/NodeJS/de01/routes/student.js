
const express = require('express')
const router = express.Router()
const connection = require('../connection')

router.get('/', async (req, res) => {
  connection.query('SELECT * FROM student', (err, results, fields) => {
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
    'SELECT * FROM student WHERE id = ?',
    [id], 
    (err, results, fields) => {
      debugger
      if (err) throw err
      res.json({
        status: 'success',
        count: results.length,
        data: results.length > 0 ? results[0] : {},
        message: 'Find student details successfully'
      })  
    })
})
router.post('/', async (req, res) => {
  const {name, age, address, javaScore,csharpScore} = req.body
  debugger
  const sql = 'INSERT INTO student(name, age, address, javaScore,csharpScore) VALUES (?,?,?,?,?)'
  const values = [name, age, address, javaScore,csharpScore]  
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
      'SELECT * FROM student WHERE id = ? LIMIT 1',
      [result.insertId], 
      (err, results, fields) => {
        debugger
        if (err) throw err
        res.json(results.length > 0 ? results[0] : {})  
      })
    
  })
  
})
router.put('/:id', async (req, res) => {
  const {id} = req.params
  const {name, age, address, javaScore,csharpScore} = req.body
  const updates = {}
  if (name !== undefined) updates.name = name
  if (age !== undefined) updates.age = age
  if (address !== undefined) updates.address = address
  if (javaScore !== undefined) updates.javaScore = javaScore
  if (csharpScore !== undefined) updates.csharpScore = csharpScore

  if (Object.keys(updates).length === 0) {
    res.status(400).json({ error: 'No fields to update' })
    return
  }

  let sql = 'UPDATE student SET '              
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
      'SELECT * FROM student WHERE id = ? LIMIT 1',
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
  const sql = 'DELETE FROM student WHERE id = ?'
  const values = [req.params.id]  
  connection.execute(sql, values, (err, result) => {
    debugger
    if (err) throw err    
    res.json({
      message: 'Delete student successfully'
    })    
  })
})
module.exports = router