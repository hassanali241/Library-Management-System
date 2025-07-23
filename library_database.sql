CREATE DATABASE IF NOT EXISTS `library_database` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `library_database`;

CREATE TABLE IF NOT EXISTS books (
    book_id INT PRIMARY KEY, 
    book_name VARCHAR(100),
    book_genre VARCHAR(50),
    book_author VARCHAR(50)
);

INSERT INTO books (book_id, book_name, book_genre, book_author) VALUES
(1, 'Harry Potter', 'Sci-Fiction', 'Hassan'),
(2, 'Science', 'Sci-Fiction', 'Ron Larson'),
(3, 'Maths', 'Sci-Fiction', 'Ron Larson'),
(4, 'Discrete', 'Sci-Fiction', 'Ali'),
(5, 'Physics', 'Sci-Fiction', 'Hassan');

SELECT * FROM books;
