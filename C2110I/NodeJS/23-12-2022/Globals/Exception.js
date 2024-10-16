export default class Exception extends Error {    
    static DATABASE_ACCESS = "Cannot access to database"
    static WRONG_EMAIL_OR_PASSWORD = 'Wrong email or password'
    constructor(message) {
        super(message)        
    }
}