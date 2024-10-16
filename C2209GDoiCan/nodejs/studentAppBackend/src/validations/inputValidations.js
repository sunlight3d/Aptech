const { query, body, validationResult } = require('express-validator');
const emailValidation = body('email').optional().trim().isEmail();  
const nameValidation = body('name').notEmpty();
module.exports = {
    emailValidation,
    nameValidation
};