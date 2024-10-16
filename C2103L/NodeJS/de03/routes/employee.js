const express = require('express')
const router = express.Router()
const {
  getEmployees,
  insertEmployee,
  getEmployeeById,
  deleteEmployeeById,
  updateEmployee,
  searchEmployees,
} = require('../controllers/employee.js')

router.get('/', async (req, res) => {
  debugger  
  getEmployees((err, result) => {
    debugger
    if (err) throw err
    res.json(result)  
  })
})
router.get('/search', async (req, res) => {
  debugger  
  const searchText = req.query?.searchText ?? ''
  //const {searchText = ""} = req.params;
  searchEmployees(searchText, (err, results) => {
    debugger
    if (err) throw err
    res.json(results)  
  })
})
router.get('/:id', async (req, res) => {
  const id = req.params?.id ?? ''  
  getEmployeeById(id, (err, results) => {
    debugger
    if (err) throw err
    res.json(results.length > 0 ? results[0] : {})  
  })      
})

router.post('/', async (req, res) => {  
  debugger  
  insertEmployee(req.body, (err, result) => {
    debugger
    if (err) throw err
    res.json(result)  
  })      
})
router.put('/:id', async (req, res) => {
  const {id} = req.params  
  updateEmployee(id, req.body, (err, result) => {
    debugger
    if (err) throw err
    res.json(result)  
  })         
})
router.delete('/:id', async (req, res) => {
  const {id} = req.params
  deleteEmployeeById(id, (err, results) => {
    debugger
    if (err) throw err
    res.json(results)  
  })      
})
module.exports = router