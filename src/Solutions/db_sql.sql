CREATE TABLE Teacher
(
    teacherid INT NOT NULL IDENTITY PRIMARY KEY,
    firstname VARCHAR(20),
    lastname VARCHAR(20),
    gender VARCHAR(10),
    subject VARCHAR(30)
);

CREATE TABLE Pupil
(
    pupilid INT NOT NULL IDENTITY PRIMARY KEY,
    firstname VARCHAR(20),
    lastname VARCHAR(20),
    gender VARCHAR(10),
    class VARCHAR(30)
);

CREATE TABLE TeacherPupilRelation
(
    pid INT NOT NULL,
    tid INT NOT NULL,
    FOREIGN KEY (pid) REFERENCES Pupil(pupilid),
    FOREIGN KEY (tid) REFERENCES Teacher(teacherid),
    UNIQUE (pid, tid)
);

SELECT DISTINCT tchr.teacherid, tchr.firstname, tchr.lastname, tchr.gender, tchr.subject
FROM TeacherPupilRelation relation
INNER JOIN Pupil pupl ON pupl.pupilid = relation.pid
INNER JOIN Teacher tchr ON tchr.teacherid = relation.tid
WHERE pupl.firstname = 'Giorgi';