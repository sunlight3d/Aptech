CREATE TABLE products (
    Id INT IDENTITY(1,1) PRIMARY KEY, -- Auto-increment identity column
    Name NVARCHAR(100) NOT NULL, -- Required and between 3 to 100 characters
    Description NVARCHAR(500), -- Optional with a max length of 500 characters
    Price DECIMAL(18, 2) NOT NULL -- Required with a range constraint (but note that SQL doesn't enforce a range constraint directly)
);
