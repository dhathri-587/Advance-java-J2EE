
/* Q3. Write a Java Program for Reversing the characters
in a string using user defined function reverseString(). */
package pgr3b;
import java.util.*;

public class p13 {

	public static String reverseString(String str) {
		String rev = "";

		for(int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}

		return rev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "Hello";
		
		String result = reverseString(s);
		
		System.out.println("Original String = " + s);
		System.out.println("Reversed String = " + result);
	}
}