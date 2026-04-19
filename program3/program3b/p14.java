
/* Q4. Write a Java Program for Checking if a string reads
the same backward as forward (ignoring case and punctuation)
using user defined function isPalindrome(). */
package pgr3b;

import java.util.*;

public class p14 {

	public static boolean isPalindrome(String str) {
		
		str = str.toLowerCase();
		str = str.replaceAll("[^a-z0-9]", "");
		
		String rev = "";
		
		for(int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}
		
		if(str.equals(rev)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "Madam";
		
		if(isPalindrome(s)) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not Palindrome");
		}
	}
}