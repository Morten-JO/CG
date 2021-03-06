package utils;

public class MathMethods {
	
	public static BinaryNumber xor(BinaryNumber one, BinaryNumber two){
		String[] newValue = new String[one.bits];
		for(int i = 0; i < newValue.length; i++){
			if(one.data[i].equals(two.data[i])){
				newValue[i] = "0";
			}
			else if(one.data[i].equals("0") && two.data[i].equals("1") || one.data[i].equals("1") && two.data[i].equals("0")){
				newValue[i] = "1";
			} else{
				newValue[i] = "0";
			}
		}
		BinaryNumber yes = new BinaryNumber(newValue);
		if(yes.data.length == 0){
			System.out.println("xored0:"+one.turnToString()+"|"+two.turnToString()+"|"+newValue.length+"|"+one.bits);
		}
		
		return yes;
	}
	
}
