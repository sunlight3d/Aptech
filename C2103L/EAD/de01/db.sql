CREATE TABLE companies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    company_key VARCHAR(50) NOT NULL,
    description VARCHAR(100),
    address VARCHAR(100) NOT NULL,
    enabled BOOLEAN
);

INSERT INTO companies (name, company_key, description, address, enabled)
VALUES
    ('Company 1', 'key1', 'Description 1', 'Address 1', 1),
    ('Company 2', 'key2', 'Description 2', 'Address 2', 0),
    ('Company 3', 'key3', 'Description 3', 'Address 3', 1),
    ('Company 4', 'key4', 'Description 4', 'Address 4', 0),
    ('Company 5', 'key5', 'Description 5', 'Address 5', 1),
    ('Company 6', 'key6', 'Description 6', 'Address 6', 1),
    ('Company 7', 'key7', 'Description 7', 'Address 7', 0),
    ('Company 8', 'key8', 'Description 8', 'Address 8', 1),
    ('Company 9', 'key9', 'Description 9', 'Address 9', 0),
    ('Company 10', 'key10', 'Description 10', 'Address 10', 1);

