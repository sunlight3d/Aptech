const mysql = require('mysql2/promise');

async function getConnection() {
    try {
        const connection = await mysql.createConnection({
            host: 'localhost',
            user: 'root',
            port: 3307,
            database: 'c2209gdoican',
            password: 'Abc123456789@'
        });
        return connection;
    } catch (error) {
        console.error('Error establishing database connection:', error);
        throw new Error('Failed to connect to the database');
    }
}
module.exports = getConnection;