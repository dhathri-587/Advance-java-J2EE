

/* Q6. Write a Java Program for Capitalizing the first letter
of each word using user defined function capitalizeWords(). */

package pgr3c;
import java.util.*;

public class p16 {

	public static String capitalizeWords(String str) {
		
		String words[] = str.split(" ");
		String result = "";
		
		for(int i = 0; i < words.length; i++) {
			String w = words[i];
			
			result = result + Character.toUpperCase(w.charAt(0))
					+ w.substring(1) + " ";
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "java programming language";
		
		String output = capitalizeWords(s);
		
		System.out.println("Original String = " + s);
		System.out.println("Capitalized String = " + output);
	}
}