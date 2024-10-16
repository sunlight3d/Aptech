CREATE TABLE IF NOT EXISTS abc12users (
    username VARCHAR(100),
    password_hash CHAR(40),
    phone VARCHAR(10) UNIQUE
);
INSERT INTO abc12users(username, password_hash, phone) VALUES
('hoangnd', '123456', '112233'),
('minhnc', 'sdewew', '9898989'),
('jonny', 'sdsdesds', '878787');