CREATE TABLE Genre(
	GenreId INT PRIMARY KEY IDENTITY(1,1),
	GenreName NVARCHAR(500)
);
CREATE TABLE Movie(
	MovieId INT PRIMARY KEY IDENTITY(1,1),
	Title NVARCHAR(200),
	ReleaseDate DATE,
	RunningTime INT DEFAULT 0,
	GenreId INT FOREIGN KEY REFERENCES Genre(GenreId),
	BoxOffice FLOAT DEFAULT 0.0
);

INSERT INTO Genre(GenreName)
VALUES(N'Drama'),(N'Roman'), (N'Action'), (N'Comedy');
SELECT * FROM Genre;

DELETE FROM Movie WHERE 1=1;
INSERT INTO Movie(Title, ReleaseDate, RunningTime, GenreId, BoxOffice)
VALUES
('Captain Marvel','2019-02-01', 100,3, 3.3),
('Captain Marvel','2019-02-01', 100,3, 3.3),
('Captain Marvel','2019-02-01', 100,3, 3.3),
('Captain Marvel','2019-02-01', 100,3, 3.3),
('Captain Marvel','2019-02-01', 100,3, 3.3),
('Captain Marvel','2019-02-01', 100,3, 3.3);