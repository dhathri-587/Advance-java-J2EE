
/* Q9. Write a Java Program for Creating a random string of a
specified length using user defined function
generateRandomString(). */

package pgr3c;
import java.util.*;

public class p19 {

	public static String generateRandomString(int n) {
		
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String result = "";
		
		Random r = new Random();
		
		for(int i = 0; i < n; i++) {
			int index = r.nextInt(chars.length());
			result = result + chars.charAt(index);
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = generateRandomString(8);
		
		System.out.println("Random String = " + s);
	}
}