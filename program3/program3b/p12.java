

/* Q2. Write a Java Program for Counting how many times a
substring appears in a main string using user defined
function countOccurrences() */
package pgr3b;

import java.util.*;

public class p12 {

	public static int countOccurrences(String str, String sub) {
		int count = 0;
		int index = 0;

		while((index = str.indexOf(sub, index)) != -1) {
			count++;
			index = index + sub.length();
		}

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String mainstr = "Java is easy. Java is powerful. Java is popular.";
		String sub = "Java";

		int result = countOccurrences(mainstr, sub);

		System.out.println("Count = " + result);
	}
}