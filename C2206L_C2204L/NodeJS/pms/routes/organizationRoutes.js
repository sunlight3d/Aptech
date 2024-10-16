const express = require('express');
const router = express.Router();
const organizationController = require('../controllers/organizationController');

router.use('/', organizationController);

module.exports = router;
