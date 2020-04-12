package BitMagic;

import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class FindSumOfDifferentCorrespondingBitsForAllPairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iSize = sc.nextInt();
			int[] aNum = new int[iSize];
			for(int i = 0; i < iSize; i++) {
				aNum[i] = sc.nextInt();
				//System.out.println(Integer.toBinaryString(aNum[i]));
			}
			long iSum = getSumofDifferentBitForAllPairsEfficient(aNum, iSize);
			System.out.println(iSum);
		}
	}

	private static long getSumofDifferentBitForAllPairsEfficient(int[] aNum, int iSize) {
		long iSum = 0;
		long iMod = 1000000007;
		int ones[] = new int[33];
		
		for(int x:aNum) {
			int p = 0;
			while(x != 0) {
				if((x & 1)==1) 
					ones[p]++;;
				x = x >>>1;
				p++;
			}
		}
		for(int x:ones) {
			iSum = (iSum + 2*x*(iSize-x)%iMod)%iMod;
		}
		return iSum;
	}
	
	private static long getSumofDifferentBitForAllPairs(int[] aNum, int iSize) {
		long iSum = 0;
		long iMod = 0;
		iMod = 7;
		iMod = iMod+1000000000;
		for(int i = 0; i < iSize; i++) {
			for(int j = i+1; j < iSize; j++) {
				iSum += 2*getSetBit(aNum[i]^aNum[j]);
			}
		}

		return iSum%iMod;
	}

	private static int getSetBit(int iNum) {
		int iSetBitCt = 0;
		while (iNum > 0) {
			iNum &= iNum -1;
			iSetBitCt++;
			
		}
		return iSetBitCt;
	}
}
