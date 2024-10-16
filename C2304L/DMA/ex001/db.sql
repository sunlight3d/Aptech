IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'c2304l')
BEGIN
    CREATE DATABASE c2304l;
END;
USE c2304l;
CREATE TABLE users (
    id INT IDENTITY(1,1) PRIMARY KEY, -- Auto-increment identity column
    email NVARCHAR(255) NOT NULL, -- Required, and should store email strings
    full_name NVARCHAR(255) NOT NULL, -- Required, at least 5 characters long
    password NVARCHAR(255) NOT NULL -- Store the hashed password
);

CREATE TABLE products (
    id INT IDENTITY(1,1) PRIMARY KEY, -- Auto-increment identity column
    name NVARCHAR(100) NOT NULL, -- Required, with a maximum of 100 characters
    description NVARCHAR(500), -- Optional, with a maximum of 500 characters
    price DECIMAL(18, 2) NOT NULL -- Required, with a price range from 0.01 to 10,000
);
