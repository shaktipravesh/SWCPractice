import java.util.HashMap;

public class RomantoInteger13 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String romanNum = "MCDLXXVI";
		RomantoInteger13 RtoI = new RomantoInteger13();
		
		RtoI.romanToInt(romanNum);
	}
	
    public int romanToInt(String s) {
    	HashMap<String, Integer> romanHMap = new HashMap<String, Integer>();
    	romanHMap.put("I", 1);
    	romanHMap.put("IV", 4);
    	romanHMap.put("V", 5);
    	romanHMap.put("IX", 9);
    	romanHMap.put("X", 10);
    	romanHMap.put("XL", 40);
    	romanHMap.put("L", 50);
    	romanHMap.put("XC", 90);
    	romanHMap.put("C", 100);
    	romanHMap.put("CD", 400);
    	romanHMap.put("D", 500);
    	romanHMap.put("CM", 900);
    	romanHMap.put("M", 1000);
    	
    	int iValue = 0;
        for(int i = 0; i < s.length(); i++) {
        	String iNum;
        	if(i+1 < s.length()) {
        		iNum = s.substring(i, i+2);
        		if(romanHMap.containsKey(iNum)) {
        			iValue += romanHMap.get(iNum);
        			i++;
        		}
        		else {
        			iNum = s.substring(i, i+1);
        			iValue += romanHMap.get(iNum);
        		}
        	} else {
        		iNum = s.substring(i, i+1);
        		iValue += romanHMap.get(iNum);
        	}
        }
    	
    	return iValue;
    }
    
    public String inttoRoman(int num) {
    	HashMap<Integer, String> romanHMap = new HashMap<Integer, String>();
    	romanHMap.put(1, "I");
    	romanHMap.put(4, "IV");
    	romanHMap.put(5, "V");
    	romanHMap.put(9, "IX");
    	romanHMap.put(10, "X");
    	romanHMap.put(40, "XL");
    	romanHMap.put(50, "L");
    	romanHMap.put(90, "XC");
    	romanHMap.put(100, "C");
    	romanHMap.put(400, "CD");
    	romanHMap.put(500, "D");
    	romanHMap.put(900, "CM");
    	romanHMap.put(1000, "M");
    	
    	String iValue = new String();
        while(num > 0) {
        	if(num >= 1000) {
        		iValue +=romanHMap.get(1000);
        		num -= 1000;
        	} else if(num >= 900) {
        		iValue +=romanHMap.get(900);
        		num -= 900;
        	} else if(num >= 500) {
        		iValue +=romanHMap.get(500);
        		num -= 500;
        	} else if(num >= 400) {
        		iValue +=romanHMap.get(400);
        		num -= 400;
        	} else if(num >= 100) {
        		iValue +=romanHMap.get(100);
        		num -= 100;
        	} else if(num >= 90) {
        		iValue +=romanHMap.get(90);
        		num -= 90;
        	} else if(num >= 50) {
        		iValue +=romanHMap.get(50);
        		num -= 50;
        	} else if(num >= 40) {
        		iValue +=romanHMap.get(40);
        		num -= 40;
        	} else if(num >= 10) {
        		iValue +=romanHMap.get(10);
        		num -= 10;
        	} else if(num >= 9) {
        		iValue +=romanHMap.get(9);
        		num -= 9;
        	} else if(num >= 5) {
        		iValue +=romanHMap.get(5);
        		num -= 5;
        	} else if(num >= 4) {
        		iValue +=romanHMap.get(4);
        		num -= 4;
        	} else if(num >= 1) {
        		iValue +=romanHMap.get(1);
        		num -= 1;
        	}
        }
    	
    	return iValue;
    }
}
