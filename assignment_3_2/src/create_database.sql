DROP DATABASE Customer_database;

CREATE DATABASE Customer_database;
USE Customer_database;
CREATE TABLE customer_details (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    contact_no VARCHAR(255) NOT NULL,
    gender ENUM('male','female') NOT NULL,
    email VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL
);
