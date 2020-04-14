package BitManipulation;

public class AddBinary_0067 {

	public static void main(String[] args) {
		String addStr = new String();
		addStr = addBinary("1010", "1011");
		System.out.println(addStr);

	}

    public static String addBinary(String a, String b) {
    	String addStr = new String();
    	int[] iSNum = new int[10002];
    	int iBuff = 0;
    	int i= 0, j = 0;
    	for(i = a.length()-1, iSNum[0] = a.length(), j = 1; i >= 0; i--, j++) {
    		iSNum[j] = a.charAt(i) - '0';
    	}
    	for(i = b.length()-1, j = 1, iBuff = 0; i >= 0; i--, j++) {
    		iBuff += b.charAt(i)-'0' + iSNum[j];
    		iSNum[j] = iBuff&1;
    		iBuff = iBuff>>1;
    	}
    	while(iBuff > 0) {
    		iBuff += iSNum[j];
    		iSNum[j] = iBuff&1;
    		iBuff = iBuff>>1;
    		j++;
    	}
    	if(iSNum[0] < j)
    		iSNum[0] = j-1;
    	
    	for(i = iSNum[0], j = 0; i > 0; i--) {
    		addStr += iSNum[i];
    	}
    	
    	
    	
    	return addStr;
    	
    }

}

