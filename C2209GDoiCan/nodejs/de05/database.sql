CREATE DATABASE c2209gdoican;
USE c2209gdoican;
CREATE TABLE movies(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    year INT NOT NULL,
    time TINYINT,
    release_date DATETIME,
    country VARCHAR(20)
);

CREATE TABLE actors(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    gender VARCHAR(10)
);

CREATE TABLE movie_casts(
    id INT PRIMARY KEY AUTO_INCREMENT,
    actor_id INT,
    movie_id INT,
    role VARCHAR(100)
);

--constraints
ALTER TABLE movie_casts ADD CONSTRAINT FK_MovieCastActor 
FOREIGN KEY (actor_id) REFERENCES actors(id);

ALTER TABLE movie_casts ADD CONSTRAINT FK_MovieCastMovie
FOREIGN KEY (movie_id) REFERENCES movies(id);

ALTER TABLE movies ADD CONSTRAINT unique_title UNIQUE (title);

ALTER TABLE movie_casts ADD CONSTRAINT unique_movie_casts UNIQUE (actor_id, movie_id, role);
