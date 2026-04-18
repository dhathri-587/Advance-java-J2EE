
/* Write a java program for getting different colors through ArrayList interface
and extract the elements 1st and 2nd from the ArrayList object
by using SubList() */
package pgr1b;

import java.util.*;

public class p4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> ls = new ArrayList<>();
		
		ls.add("Orange");
		ls.add("Green");
		ls.add("Pink");
		ls.add("Red");
		ls.add("Blue");
		
		System.out.println(ls);
		
		List<String> sub = ls.subList(0, 2);
		
		System.out.println(sub);
	}
}