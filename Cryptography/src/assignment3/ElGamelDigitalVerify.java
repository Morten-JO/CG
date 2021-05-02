package assignment3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class ElGamelDigitalVerify {

	public static void main(String[] args) {
		
		BigInteger p = new BigInteger("2189284635404723");
		BigInteger alphaPrimitiveElement = new BigInteger("19");
		BigInteger privateKey = new BigInteger("10232362");
		BigInteger result = new BigInteger("1298283307042904");
		BigInteger vv = new BigInteger("173275442917163");
		BigInteger s = new BigInteger("753140806517360");
		
		System.out.println("Beginning process.");
		BigInteger b = alphaPrimitiveElement.modPow(privateKey, p);
		BigInteger verificationOne = b.modPow(vv, p).multiply(vv.modPow(s,p)).mod(p);
		BigInteger verificationTwo = alphaPrimitiveElement.modPow(result, p);
		if(verificationOne.compareTo(verificationTwo) == 1) {
			System.out.println("They are the same, and they have been verified.");
		} else {
			System.out.println("They are not the same.");
		}
	}

	public static BigInteger hashFunction(BigInteger m, BigInteger n) {
		BigInteger val = new BigInteger("2");
		return val.modPow(m, n);
	}
	
}
