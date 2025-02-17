
/*
Student name: VARINDER SINGH               
Student ID: 240003978         
*/

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
    reportDescription varchar(100) NOT NULL,
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

INSERT INTO USER VALUES
(1, 'Varinder', 'Singh', NULL), 
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
(5, 9, 230126, 'Software crash', NULL),     
(6, 12, 240221, 'Overheating', 0),        
(7, 13, 240318, 'Slow performance', 45),  
(8, 14, 240408, 'WiFi issue', 15),        
(9, 5, 230128, 'Speaker problem', 20),   
(10, 10, 240530, 'Charging issue', 0),    
(11, 11, 230208, 'LOST', 1000);        

INSERT INTO MaintenanceLog (laptopID, serviceDate, serviceDescription, technicainEmail) VALUES
(2, 230111, 'Screen replacement', 'jaime.sith@city.it.uk'),
(4, 230316, 'Battery replacement', 'arun.dsouza@city.it.uk'),  
(7, 230114, 'Keyboard replacement', 'michael.cole@city.it.uk'),  
(3, 230111, 'Touchpad repair', 'emily.wattson@city.it.uk'),     
(1, 230126, 'Software reinstall', 'arun.dsouza@city.it.uk'),     
(6, 240221, 'Cooling system check','michael.cole@city.it.uk' ),   
(8, 240408, 'Performance optimization','michael.cole@city.it.uk' ),   
(9, 230128, 'WiFi adapter replacement', 'jaime.sith@city.it.uk'), 
(4, 220123, 'Liquid removal', 'jackline.smath@city.ac.uk') ,
(5, 230128, 'Speaker replacement', 'emily.wattson@city.it.uk');    



/* SECTION 3 - UPDATE STATEMENTS - The queries must be explained in natural (English) language first, and then followed up by respective statements */

/* 
1) Update the number of rentals for a user based on the count of their rental transactions 
*/ 
UPDATE USER SET numberOfrentals = (SELECT COUNT(*) FROM RENTAL_TRANSACTION WHERE USER.userID = RENTAL_TRANSACTION.userID) WHERE userID = 1;

/*
2) Updates the status to rented for the laptop in laptop table depending on rental transaction table if the return value is null which means laptop is still rented
*/
UPDATE LAPTOP 
SET LAPTOP_status = 'Rented' 
WHERE laptopID IN 
(SELECT laptopID FROM RENTAL_TRANSACTION WHERE returnDate IS NULL);


/* SECTION 4 - SELECT STATEMENTS - The queries must be explained in natural (English) language first, and then followed up by respective SELECTs*/


/* 
1) Showas all users that have a surname starting with s
*/
select '1)' AS '';
SELECT userID, first_name, last_name FROM USER WHERE last_name LIKE 'S%';


/* 
2)  finds the total fine the user has got from largest to smallest
*/
select '2)' AS '';
SELECT u.userID, u.first_name, u.last_name, SUM(r.fine) AS total_fine
FROM USER u
JOIN REPORT r ON u.userID = r.userID
GROUP BY u.userID, u.first_name, u.last_name ORDER BY total_fine DESC;




/* 
3) Finds all rental transactions with user and laptop details
*/
select '3)' AS '';
SELECT r.transactionID, u.first_name, u.last_name, l.model, r.rentalDate, r.returnDate
FROM RENTAL_TRANSACTION r
JOIN USER u ON r.userID = u.userID
JOIN LAPTOP l ON r.laptopID = l.laptopID;



/* 
4)  List all users who have not rented any laptops
*/
select '4)' AS '';
SELECT u.userID, u.first_name, u.last_name 
FROM USER u WHERE NOT EXISTS ( SELECT 1 FROM RENTAL_TRANSACTION rt WHERE u.userID = rt.userID);



/* 
5)  Find users who have rented laptops and also reported issues
*/
select '5)' AS '';
SELECT DISTINCT u.userID, u.first_name, u.last_name 
FROM USER u 
JOIN RENTAL_TRANSACTION rt ON u.userID = rt.userID
JOIN REPORT r ON u.userID =r.userID;


/* 
6)  List all laptops that have never been reported with any issues
*/
select '6)' AS '';
SELECT l.laptopID, l.model 
FROM LAPTOP l 
LEFT JOIN REPORT r ON l.laptopID = r.laptopID 
WHERE r.laptopID IS NULL;

/* 
7)  Count the total number of rentals per user and display users who have rented more than twice
*/
select '7)' AS '';
SELECT u.userID, u.first_name, u.last_name, COUNT(rt.transactionID) AS rental_count
 FROM USER u 
 JOIN RENTAL_TRANSACTION rt ON u.userID = rt.userID 
 GROUP BY u.userID, u.first_name, u.last_name HAVING rental_count > 2;


/* 
8)  Show the total number of laptops that are currently rented and available
*/
select '8)' AS '';
SELECT LAPTOP_status, COUNT(*) AS total_laptops FROM LAPTOP GROUP BY LAPTOP_status;


/* SECTION 5 - DELETE ROWS - The queries must be explained in natural (English) language first, and then followed up by respective statements */

/*
1) Deletes all laptops that are damaged
*/
DELETE FROM LAPTOP
WHERE LAPTOP_status = 'Damaged';


/*
2) Deletes all reports with a fine of NULL
*/
DELETE FROM REPORT
WHERE fine IS NULL;



/* SECTION 6 - DROP TABLES */
DROP TABLE IF EXISTS MaintenanceLog;
DROP TABLE IF EXISTS REPORT;
DROP TABLE IF EXISTS RENTAL_TRANSACTION;
DROP TABLE IF EXISTS LAPTOP;
DROP TABLE IF EXISTS USER;


SHOW TABLES;