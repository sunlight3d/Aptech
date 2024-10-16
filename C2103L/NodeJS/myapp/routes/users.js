const express = require('express');
const router = express.Router();

router.get('/', function(req, res) {
    res.send('Get all users');
});

router.get('/:id', function(req, res) {
    const userId = req.params.id;
    res.send(`Get user with haha ID = ${userId}`);    
});

router.post('/', function(req, res) {
    res.send('Create a new user');
});

router.put('/:id', function(req, res) {
    const userId = req.params.id;
    res.send(`Update user with ID ${userId}`);
});

router.delete('/:id', function(req, res) {
    const userId = req.params.id;
    res.send(`Delete user with ID ${userId}`);
});

module.exports = router;