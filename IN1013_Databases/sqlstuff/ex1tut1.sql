DROP DATABASE IF EXISTS minizoo_database;
CREATE DATABASE minizoo_database;
USE minizoo_database;

DROP TABLE IF EXISTS minizooCare_Role, minizooKeeper, minizooAnimal;

CREATE TABLE minizooAnimal (ID VARCHAR(6), Name VARCHAR(10), Species VARCHAR(20),
Age SMALLINT, Gender VARCHAR(1), Weight SMALLINT, F_ID VARCHAR(6), M_ID VARCHAR(6));

CREATE TABLE minizooKeeper (Staff_ID VARCHAR(6), Keeper_Name VARCHAR(20));

CREATE TABLE minizooCare_Role (ID VARCHAR(6), Staff_ID VARCHAR(6), Role VARCHAR(10)
);

INSERT INTO minizooAnimal VALUES 
    ('11', 'Horace', 'Marmoset', 99, 'M', 5, NULL,NULL),  
    ('12', 'Lisa', 'Marmoset', 37, 'F', 3, NULL,NULL),
    ('13', 'Andrew', 'Marmoset', 42, 'M', 3, '13','11'),
    ('14', 'Anna', 'Marmoset', 12, 'F', 3, '13','11'),
    ('15', 'Paul', 'Marmoset', 12, 'M', 3, '13','11'),
    ('16', 'Fred', 'Marmoset', 6, 'M', 3, '14','11'),
    ('17', 'Mary', 'Marmoset', 3, 'F', 3, '13','16'),
    ('18', 'Julia', 'Marmoset', 5, 'F', 3, '16','12'),
    ('19', 'Stephen', 'Marmoset', 5, 'M', 3, '17','16'),
    ('20', 'Ernie', 'Marmoset', 5, 'M', 3, '13','12'),
    ('21', 'Philip', 'Marmoset', 5, 'M', 3, '16','19'),
    ('31', 'Luke', 'Giraffe', 99, 'M', 5, NULL,NULL),
    ('32', 'Bella', 'Giraffe', 37, 'F', 3, NULL,NULL),
    ('33', 'Henry', 'Giraffe', 42, 'M', 3, '33','31'), 
    ('34', 'Sarah', 'Giraffe', 12, 'F', 3, '33','31'),
    ('35', 'Mark', 'Giraffe', 12, 'M', 3, '33','31'),
    ('36', 'Frank', 'Lion', 6, 'M', 3, NULL,NULL),
    ('37', 'Nina', 'Lion', 3, 'F', 3, NULL,NULL),
    ('38', 'Jane', 'Lion', 5, '', 3, '37','36'),
    ('39', 'Kingsly', 'Lion', 9, 'M', 3, '37','36'),
    ('40', 'Eric', 'Lion', 11, 'M', 3, '38','39'),
    ('41', 'Victor', 'Lion', 2, 'M', 3, '38','36'),
    ('61', 'Sabrina', 'Elephant', 6, 'F', 225, '70','71'),
    ('62', 'Dahlia', 'Elephant', 10, 'F', 230, NULL,'71'),
    ('63', 'Fiona', 'Elephant', 5, 'F', 300, '70','71'),
    ('64', 'Georgia', 'Elephant', 11, 'F', 173, '62','71'),
    ('65', 'Jackie', 'Elephant', 12, 'F', 231, '62','71'),
    ('66', 'Freida', 'Elephant', 17, 'F', 333, '64','71'),
    ('67', 'Katie', 'Elephant', 3, 'F', 272, '62','71'),
    ('68', 'Marie', 'Elephant', 8, 'F', 47, '70','71'),
    ('69', 'Patricia', 'Elephant', 9, 'F', 131, '70','71'),
    ('70', 'Elenor', 'Elephant', 10, 'F', 333, NULL,NULL),
    ('71', 'Ian', 'Elephant', 7, 'M', 114, NULL,NULL);
    

INSERT INTO minizooKeeper VALUES 
    ('1', 'Roger'),
    ('2', 'Sidra'),
    ('3', 'Amit'),
    ('4', 'Lucia');

INSERT INTO minizooCare_Role VALUES 
    ('32', '1', 'feeding'),
    ('32', '2', 'washing'),
    ('61', '1', 'feeding'),
    ('62', '1', 'feeding'),
    ('63', '1', 'feeding'),
    ('64', '1', 'feeding'),
    ('65', '1', 'feeding'),
    ('66', '1', 'feeding'),
    ('67', '1', 'feeding'),
    ('68', '1', 'feeding'),
    ('69', '1', 'feeding'),
    ('70', '1', 'feeding'),
    ('71', '1', 'feeding'),
    ('11', '4', 'feeding'),
    ('12', '4', 'feeding'),
    ('13', '4', 'feeding'),
    ('14', '4', 'feeding'),
    ('15', '4', 'feeding'),
    ('16', '4', 'feeding'),
    ('17', '4', 'feeding'),
    ('18', '4', 'feeding'),
    ('19', '4', 'feeding'),
    ('20', '4', 'feeding'),
    ('21', '4', 'feeding');

    SHOW TABLES;
    DESC minizooAnimal;
    DESC minizooCare_Role;
    DESC minizooKeeper;