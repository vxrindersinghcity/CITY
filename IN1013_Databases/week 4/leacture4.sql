DROP DATABASE IF EXISTS journey_DB;
CREATE DATABASE journey_DB;
USE journey_DB;

CREATE TABLE journey (
    ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    DISTANCE INTEGER,
    JOURNEYDATE DATE,
    TICKET CHAR(1)
);

CREATE TABLE dummy (ID INTEGER);
DESC dummy;
DROP TABLE dummy;
DESC dummy;

ALTER TABLE journey ADD time INTEGER;
DESC journey;
ALTER TABLE journey MODIFY COLUMN time TIME;
DESC journey;
ALTER TABLE journey MODIFY COLUMN time TIME NOT NULL;
DESC journey;

SHOW TABLES;
DESC journey;