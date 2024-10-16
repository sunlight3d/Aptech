const express = require('express');
const router = express.Router();
const employeeController = require('../controllers/employeeController');

router.use('/', employeeController);

module.exports = router;
