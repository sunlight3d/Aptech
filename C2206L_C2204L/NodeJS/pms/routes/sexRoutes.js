const express = require('express');
const router = express.Router();
const sexController = require('../controllers/sexController');

router.use('/', sexController);

module.exports = router;
