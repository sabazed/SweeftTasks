import java.util.*;

public class Tasks {

    public static boolean isPalindrome(String text) {
        int len = text.length();
        // Iterate to the half of the indexes
        for (int i = 0; i < len / 2; i++)
            // if ith char from the right and left are not equal return false
            if (text.charAt(i) != text.charAt(len - i - 1)) return false;
        return true;
    }

    public static int minSplit(int amount) {
        int count = 0;
        // Loop until amount reaches 0 and check for every coin
        while (amount > 0) {
            if (amount >= 50) amount -= 50;
            else if (amount >= 20) amount -= 20;
            else if (amount >= 10) amount -= 10;
            else if (amount >= 5) amount -= 5;
            else amount--;
            count++;
        }
        return count;
    }

    public static int notContains(int[] array) {
        // Set min as 1 and increment it by 1 if it is in array
        int min = 1;
        // Put all used ints into a set to fetch them with O(1)
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == min) min++;
            if (used.contains(min)) {
                array[i] = min;
                i--;
            }
            used.add(array[i]);
        }
        return min;
    }

    public static boolean isProperly(String sequence) {
        int count = 0;
        // Iterate all over the string and keep track of opening and closing brackets
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == '(') count++;
            else if (sequence.charAt(i) == ')') count--;
            // If more are closed than opened return false
            if (count < 0) return false;
        }
        // If all brackets aren't closed return false else true
        return count == 0;
    }

    public static int countVariants(int stairsCount) {
        return recCount(stairsCount, 0, 0);
    }

    // Auxiliary recursive function to return all possible way to get to the desired value (stairs max step)
    private static int recCount(int stairs, int current, int count) {
        if (current > stairs) return count - 1;
        else if (current == stairs) return count;
        return count + recCount(stairs, current + 1, ++count) + recCount(stairs, current + 2, ++count);
    }




    /* SQL

     1)  Teacher table:
             CREATE TABLE Teacher
             (
                 teacherid INT NOT NULL IDENTITY PRIMARY KEY,
                 firstname VARCHAR(20),
                 lastname VARCHAR(20),
                 gender VARCHAR(10),
                 subject VARCHAR(30)
             );

         Pupil table:
             CREATE TABLE Pupil
             (
                 pupilid INT NOT NULL IDENTITY PRIMARY KEY,
                 firstname VARCHAR(20),
                 lastname VARCHAR(20),
                 gender VARCHAR(10),
                 class VARCHAR(30)
            );

         Relation Table:
             CREATE TABLE TeacherPupilRelation
             (
                 pid INT NOT NULL,
                 tid INT NOT NULL,
                 FOREIGN KEY (pid) REFERENCES Pupil(pupilid),
                 FOREIGN KEY (tid) REFERENCES Teacher(teacherid),
                 UNIQUE (pid, tid)
             );

     2)  Select all teachers who teach any Giorgi:
            SELECT DISTINCT tchr.teacherid, tchr.firstname, tchr.lastname, tchr.gender, tchr.subject
            FROM TeacherPupilRelation relation
            INNER JOIN Pupil pupl ON pupl.pupilid = relation.pid
            INNER JOIN Teacher tchr ON tchr.teacherid = relation.tid
            WHERE pupl.firstname = 'Giorgi';

     */

    /* PostgreSQL

    1)  Teacher Table:
            CREATE TABLE Teacher
            (
                teacherid integer NOT NULL,
                firstname text,
                lastname text,
                gender text,
                subject text,
                PRIMARY KEY (teacherid)
            );

        Pupil Table:
            CREATE TABLE Pupil
            (
                pupilid integer NOT NULL,
                firstname text,
                lastname text,
                gender text,
                class text,
                PRIMARY KEY (pupilid)
            );

         Relationship Table:
            CREATE TABLE TeacherPupilRelation
            (
                pid integer NOT NULL,
                tid integer NOT NULL,
                FOREIGN KEY (pid) REFERENCES Pupil(pupilid),
                FOREIGN KEY (tid) REFERENCES Teacher(teacherid),
                UNIQUE (pid, tid)
            );

     2)  Select all teachers who teach any Giorgi:
            SELECT DISTINCT * FROM TeacherPupilRelation relation
            INNER JOIN Pupil pupl ON pupl.pupilid = relation.pid
            INNER JOIN Teacher tchr ON tchr.teacherid = relation.tid
            WHERE pupl.firstname = 'Giorgi';

     */

}





















