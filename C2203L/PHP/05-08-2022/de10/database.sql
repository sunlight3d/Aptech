CREATE DATABASE abc12;
USE abc12;
CREATE TABLE IF NOT EXISTS abc12users(    
    username VARCHAR(100) UNIQUE,
    password_hash VARCHAR(100),
    phone VARCHAR(10)  
);
