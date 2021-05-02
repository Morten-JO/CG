package assignment3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class ElGamelDigital {

	public static void main(String[] args) {
		
		BigInteger p = new BigInteger("2189284635404723");
		BigInteger pTwo = new BigInteger("2189284635404723").subtract(new BigInteger("1")).divide(new BigInteger("2"));
		BigInteger alphaPrimitiveElement = new BigInteger("19");
		BigInteger privateKey = new BigInteger("10232362");
		BigInteger randomNumber = new BigInteger("1234567");
		BigInteger nPrimeProduct = new BigInteger("2051152801041163");
		
		BigInteger hashedMessage = new BigInteger("144827");
		
		System.out.println("Beginning process.");
		BigInteger result = hashFunction(hashedMessage, nPrimeProduct);
		System.out.println("Hashed result: "+result);
		
		System.out.println("Calculate signature:");
		BigInteger vv = alphaPrimitiveElement.pow(randomNumber.intValue()).mod(p);
		System.out.println("V is: "+vv);
		BigDecimal bigD = new BigDecimal(result.subtract(privateKey.multiply(vv))).multiply(new BigDecimal(randomNumber).pow(-1, MathContext.DECIMAL32));
		
		BigInteger s = bigD.toBigInteger().mod(p.subtract(new BigInteger("1")));
		System.out.println("S is: "+s);
	}
	
	
	
	public static BigInteger hashFunction(BigInteger m, BigInteger n) {
		BigInteger val = new BigInteger("2");
		return val.modPow(m, n);
	}
	
}
