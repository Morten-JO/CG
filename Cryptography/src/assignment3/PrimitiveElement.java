package assignment3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class PrimitiveElement {

	public static void main(String[] args) {
		
		BigInteger p = new BigInteger("2189284635404723");
		BigInteger pTwo = new BigInteger("2189284635404723").subtract(new BigInteger("1")).divide(new BigInteger("2"));
		System.out.println("Printing the following primitive elements found for 500 iterations:");
		
		ArrayList<String> primitiveElements = new ArrayList<String>();
		
		BigInteger alpha = new BigInteger("0");
		for(int i = 0; i < 500; i++) {
			alpha = new BigInteger(i+"");//getRandomLongToRange(p);
			if(gcd(alpha, p).compareTo(new BigInteger("1")) == 0){
				if(alpha.modPow(pTwo, p).compareTo(new BigInteger("1")) != 0) {
					if(alpha.pow(2).compareTo(new BigInteger("1")) != 0) {
						primitiveElements.add(alpha.toString());
					}
				}
			}
		}
		
		//Print
		System.out.print("[");
		for(int i = 0; i < primitiveElements.size(); i++) {
			System.out.print(primitiveElements.get(i)+",");
			if(i % 11 == 10) {
				System.out.println();
			}
		}
		System.out.print("]");
		
		
	}
	
	public static BigInteger getRandomLongToRange(BigInteger p) {
		Random rnd = new Random();
		return new BigInteger(rnd.nextInt()+"").mod(p);
	}
	
	
	
	
	
	/**
	 * Copied from https://www.baeldung.com/java-greatest-common-divisor
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static BigInteger gcd(BigInteger n1, BigInteger n2) {
	    if (n2.compareTo(new BigInteger("0")) == 0) {
	        return n1;
	    }
	    return gcd(n2, n1.mod(n2));
	}
	
}
