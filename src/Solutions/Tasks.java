package Solutions;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Tasks {

    /**
     <p><b> 1) First Task </b> - Palindrome checker </p>
     @param text String which will be tested for palindrome check
     @return True if the text is palindrome, false otherwise
     */
    public static boolean isPalindrome(String text) {
        int len = text.length();
        // Iterate to the half of the indexes
        for (int i = 0; i < len / 2; i++)
            // if ith char from the right and left are not equal return false
            if (text.charAt(i) != text.charAt(len - i - 1)) return false;
        return true;
    }

    /**
     <p><b> 2) Second Task </b> - get minimum amount of coins needed </p>
     Coin values: 50, 20, 10, 5, 1
     @param amount Amount of money the coins will be calculated for
     @return Minimal number of coins matching the amount provided
     */
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

    /**
     <p><b> 3) Third Task </b> - get the smallest missing natural number </p>
     Passed an array of ints the method calculated the smallest positive int which is missing
     @param array Array of ints which will be iterated
     @return Smallest natural number that is not present in the array
     */
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

    /**
     <p><b> 4) Fourth Task </b> - check if the braces are written correctly </p>
     Tests the corectness of the braces included in the String provided
     @param sequence String which will be checked
     @return True if the braces are correct, false otherwise
     */
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

    /**
     <p> <b> 5) Fifth Task </b> - count all possible ways to reach n'th step </p>
     <p> Calculates all possible ways to get to the n'th step. </p>
     Steps sizes are 1 and 2
     @param stairsCount Top level of the stair to reach
     @return Number of ways to reach n'th step in stairs
     */
    public static int countVariants(int stairsCount) {
        // recCount will count the ways straightforward, but the answer is actually nth number of fibonacci sequence
        if (stairsCount < 3) return stairsCount;
        return fib(stairsCount - 1, 0, 1, 0);
        // return recCount(stairsCount, 0);
    }

    // Auxiliary recursive function to return all possible way to get to the desired value (stairs max step)
    private static int recCount(int stairs, int current) {
        if (current > stairs) return 0;
        else if (current == stairs) return 1;
        return recCount(stairs, current + 1) + recCount(stairs, current + 2);
    }

    // Fibonacci sequence for stairs
    private static int fib(int n, int cur, int n1, int n2) {
        if (n == cur) return n1 + n2;
        return fib(n, ++cur, n1 + n2, n1);
    }

    /**
     <p> <b> 6) Sixth Task </b> - create data structure with element removal done in O(1) </p>
     @return A new object of DataStruct which support operations add(), remove(), find(), get(), size()
     */
    public static <T> DataStruct<T> createStruct() {
        return new DataStruct<T>();
    }

    /**
     <p> <b> 7) Seventh Task </b> - Write SQL for Teacher and Pupil table with Many-to-many Relationship between them </p>
     <p> </p>
     All necessary SQL Queries are written in separate files 'db_sql.sql' and 'db_postgresql.sql' for SQL and PostgreSQL respectively
     */
    public static void sqlQueries() {
        System.out.println("Please Check the db_postgresql.sql and db_sql.sql files located in Solutions package for this task!");
    }


    /**
     <p> <b> 8) Eight Task </b> - Get exchange rates from <a href="http://www.nbg.ge/rss.php"> http://www.nbg.ge/rss.php </href></p>
     Since the website provided in the task description was not functional, I used freecurrencyapi to get the
     exchange rates, and I wrote it in a separate file CurrencyConverter.java
     @param from Currency code for the base of the rate
     @param to Currency code for the target exchange rate from the passed parameter
     @return Exchange rate between the provided arguments
     */
    // 8)
    public static double convert(String to, String from) {
        return CurrencyConverter.convert(to, from);
    }

}





















