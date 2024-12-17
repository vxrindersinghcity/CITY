DROP DATABASE IF EXISTS mydb;
CREATE DATABASE mydb;
USE mydb;
DROP TABLE IF EXISTS USER, LAPTOP, RENTAL_TRANSACTION, REPORT, MaintenanceLog;
/*
Student name: VARINDER SINGH               
Student ID: 240003978
Student email: Varinder.Singh@city.ac.uk             
*/


DROP DATABASE IF EXISTS mydb;
CREATE DATABASE mydb;
USE mydb;
DROP TABLE IF EXISTS USER, LAPTOP, RENTAL_TRANSACTION, REPORT, MaintenanceLog;

/* SECTION 1 - CREATE TABLE STATEMENTS */

CREATE TABLE USER (
    userID int NOT NULL PRIMARY KEY,
    first_name varchar(15) NOT NULL,
    last_name varchar(15) NOT NULL,
    numberOfrentals int
);

CREATE TABLE LAPTOP (
    laptopID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    model varchar(30) NOT NULL,
    LAPTOP_status varchar(15) NOT NULL
);

CREATE TABLE RENTAL_TRANSACTION (
    transactionID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userID int NOT NULL,
    laptopID int NOT NULL,
    rentalDate int NOT NULL,
    returnDate int,
    FOREIGN KEY (userID) REFERENCES USER(userID),
    FOREIGN KEY (laptopID) REFERENCES LAPTOP(laptopID)
);

CREATE TABLE REPORT (
    reportID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userID int NOT NULL,
    laptopID int NOT NULL,
    reportDate int NOT NULL,
    reportDescription varchar(255) NOT NULL,
    fine int,
    FOREIGN KEY (userID) REFERENCES USER(userID),
    FOREIGN KEY (laptopID) REFERENCES LAPTOP(laptopID)
);

CREATE TABLE MaintenanceLog (
    laptopID int NOT NULL,
    serviceDate int NOT NULL,
    serviceDescription varchar(100) NOT NULL,
    technicainEmail varchar(30) NOT NULL,
    PRIMARY KEY (laptopID, serviceDate),
    FOREIGN KEY (laptopID) REFERENCES LAPTOP(laptopID)
);

/* SECTION 2 - INSERT STATEMENTS */

INSERT INTO USER (userID, first_name, last_name, numberOfrentals) VALUES
(1, 'Varinder', 'Singh', 2),
(2, 'Jamie', 'Smith', 1),
(3, 'Alice', 'Johnson', 1),
(4, 'Bob', 'Crow', 3),
(5, 'Charlie', 'Miles', 4),
(6, 'David', 'Wonder', 2),
(7, 'Eva', 'Davis', 1),
(8, 'Frank', 'Garcia', 2),
(9, 'Grace', 'Martinez', 0),
(10, 'Hank', 'Martinez', 3),
(11, 'Sam', 'Frank', 0),
(12, 'Henry', 'Rose', 1);

INSERT INTO LAPTOP (model, LAPTOP_status) VALUES
('Dell Inspire 15', 'Available'),
('MacBook Pro M4', 'Rented'),
('HP Spectre x360', 'Available'),
('Asus ZenBook 13', 'Rented'),
('Lenovo ThinkPad i3', 'Available'),
('Acer Swift', 'Available'),
('Dell XPS 13', 'Rented'),
('Razer Blade 13', 'Available'),
('Google Pixelbook', 'Available'),
('Samsung Galaxy Book 4 Pro', 'Rented'),
('Alienware m15', 'Available'),
('HP Envy 13', 'Rented'),
('Apple MacBook Air', 'Available'),
('Dell Inspiron 15', 'Available'),
('Asus ROG Zephyrus', 'Rented');

INSERT INTO RENTAL_TRANSACTION (userID, laptopID, rentalDate, returnDate) VALUES
(1, 2, 230101, 230103),
(1, 4, 230301, 230315),
(2, 10, 230105, 230112),
(3, 11, 230107, NULL),   
(4, 15, 230109, 230110),
(4, 6, 230201, 230211),
(4, 8, 230115, 230123),
(5, 9, 230115, 230124),
(5, 5, 230117, 230125),
(5, 10, 230119, NULL),   
(5, 7, 230130, 230205),
(6, 12, 240215, 240220), 
(6, 3, 240222, NULL),    
(7, 13, 240310, 240317), 
(8, 14, 240401, 240407), 
(8, 4, 240410, 240415),  
(10, 1, 240501, 240505), 
(10, 3, 240510, 240517), 
(10, 5, 240520, 240525), 
(12, 2, 240601, 240605);

INSERT INTO REPORT (userID, laptopID, reportDate, reportDescription, fine) VALUES
(1, 2, 230111, 'Screen issue', 50),
(2, 4, 230316, 'Battery problem', 30), 
(3, 11, 230114, 'Keyboard issue', 40),   
(4, 15, 230111, 'Touchpad not working', 20),  
(5, 9, 230126, 'Software crash', 0),     
(6, 12, 240221, 'Overheating', 0),        
(7, 13, 240318, 'Slow performance', 45),  
(8, 14, 240408, 'WiFi issue', 15),        
(9, 5, 230128, 'Speaker problem', 20),   
(10, 10, 240530, 'Charging issue', 0),    
(11, 11, 230208, 'LOST', 1000);        

INSERT INTO MaintenanceLog (laptopID, serviceDate, serviceDescription, technicainEmail) VALUES
(2, 230111, 'Screen replacement', 'john.doe@city.it.uk'),
(4, 230316, 'Battery replacement', 'jane.smith@city.it.uk'),  
(7, 230114, 'Keyboard replacement', 'michael.johnson@city.it.uk'),  
(3, 230111, 'Touchpad repair', 'emily.davis@city.it.uk'),     
(1, 230126, 'Software reinstall', 'john.doe@city.it.uk'),     
(6, 240221, 'Cooling system check', 'jane.smith@city.it.uk'),   
(8, 240408, 'Performance optimization', 'michael.johnson@city.it.uk'),   
(9, 230128, 'WiFi adapter replacement', 'emily.davis@city.it.uk'),  
(5, 230128, 'Speaker replacement', 'john.doe@city.it.uk');    



/* SECTION 3 - UPDATE STATEMENTS - The queries must be explained in natural (English) language first, and then followed up by respective statements */

/*
1)

*/

/*
2)

*/

/* SECTION 4 - SELECT STATEMENTS - The queries must be explained in natural (English) language first, and then followed up by respective SELECTs*/

/* 
1)  

*/

/* 
2)  

*/

/* 
3)  

*/

/* 
4)  

*/

/* 
5)  

*/

/* 
6)  

*/

/* 
7)  

*/

/* 
8)  

*/

/* SECTION 5 - DELETE ROWS - The queries must be explained in natural (English) language first, and then followed up by respective statements */

/*
1)

*/

/*
2)

*/

/* SECTION 6 - DROP TABLES */
