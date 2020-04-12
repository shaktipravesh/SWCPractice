package BitMagic;

import java.util.Scanner;

public class SumOfXOROfAllPairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iSize = sc.nextInt();
			long iSum = 0;
			int[] iNumArray = new int[iSize];
			for(int i =0; i < iSize; i++) {
				iNumArray[i] = sc.nextInt();
			}
			//iSum = getSumOfXOROfAllPairs(iNumArray, iSize);
			iSum = getSumOfXOROfAllPairsEfficient(iNumArray, iSize);
			System.out.println(iSum);
		}

	}

	// Solution 1 Naive O(n^2) appoarch
	private static long getSumOfXOROfAllPairs(int[] iNumArray, int iSize) {
		long iSum = 0;
		for(int i = 0; i < iSize; i++) {
			for(int j = i+1; j < iSize; j++) {
				iSum += iNumArray[i]^iNumArray[j];
			}
		}
		return iSum;
	}

	//Solution2	Expert O(Nlog N)
	private static long getSumOfXOROfAllPairsEfficient(int[] aNum, int iSize) {
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
		for(int i = 0; i < 32; i++) {
			int x = ones[i];
			//System.out.println(ones[i]);
			iSum += x*(iSize-x)*(1<<i);
			//iSum = (iSum + 2*x*(iSize-x)%iMod)%iMod;
		}
		return iSum;
	}	
}
