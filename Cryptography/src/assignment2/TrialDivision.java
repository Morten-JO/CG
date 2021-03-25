package assignment2;

import java.util.ArrayList;

public class TrialDivision {

	public static void main(String[] args) {
		getPrimesForInterval(1500, 35000);
	}
	
	public static void getPrimesForInterval(int min, int max){
		ArrayList<Integer> listOfPrimes = new ArrayList<Integer>();
		for(int m = min; m < max+1; m++){
			if(m <= 2 && m >= 1){
				listOfPrimes.add(m);
				continue;
			}
			int a = 2;
			if(m % a == 0){
				continue;
			}
			a = 3;
			if(m % a == 0){
				continue;
			}
			boolean isPrime = true;
			while(a <= Math.sqrt(m)){
				if(m % (a + 2) == 0){
					isPrime = false;
					break;
				}
				if(m % (a + 4) == 0){
					isPrime = false;
					break;
				}
				a = a + 6;
			}
			if(isPrime){
				listOfPrimes.add(m);
			}
		}
		System.out.println("Primes: "+listOfPrimes.size());
		for(int i = 0; i < listOfPrimes.size(); i++){
			System.out.println(listOfPrimes.get(i));
		}
	}
	
}
