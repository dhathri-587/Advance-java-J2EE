
/* Write a Java program that swaps two elements
(first and third elements) in a linked list
(using Collections.swap(l_list, 0, 2)) */

package pgr1b;
import java.util.*;

public class p10 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> ls = new LinkedList<>();
		
		ls.add("Orange");
		ls.add("Green");
		ls.add("Pink");
		ls.add("Red");
		ls.add("Blue");
		
		System.out.println(ls);
		
		Collections.swap(ls, 0, 2);
		
		System.out.println(ls);
	}
}