import java.util.Scanner;

public class BleakNumbers {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
		    int iNum = sc.nextInt();
		    isBleakNumber(iNum);		    
		}

	}

	private static void isBleakNumber(int iNum) {
		int iDiff = 0;
	    int iNumTemp = iNum;
	    while(iNumTemp > 0){
	        iDiff++;
	        iNumTemp = iNumTemp>>1;
	    }
	    for(iNumTemp = iNumTemp + iDiff; iNumTemp < iNum; iNumTemp++){
	        int iBitTrueCt = 0;
	        iBitTrueCt = getBitTrueCt(iNumTemp);
	        if((iNumTemp + iBitTrueCt) == iNum) {
	        	System.out.println("1");
	        	return;
	        }
	    }
	    System.out.println("0");
	}

	private static int getBitTrueCt(int iNumTemp) {
		int iBitTrueCt = 0;
		while(iNumTemp > 0) {
			if((iNumTemp & 1) == 1)
				iBitTrueCt++;
			iNumTemp = iNumTemp >> 1;		
		}
		return iBitTrueCt;
	}

}
