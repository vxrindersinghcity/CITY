DROP DATABASE test_database;
CREATE DATABASE test_database;
USE test_database;
CREATE TABLE Users (
ID int NOT NULL AUTO_INCREMENT,
name varchar(255) NOT NULL,
email varchar(255) NOT NULL,
PRIMARY KEY (ID)
);
INSERT INTO Users (name, email) VALUES
('Vitaly', 'vitaly.aksenov@city.ac.uk'),
('Cristina', 'cristina.gacek.1@city.ac.uk'),
('Golnaz', 'golnaz.badkobeh@city.ac.uk');
SELECT * FROM Users;
CREATE TABLE Phones (
ID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
User_ID int,
phone varchar(255) NOT NULL,
FOREIGN KEY (User_ID) REFERENCES Users(ID)
);
INSERT INTO Phones(User_ID, phone) VALUES
(1, '+447777777777'),
(2, '+447777777778'),
(2, '+447777777779');
SELECT * FROM Phones;
SELECT Users.name as name, Phones.phone as phone FROM Users INNER JOIN Phones
on Users.ID = Phones.User_ID;