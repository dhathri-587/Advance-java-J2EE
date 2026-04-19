
/* Q5. Write a Java Program for Eliminating all whitespace
characters from a string using user defined function
removeWhitespace(). */

package pgr3b;
import java.util.*;

public class p15 {

	public static String removeWhitespace(String str) {
		
		str = str.replaceAll("\\s", "");
		
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "Java is Easy";
		
		String result = removeWhitespace(s);
		
		System.out.println("Original String = " + s);
		System.out.println("After Removing Spaces = " + result);
	}
}