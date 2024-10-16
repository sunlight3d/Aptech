DROP DATABASE a2209idoican;
CREATE DATABASE a2209idoican;

USE a2209idoican;
CREATE TABLE Category (
    Id INT PRIMARY KEY IDENTITY(1, 1),
    Name NVARCHAR(255) NOT NULL
);

CREATE TABLE Post (
    Id INT PRIMARY KEY IDENTITY(1, 1),
    Title NVARCHAR(255) NOT NULL CHECK (LEN(Title) >= 5),
    Content NVARCHAR(MAX),
    Author NVARCHAR(100) NOT NULL,
    PublishedDate DATETIME NOT NULL,
    CategoryId INT NOT NULL,
    FOREIGN KEY (CategoryId) REFERENCES Category(Id)
);

INSERT INTO Category (Name)
VALUES
('Movie Reviews'),
('Adventure and Travel'),
('Technology and Coding'),
('Home and Garden'),
('Historical Insights');

INSERT INTO Post (Title, Content, Author, PublishedDate, CategoryId)
VALUES
('When Harry Met Sally', 'This is a detailed review of the classic movie When Harry Met Sally.', 'John Doe', DATEADD(DAY, -ABS(CHECKSUM(NEWID()) % 365), GETDATE()), 1),
('Exploring the Mountains', 'A journey through the mountains can be exhilarating and life-changing.', 'Jane Doe', DATEADD(DAY, -ABS(CHECKSUM(NEWID()) % 365), GETDATE()), 2),
('The Art of Coding', 'Coding is not just a skill, it''s an art. Here''s why.', 'Emily Clark', DATEADD(DAY, -ABS(CHECKSUM(NEWID()) % 365), GETDATE()), 3),
('Gardening 101', 'Beginners guide to getting your hands dirty and your garden green.', 'Michael Bay', DATEADD(DAY, -ABS(CHECKSUM(NEWID()) % 365), GETDATE()), 4),
('Mysteries of the Egyptian Pyramids', 'Explore the theories behind the construction of the Egyptian Pyramids.', 'Sarah Connor', DATEADD(DAY, -ABS(CHECKSUM(NEWID()) % 365), GETDATE()), 5),
('How to Bake a Cake', 'Step by step guide on baking a delicious cake.', 'John Smith', DATEADD(DAY, -ABS(CHECKSUM(NEWID()) % 365), GETDATE()), 1),
('The History of the Internet', 'A brief history about how the Internet was born and evolved over the years.', 'Laura Palmer', DATEADD(DAY, -ABS(CHECKSUM(NEWID()) % 365), GETDATE()), 2),
('What is Artificial Intelligence?', 'Understanding AI and its implications in today''s world.', 'Tony Stark', DATEADD(DAY, -ABS(CHECKSUM(NEWID()) % 365), GETDATE()), 3),
('The Rise of Electric Vehicles', 'Exploring how electric vehicles are changing the automotive industry.', 'Bruce Wayne', DATEADD(DAY, -ABS(CHECKSUM(NEWID()) % 365), GETDATE()), 4),
('The Importance of Mental Health', 'Why taking care of your mental health is as important as physical health.', 'Diana Prince', DATEADD(DAY, -ABS(CHECKSUM(NEWID()) % 365), GETDATE()), 5);
