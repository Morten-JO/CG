package utils;

public class BinaryNumber {

	private static final String[] hexValues = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	private static final String[] hexToBinaryValues = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
	
	String[] data;
	int bits;
	
	public BinaryNumber(int bits, String val){
		this.bits = bits;
		this.data = new String[bits];
		int iterator = data.length-1;
		for(int i = val.length() -1; i > -1; i--){
			data[iterator] = String.valueOf(val.charAt(i));
			iterator--;
		}
	}
	
	public BinaryNumber(int bits, String hex, boolean isHex){
		String val = "";
		for(int i = 0; i < hexValues.length; i++){
			if(hex.contentEquals(hexValues[i])){
				val = hexToBinaryValues[i];
				break;
			}
		}
		if(val == ""){
			System.exit(0);
			System.out.println("FATALERROR TOHEX"+bits+" "+hex+" "+isHex);
		}
		this.data = new String[bits];
		this.bits = bits;
		int iterator = data.length-1;
		for(int i = val.length() -1; i > -1; i--){
			this.data[iterator] = String.valueOf(val.charAt(i));
			iterator--;
		}
	}
	
	public BinaryNumber(String[] vals){
		this.data = vals;
		bits = vals.length;
	}
	
	public String turnToString(){
		String newStr = "";
		for(int i = 0; i < data.length; i++){
			newStr += data[i];
		}
		return newStr;
	}
	
	public String toHex(){
		String val = turnToString();
		for(int i = 0; i < hexToBinaryValues.length; i++){
			if(val.equals(hexToBinaryValues[i])){
				return hexValues[i];
			}
		}
		System.out.println("FATALERROR TOHEX"+val+" "+data[0]+data[1]+data[2]+data[3]);
		System.exit(0);
		return "";
	}
	
	
}
