CREATE TABLE tblAuthor(
	nickname VARCHAR(25) PRIMARY KEY,
	fullname VARCHAR(100) NOT NULL,
	birthday Date,
	address VARCHAR(200)
);
INSERT INTO tblAuthor(nickname, fullname, birthday, address) 
VALUES('longtv', 'Tran Van Long', '1997-12-30', 'hanoi');

CREATE TABLE tblBook(
	bookcode VARCHAR(12) PRIMARY KEY,
	name VARCHAR(150) NOT NULL,
	nickname VARCHAR(25) REFERENCES tblAuthor(nickname),
	producer VARCHAR(100),
	price INT
);
INSERT INTO tblBook(bookcode, name, nickname, producer, price) VALUES
('code01', 'programming in C++','longtv','producer A', 111),
('code02', 'Java book','longtv','producer B', 222),
('code03', 'C#','longtv','producer C', 333),
('code04', 'mobile programming','longtv','producer D', 444);
