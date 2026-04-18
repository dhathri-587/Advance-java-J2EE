

/* Write a Java program to display elements and their positions
in a linked list
(using l_listobj.get(p)) */

package pgr1b;

import java.util.*;

public class p9 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> ls = new LinkedList<>();
		
		ls.add("Orange");
		ls.add("Green");
		ls.add("Pink");
		ls.add("Red");
		ls.add("Blue");
		
		for(int p = 0; p < ls.size(); p++) {
			System.out.println("Position " + p + " : " + ls.get(p));
		}
	}
}