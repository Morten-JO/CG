package assignment2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class MillerRabinPrime {

	public static Random random = new Random();
	
	public static void main(String[] args) {
		ArrayList<Integer> primes = checkPrimeRange(1500, 35000, 3);
		System.out.println("Amount of primes: "+primes.size());
	}
	
	
	public static ArrayList<Integer> checkPrimeRange(int min, int max, int iterations){
		ArrayList<Integer> listOfPrimes = new ArrayList<Integer>();
		//Lets just ignore all even numbers..
		if(min % 2 == 0){
			min++;
		}
		for(int i = min; i < max + 1; i+= 2){
			for(int j = 0; j < iterations; j++){
				if(isPrime(i)){
					if(j == iterations - 1){
						listOfPrimes.add(i);
					}
				} else{
					break;
				}
			}
		}
		return listOfPrimes;
	}
	
	public static boolean isPrime(int selectedNumber){
		int t = selectedNumber - 1;
		int s = 0;
		while(t % 2 == 0){
			t = t / 2;
			s++;
		}
		int b = 1 + random.nextInt(selectedNumber - 1);
		BigInteger bBig = new BigInteger(String.valueOf(b));
		BigInteger selectedBig = new BigInteger(String.valueOf(selectedNumber));
		BigInteger y = bBig.pow(t).mod(selectedBig);
		if(y.compareTo(BigInteger.ONE) == 0){
			return true;
		}
		for(int i = 0; i < s; i++){
			if(y.compareTo(new BigInteger(String.valueOf(selectedNumber - 1))) == 0){
				return true;
			} else{
				y = y.pow(2).mod(selectedBig);
			}
		}
		return false;
	}
	
}
