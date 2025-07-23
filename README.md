Library Management System

This is a simple Java-based Library Management System with a graphical user interface (GUI) built using Swing and a MySQL database for data persistence. It allows users to manage books in a library, including viewing, adding, deleting, and updating book records.

Features
User Authentication: Secure login page to access the system.

View Books: Display all books currently in the database.

Add Book: Add new book records with ID, title, genre, and author.

Delete Book: Remove existing book records by ID.

Update Book: Modify details of an existing book record by ID.

Technologies Used
Java Swing: For the graphical user interface.

JDBC (Java Database Connectivity): To connect to the MySQL database.

MySQL: Relational database to store book information.

Setup Instructions
To get this project up and running, follow these steps:

1. Database Setup
First, you need to set up the MySQL database.

Install MySQL: If you don't have MySQL installed, download and install it from the official MySQL website.

Create Database and Table:

Open your MySQL client (e.g., MySQL Workbench, command-line client).

Execute the SQL script provided in library_database.sql to create the library_database and the books table, and populate it with some initial data.

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

Database Credentials:

Ensure your MySQL server is running.

The DatabaseConnection.java file uses the following default credentials:

url = "jdbc:mysql://localhost:3306/library_database"

user = "root"

password = "12345"

If your MySQL setup has different credentials, update these values in DatabaseConnection.java accordingly.

2. Java Project Setup
IDE: Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans).

JDBC Driver: You need to add the MySQL JDBC driver to your project's classpath.

Download the MySQL Connector/J (JDBC driver) from the MySQL website.

Add the downloaded .jar file to your project's build path (e.g., in IntelliJ, go to File -> Project Structure -> Libraries -> + -> Java and select the .jar file).

3. Project Structure
.
├── src/
│   ├── main.java
│   ├── loginpage.java
│   ├── library.java
│   ├── DatabaseConnection.java
│   ├── AddBook.java
│   ├── DelBook.java
│   └── updateBook.java
└── library_database.sql

main.java: The entry point of the application, which initiates the login page.

loginpage.java: Handles user authentication.

library.java: The main menu of the library system, providing navigation to other functionalities.

DatabaseConnection.java: Manages the connection to the MySQL database and contains methods for CRUD (Create, Read, Update, Delete) operations on book records.

AddBook.java: GUI for adding new books to the database.

DelBook.java: GUI for deleting books from the database.

updateBook.java: GUI for updating existing book details in the database.

library_database.sql: SQL script to set up the database and table.

4. Running the Application
Compile and Run: Run the main.java file from your IDE.

Login: A login window will appear. Use the following credentials:

User ID: hassan

Password: 123

Navigate: After successful login, the main menu will appear, allowing you to access various library management functions.

Usage
View Books: Click the "View Books" button to see a list of all books in the database.

Add Book: Click "Add Book," fill in the details (ID, Title, Genre, Author), and click "Add."

Delete Book: Click "Delete Book," enter the ID of the book you want to delete, and click "Delete."

Update Book: Click "Update Book," enter the ID of the book to update, provide the new details, and click "Update."

Contributing
Feel free to fork this repository and contribute by submitting pull requests.

License
This project is open-source and available under the MIT License.
