

/* Write a Java program to iterate through all elements in a linked list
starting at the specified position (2nd) using iterator
(Hint : Iterator iteratorobj = listobj.listIterator(1)) */
package pgr1b;
import java.util.*;

public class p6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> ls = new LinkedList<>();
		
		ls.add("Orange");
		ls.add("Green");
		ls.add("Pink");
		ls.add("Red");
		ls.add("Blue");
		
		System.out.println(ls);
		
		Iterator<String> it = ls.listIterator(1);
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}