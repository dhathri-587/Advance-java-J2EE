/* Write a Java Program for Checking if a given string is null
   or contains only whitespace using user defined function
   isNullOrEmpty(). */

package pgr3b;

public class p11 {

	public static boolean isNullOrEmpty(String str) {
		if(str == null || str.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		String s1 = null;
		String s2 = "   ";
		String s3 = "Hello";

		System.out.println(isNullOrEmpty(s1));
		System.out.println(isNullOrEmpty(s2));
		System.out.println(isNullOrEmpty(s3));
	}
}