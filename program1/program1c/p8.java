

/* Write a Java program to insert the specified element
at the end of a linked list
(using l_listobj.offerLast("Pink")) */

package pgr1b;
import java.util.*;

public class p8 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> ls = new LinkedList<>();
		
		ls.add("Orange");
		ls.add("Green");
		ls.add("Red");
		ls.add("Blue");
		
		System.out.println(ls);
		
		ls.offerLast("Pink");
		
		System.out.println(ls);
	}
}