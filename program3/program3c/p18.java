

/* Q8. Write a Java Program for Verifying if a string contains
only numeric characters using user defined function
isNumeric(). */

package pgr3c;
import java.util.*;

public class p18 {

	public static boolean isNumeric(String str) {
		
		for(int i = 0; i < str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "12345";
		
		if(isNumeric(s)) {
			System.out.println("Contains only numbers");
		}
		else {
			System.out.println("Contains other characters");
		}
	}
}