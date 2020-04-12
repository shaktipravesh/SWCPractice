package BitMagic;

import java.util.Scanner;

public class MaximumXORSubset {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iSize = sc.nextInt();
			int iMaxXOR = 0, iXORArraySize = iSize;
			int[] iNumArray = new int[iSize];
			int[] iXORArray = new int[iSize];
			for(int i =0; i < iSize; i++) {
				iNumArray[i] = sc.nextInt();
				iXORArray[i] = iNumArray[i];
				if(iMaxXOR < iNumArray[i])
					iMaxXOR = iNumArray[i];
			}
			iMaxXOR = getMaxXOR(iNumArray, iXORArray, iSize, iXORArraySize-1, iMaxXOR);
			System.out.println(iMaxXOR);
		}

	}

	private static int getMaxXOR(int[] iNumArray, int[] iXORArray, int iSize, int iXORArraySize, int iMaxXOR) {
		if(iXORArraySize < 1) {
			return iMaxXOR;
		}

		for(int i = 0; i < iXORArraySize; i++) {
			int[] iTempArray = new int[iXORArraySize-i];
			for(int j = i, k = iSize - iXORArraySize + i, n = 0; j < iXORArraySize; j++, k++, n++) {
				iTempArray[n] = iNumArray[k]^iXORArray[i];
				if(iMaxXOR < iTempArray[n]) {
					iMaxXOR = iTempArray[n];
				}
			}
			iMaxXOR = getMaxXOR(iNumArray, iTempArray, iSize, iXORArraySize-i-1, iMaxXOR);
		}
		return iMaxXOR;
	}

}
