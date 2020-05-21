INSERT INTO student(first_name, last_name, date_of_birth, jmbag, number_of_ects)
VALUES ('Tomislav', 'Horvat', '1995-10-08', '0246077123', 120);
INSERT INTO student(first_name, last_name, date_of_birth, jmbag, number_of_ects)
VALUES ('Marija', 'Kovačević', '1995-10-05', '0246077222', 90);
INSERT INTO student(first_name, last_name, date_of_birth, jmbag, number_of_ects)
VALUES ('Novak', 'Đoković', '1990-10-03', '0246077242', 100);

INSERT INTO course (name, number_of_ects)
VALUES ('Web aplikacije u Javi', 6);
INSERT INTO course (name, number_of_ects)
VALUES ('Baze podataka', 5);
INSERT INTO course (name, number_of_ects)
VALUES ('Matematika', 5);
INSERT INTO course (name, number_of_ects)
VALUES ('Fizika', 5);

INSERT INTO student_course VALUES (1, 1);
INSERT INTO student_course VALUES (1, 2);
INSERT INTO student_course VALUES (2, 1);
INSERT INTO student_course VALUES (2, 3);
INSERT INTO student_course VALUES (3, 1);
INSERT INTO student_course VALUES (3, 3);

INSERT INTO USER (ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME)  VALUES (1, 'admin', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'admin', 'admin');
INSERT INTO USER (ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME)  VALUES (2, 'user', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'user', 'user');
INSERT INTO USER (ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME)  VALUES (3, 'updater', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'updater', 'updater');

INSERT INTO AUTHORITY (ID, NAME) VALUES (1, 'ROLE_ADMIN');
INSERT INTO AUTHORITY (ID, NAME) VALUES (2, 'ROLE_USER');
INSERT INTO AUTHORITY (ID, NAME) VALUES (3, 'ROLE_UPDATER');

INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES ( 1, 1 );
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES ( 2, 2 );
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES ( 3, 3 );
