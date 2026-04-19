
/* Q10. Write a Java Program for Counting the number of words
in a string using user defined function countWords(). */

package pgr3c;
import java.util.*;

public class p20 {

	public static int countWords(String str) {
		
		String words[] = str.trim().split("\\s+");
		
		return words.length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "Java is easy to learn";
		
		int count = countWords(s);
		
		System.out.println("String = " + s);
		System.out.println("Number of Words = " + count);
	}
}