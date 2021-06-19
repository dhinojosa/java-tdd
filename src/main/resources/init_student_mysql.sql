CREATE TABLE STUDENT
(
    id        bigint NOT NULL AUTO_INCREMENT,
    firstName varchar(500) DEFAULT NULL,
    lastName  varchar(500) DEFAULT NULL,
    studentID varchar(200),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = 'utf8';

INSERT INTO STUDENT (firstName, lastName, studentID) VALUES ('Rod', 'Stewart', '001');
INSERT INTO STUDENT (firstName, lastName, studentID) VALUES ('Paul', 'McCartney', '002');
INSERT INTO STUDENT (firstName, lastName, studentID) VALUES ('Tina', 'Turner', '003');
INSERT INTO STUDENT (firstName, lastName, studentID) VALUES ('Paula', 'Abdul', '004');
INSERT INTO STUDENT (firstName, lastName, studentID) VALUES ('Karen', 'Carpenter', '005');
