const express = require('express');
const router = express.Router();
const positionController = require('../controllers/positionController');

router.use('/', positionController);

module.exports = router;
