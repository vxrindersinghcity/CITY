
/*
Student name: VARINDER SINGH               
Student ID: 240003978
Student email: Varinder.Singh@city.ac.uk             
*/


/* SECTION 1 - CREATE TABLE STATEMENTS */

CREATE TABLE USER (
    userID int NOT NULL,
    first_name varchar NOT NULL,
    last_name varchar NOT NULL,
    numberOfrentals int,
    PRIMARY KEY (userID)
);

CREATE TABLE LAPTOP (
    laptopID int NOT NULL AUTO_INCREMENT,
    model varchar NOT NULL,
    status varchar NOT NULL,
    PRIMARY KEY (laptopID)
);

CREATE TABLE RENTAL_TRANSACTION (
    transactionID int NOT NULL AUTO_INCREMENT,
    userID int NOT NULL,
    laptopID int NOT NULL,
    rentalDate int NOT NULL,
    returnDate int,
    PRIMARY KEY (transactionID),
    FOREIGN KEY (userID) REFERENCES USER(userID),
    FOREIGN KEY (laptopID) REFERENCES LAPTOP(laptopID)
);

CREATE TABLE REPORT (
    reportID int NOT NULL AUTO_INCREMENT,
    USERuserID int NOT NULL,
    LAPTOPlaptopID int NOT NULL,
    reportDate int NOT NULL,
    reportDescription varchar(255) NOT NULL,
    fine int,
    PRIMARY KEY (reportID),
    FOREIGN KEY (userID) REFERENCES USER(userID),
    FOREIGN KEY (laptopID) REFERENCES LAPTOP(laptopID)
);


CREATE TABLE MaintenanceLog (
    laptopID int NOT NULL,
    serviceDate int NOT NULL,
    serviceDescription varchar NOT NULL,
    technicainEmail varchar NOT NULL,
    PRIMARY KEY (laptopID,serviceDate),
    FOREIGN KEY (laptopID) REFERENCES LAPTOP(laptopID)
);

/* SECTION 2 - INSERT STATEMENTS */

INSERT INTO USER (userID, first_name, last_name, numberOfrentals) VALUES
(23098,'Varinder', 'Singh', 2),
(24356,'Jamie', 'Smith', 1),
(95693,'Alice', 'Johnson', 1),
(73599,'Bob', 'Crow', 3),
(83478,'Charlie', 'Miles', 4),
(79456,'David', 'Wonder', 2),
(22445,'Eva', 'Davis', 1),
(97454,'Frank', 'Garcia', 2),
(74323,'Grace', 'Martinez', 0),
(93568,'Hank', 'Rodriguez', 3)
(02875,'Sam','Frank',0),
(86746,'Henry','Rose',1);



INSERT INTO LAPTOP (model, status) VALUES
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
(23098, 2, 230101, 230103),
(23098, 4, 230303, 230315),
(24356, 10, 230105, 230112),
(95693, 11, 230107, NULL),
(73599, 15, 230109, 230110),
(73599, 6, 230211, 230221),
(73599, 8, 230115, 230123),
(83478, 9, 230115, 230124),
(83478, 5, 230117, NULL),
(83478, 10, 230119, 230129);

INSERT INTO REPORT (userID,laptopID, reportDate, reportDescription, fine) VALUES
(1, 2, 20230111, 'Screen issue', 50),
(2, 4, 20230116, 'Battery problem', 30),
(3, 7, 20230113, 'Keyboard issue', 40),
(4, 3, 20230108, 'Touchpad not working', 20),
(5, 1, 20230121, 'Software crash', 25),
(6, 6, 20230122, 'Overheating', 35),
(7, 8, 20230124, 'Slow performance', 45),
(8, 9, 20230125, 'WiFi issue', 15),
(9, 5, 20230127, 'Speaker problem', 20),
(10, 10, 20230130, 'Charging issue', 50);

INSERT INTO MaintenanceLog (laptopID, serviceDate, serviceDescription, technicainEmail) VALUES
(2, 20230111, 'Screen replacement', 'tech1@example.com'),
(4, 20230116, 'Battery replacement', 'tech2@example.com'),
(7, 20230113, 'Keyboard replacement', 'tech3@example.com'),
(3, 20230108, 'Touchpad repair', 'tech4@example.com'),
(1, 20230121, 'Software reinstall', 'tech5@example.com'),
(6, 20230122, 'Cooling system check', 'tech6@example.com'),
(8, 20230124, 'Performance optimization', 'tech7@example.com'),
(9, 20230125, 'WiFi adapter replacement', 'tech8@example.com'),
(5, 20230127, 'Speaker replacement', 'tech9@example.com');

                     
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

DROP DATABASE IF EXISTS mydb;
CREATE DATABASE mydb;
USE mydb;
DROP TABLE IF EXISTS USER, LAPTOP, RENTAL_TRANSACTION, REPORT, MaintenanceLog;


DESC RENTAL_TRANSACTION;
