package ciphersbox;

import utils.BinaryNumber;
import utils.MathMethods;

public class CipherThree {

	
	private static String[] sBoxX = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	private static String[] sBoxCalced = {"6","4","c","5","0","7","2","e","1","f","3","d","8","a","9","b"};
	
	private static String[] messageText = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	private static String[] cipherText =  {"1","d","8","a","4","3","0","2","f","6","e","c","5","b","7","9"};
	
	
	public static void main(String[] args) {
		String[] possibleKeys = sBoxX;
		int[] tCounters = new int[16];
		String c = "1100";
		
		for(int i = 0; i < messageText.length / 2; i ++){
			BinaryNumber number = new BinaryNumber(4, cipherText[i], true);
			int numberIndexPair = messageText.length - 1 - i;
			BinaryNumber numberTwo = new BinaryNumber(4, cipherText[numberIndexPair], true);
			for(int j = 0; j < possibleKeys.length; j++){
				BinaryNumber key = new BinaryNumber(4, possibleKeys[j], true);
				BinaryNumber z = MathMethods.xor(number, key);
				BinaryNumber y = new BinaryNumber(4, reverseSBox(z.toHex()), true);
				
				BinaryNumber zTwo = MathMethods.xor(numberTwo, key);
				BinaryNumber yTwo = new BinaryNumber(4, reverseSBox(zTwo.toHex()), true);
				
				BinaryNumber diff = MathMethods.xor(y, yTwo);
				if(diff.turnToString().equals(c)){
					tCounters[j] += 1;
				}
				
			}
		}
		int highestCountIndex = -1;
		int highestCount = 0;
		for(int i = 0; i < tCounters.length; i++){
			if(tCounters[i] > highestCount){
				highestCountIndex = i;
				highestCount = tCounters[i];
			}
			System.out.println("TCounter #"+i+" has a result of: "+tCounters[i]+" correct differences.");
		}
		System.out.println("The highest count is TCounter #"+highestCountIndex+" with "+highestCount+" correct differences.");
		
	}
	
	
	private static String reverseSBox(String value){
		for(int i = 0; i < sBoxCalced.length; i++){
			if(sBoxCalced[i].equals(value)){
				return sBoxX[i];
			}
		}
		System.out.println("FATAL ERROR REVERSRBOX: "+value);
		System.exit(0);
		return "";
	}
	
	private static String processSBox(String value){
		for(int i = 0; i < sBoxX.length; i++){
			if(sBoxX[i].equals(value)){
				return sBoxCalced[i];
			}
		}
		System.out.println("FATAL ERROR PROCESBOX: "+value);
		System.exit(0);
		return "";
	}
	
}
