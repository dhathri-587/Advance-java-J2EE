

/* Q7. Write a Java Program for Shortening a string to a
specified length and adds an ellipsis using user defined
function truncate(). */

package pgr3c;
import java.util.*;

public class p17 {

	public static String truncate(String str, int n) {
		
		if(str.length() <= n) {
			return str;
		}
		else {
			return str.substring(0, n) + "...";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "Java Programming Language";
		
		String result = truncate(s, 10);
		
		System.out.println("Original String = " + s);
		System.out.println("Truncated String = " + result);
	}
}