package Test;

import Solutions.DataStruct;
import Solutions.Tasks;

public class Main extends Tasks {

    public static void main(String[] args) {

        // 1)
        System.out.println("==================== 1 =====================");
        System.out.println(isPalindrome("eye"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("sweeft"));
        System.out.println(isPalindrome("digital"));

        // 2)
        System.out.println("==================== 2 =====================");
        System.out.println(minSplit(420));
        System.out.println(minSplit(222));

        // 3)
        System.out.println("==================== 3 =====================");
        System.out.println(notContains(new int[]{4,1,2,3,-4,5,7,9}));
        System.out.println(notContains(new int[]{1,6,-2,-4,-6,1,10,9,7,3,2}));
        System.out.println(notContains(new int[]{1,2,3,4,5,5,4,3,2,1}));

        // 4)
        System.out.println("==================== 4 =====================");
        System.out.println(isProperly("((())())"));
        System.out.println(isProperly("((())()"));
        System.out.println(isProperly("))("));
        System.out.println(isProperly("(((()))"));

        // 5)
        System.out.println("==================== 5 =====================");
        System.out.println(countVariants(1));
        System.out.println(countVariants(5));
        System.out.println(countVariants(10));
        System.out.println(countVariants(45));

        // 6)
        System.out.println("==================== 6 =====================");
        DataStruct<Integer> struct = createStruct();
        struct.add(1);
        struct.add(4);
        struct.add(5);
        struct.add(10);
        struct.add(-100);
        System.out.println(struct.size());
        struct.remove(1);
        struct.remove(-100);
        System.out.println(struct.size());

        // 7)
        System.out.println("==================== 7 =====================");
        sqlQueries();

        // 8
        System.out.println("==================== 8 =====================");
        System.out.println(convert("USD", "GEL"));
        System.out.println(convert("USD", "CAD"));
        System.out.println(convert("RUB", "GEL"));
    }

}
