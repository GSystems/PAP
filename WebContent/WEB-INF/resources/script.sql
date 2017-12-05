GRANT ALL PRIVILEGES ON PAP.* TO 'PAPUser'@'localhost' WITH GRANT OPTION;

CREATE TABLE student (
    id int NOT NULL AUTO_INCREMENT,
    firstname varchar(20),
    lastname varchar(20),
    email varchar(50),
	skills varchar(50),
    PRIMARY KEY(id)
    );

CREATE TABLE project (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    capacity int,
    coordinator varchar(50),
	skills varchar(50),
    PRIMARY KEY(id)
    );

CREATE TABLE assignment (
    id_project integer,
    id_student integer
    );

CREATE TABLE student_preferences (
    id_project integer,
    id_student integer
    );

CREATE TABLE project_preferences (
    id_project integer,
    id_student integer
    );


INSERT INTO student (firstname, lastname, email, skills)
	VALUES
        ('John', 'Smith', 'john.smith@gmail.com', 'Java'),
        ('Sam', 'Adams', 'sam.adams@gmail.com', 'C#'),
        ('Roby', 'Carter', 'roby.carter@gmail.com', 'SQL');

INSERT INTO project (name, capacity, coordinator, skills)
	VALUES
    	('BiMr', 2, 'Thomas Mitchel', 'Java'),
        ('PAP', 3, 'Johny Lexter', 'Java'),
        ('FIImDB', 1, 'Samuel Noland', 'SQL');

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