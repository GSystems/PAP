CREATE TABLE student (
    id int NOT NULL AUTO_INCREMENT,
    firstname varchar(20),
    lastname varchar(20),
    email varchar(20),
    PRIMARY KEY(id)
    );

CREATE TABLE project (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    capacity int,
    coordinator varchar(50),
    PRIMARY KEY(id)
    );

CREATE TABLE skill (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    PRIMARY KEY (id)
    );

CREATE TABLE assignment (
    id_project integer,
    id_student integer,
    FOREIGN KEY (id_project) REFERENCES project(id),
    FOREIGN KEY (id_student) REFERENCES student(id)
    );

CREATE TABLE student_preferences (
    id_project integer,
    id_student integer,
    FOREIGN KEY (id_project) REFERENCES project(id),
    FOREIGN KEY (id_student) REFERENCES student(id)
    );

CREATE TABLE project_preferences (
    id_project integer,
    id_student integer,
    FOREIGN KEY (id_project) REFERENCES project(id),
    FOREIGN KEY (id_student) REFERENCES student(id)
    );

CREATE TABLE student_skill (
    id_student integer,
    id_skill integer,
    FOREIGN KEY (id_student) REFERENCES student(id),
    FOREIGN KEY (id_skill) REFERENCES skill(id)
    );

CREATE TABLE project_skill (
    id_project integer,
    id_skill integer,
    FOREIGN KEY (id_project) REFERENCES project(id),
    FOREIGN KEY (id_skill) REFERENCES skill(id)
    );


INSERT INTO student (firstname, lastname, email)
	VALUES
        ('John', 'Smith', 'john.smith@gmail.com'),
        ('Sam', 'Adams', 'sam.adams@gmail.com'),
        ('Roby', 'Carter', 'roby.carter@gmail.com');

INSERT INTO project (name, capacity, coordinator)
	VALUES
    	('BiMr', 2, 'Thomas Mitchel'),
        ('PAP', 3, 'Johny Lexter'),
        ('FIImDB', 1, 'Samuel Noland');

INSERT INTO project_preferences
	VALUES
    	(1,2),
        (1,3),
        (2,3),
        (2,1),
        (2,3),
        (3,2);

INSERT INTO student_preferences
	VALUES
    	(1,1),
        (1,3),
        (2,3),
        (2,2),
        (3,1),
        (3,3);