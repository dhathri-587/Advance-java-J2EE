
/* 2.b. Develop a Java program to make a Performance Test on
StringBuffer and StringBuilder for appending the string
'AIET' for 10000 times both in the StringBuffer and
StringBuilder. Justify your answer which one is better. */

package pgr2b;
import java.util.*;

public class PerformanceTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long start1, end1, start2, end2;
		
		StringBuffer sbf = new StringBuffer();
		
		start1 = System.nanoTime();
		
		for(int i = 1; i <= 10000; i++) {
			sbf.append("AIET");
		}
		
		end1 = System.nanoTime();
		
		StringBuilder sbd = new StringBuilder();
		
		start2 = System.nanoTime();
		
		for(int i = 1; i <= 10000; i++) {
			sbd.append("AIET");
		}
		
		end2 = System.nanoTime();
		
		System.out.println("StringBuffer Time : " + (end1 - start1) + " ns");
		System.out.println("StringBuilder Time : " + (end2 - start2) + " ns");
		
		if((end1 - start1) > (end2 - start2)) {
			System.out.println("StringBuilder is better");
		}
		else {
			System.out.println("StringBuffer is better");
		}
	}
}