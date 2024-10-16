const express = require('express')
const router = express.Router()
const {
  getUsers,
  insertUser, 
  updateUser,
  deleteUserById,
  checkLogin
} = require('../controllers/user.js')

router.get('/', async (req, res) => {
  debugger  
  getUsers((err, result) => {
    debugger
    if (err) throw err
    res.json(result)  
  })
})
router.post("/", async (req, res) => {
  debugger;
  insertUser(req.body, (err, result) => {
    debugger;
    if (err) throw err;
    res.json(result);
  });
});
router.post("/checkLogin", async (req, res) => {
    debugger;
    checkLogin(req.body, (err, result) => {
      debugger;
      if (err) throw err;
      res.json(result);
    });
  });
router.put("/:id", async (req, res) => {
  const { id } = req.params;
  updateUser(id, req.body, (err, result) => {
    debugger;
    if (err) throw err;
    res.json(result);
  });
});
router.delete("/:id", async (req, res) => {
  const { id } = req.params;
  deleteUserById(id, (err, results) => {
    debugger;
    if (err) throw err;
    res.json(results);
  });
});
module.exports = router