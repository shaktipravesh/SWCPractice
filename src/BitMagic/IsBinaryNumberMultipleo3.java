package BitMagic;

import java.math.BigInteger;
import java.util.Scanner;

public class IsBinaryNumberMultipleo3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			String strNum = sc.next();
			//long iNum = new BigInteger(strNum, 2).longValue();
					//Integer.parseInt(strNum, 2) ;
			if(isMultipleofThree(strNum)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			
		}

	}
	
	private static boolean isMultipleofThree(String strNum) {
		long iOdd = 0 , iEven = 0, iCount = 0;
		for(int i = 0; i < strNum.length(); i++) {
			int iNum = strNum.charAt(i)-'0';
			if(iCount%2 ==0) {
				iOdd += iNum&1;
			} else {
				iEven += iNum&1;
			}
			iCount++;
		}
		return isMultipleofThree(iOdd-iEven);
	}
//	2
//	100100000111111101010010010011010101110110
//	1100010110101100111001001111100100110000001101001110010000000111011110000011000010101000111
	private static boolean isMultipleofThree(long iNum) {
		int iOdd = 0 , iEven = 0, iCount = 0;
		if(iNum < 0) {
			iNum = -iNum;
		}
		if(iNum == 0) {
			return true;
		}
		if(iNum == 1) {
			return false;
		}
		
		while (iNum> 0) {
			if(iCount%2 ==0) {
				iOdd += iNum&1;
			} else {
				iEven += iNum&1;
			}
			iCount++;
			iNum = iNum >> 1;
		}
		return isMultipleofThree(iOdd-iEven);
	}

}
