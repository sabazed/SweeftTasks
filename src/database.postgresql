CREATE TABLE Teacher
(
    teacherid integer NOT NULL,
    firstname text,
    lastname text,
    gender text,
    subject text,
    PRIMARY KEY (teacherid)
);

CREATE TABLE Pupil
(
    pupilid integer NOT NULL,
    firstname text,
    lastname text,
    gender text,
    class text,
    PRIMARY KEY (pupilid)
);

CREATE TABLE TeacherPupilRelation
(
    pid integer NOT NULL,
    tid integer NOT NULL,
    FOREIGN KEY (pid) REFERENCES Pupil(pupilid),
    FOREIGN KEY (tid) REFERENCES Teacher(teacherid),
    UNIQUE (pid, tid)
);

SELECT DISTINCT * FROM TeacherPupilRelation relation
INNER JOIN Pupil pupl ON pupl.pupilid = relation.pid
INNER JOIN Teacher tchr ON tchr.teacherid = relation.tid
WHERE pupl.firstname = 'Giorgi';