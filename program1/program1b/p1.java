/* 1b)1) Write a java program for getting different colors through ArrayList interface
 and search whether the color "Red" is available or not */

package pgr1b;

import java.util.*;

public class p1 {
    public static void main(String[] args) {

        List<String> ls = new ArrayList<>();

        ls.add("Orange");
        ls.add("Green");
        ls.add("Pink");
        ls.add("Red");

        System.out.println(ls);

        if(ls.contains("Red")) {
            System.out.println("Red is available");
        }
        else {
            System.out.println("Red is not available");
        }
    }
}