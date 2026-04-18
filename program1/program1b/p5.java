/* Write a java program for getting different colors through ArrayList interface
   and delete nth element from the ArrayList object
   by using remove by index */

package pgr1b;

import java.util.*;

public class p5 {

    public static void main(String[] args) {

        List<String> ls = new ArrayList<>();

        ls.add("Orange");
        ls.add("Green");
        ls.add("Pink");
        ls.add("Red");
        ls.add("Blue");

        System.out.println(ls);

        int n = 3;

        ls.remove(n - 1);

        System.out.println(ls);
    }
}