/* Write a Java program to iterate a linked list in reverse order
(using objlist.descendingIterator()) */

package pgr1b;
import java.util.*;

public class p7 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> ls = new LinkedList<>();
		
		ls.add("Orange");
		ls.add("Green");
		ls.add("Pink");
		ls.add("Red");
		ls.add("Blue");
		
		System.out.println(ls);
		
		Iterator<String> it = ls.descendingIterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}