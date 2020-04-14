package BitMagic;

import java.util.Scanner;

public class SubsetsWithXORValue {

	//static int iResult  = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			//iResult  = 0;
			int iSize = sc.nextInt();
			int iXORValue = sc.nextInt();
			int iXORArraySize = iSize, iRes = 0;
			int[] iNumArray = new int[iSize];
			int[] iXORArray = new int[iSize];
			for(int i =0; i < iSize; i++) {
				iNumArray[i] = sc.nextInt();
				iXORArray[i] = iNumArray[i];
				if(iXORValue == iNumArray[i])
					iRes++;
			}
			iRes = getMaxXOR(iNumArray, iXORArray, iSize, iXORArraySize-1, iRes, iXORValue);
			System.out.println(iRes);
		}
		sc.close();

	}

	private static int getMaxXOR(int[] iNumArray, int[] iXORArray, int iSize, int iXORArraySize, int iRes, int iXORValue) {
		if(iXORArraySize < 1) {
			return iRes;
		}

		for(int i = 0; i < iXORArraySize; i++) {
			int[] iTempArray = new int[iXORArraySize-i];
			for(int j = i, k = iSize - iXORArraySize + i, n = 0; j < iXORArraySize; j++, k++, n++) {
				iTempArray[n] = iNumArray[k]^iXORArray[i];
				if(iXORValue == iTempArray[n]) {
					iRes++;
				}
			}

			iRes = getMaxXOR(iNumArray, iTempArray, iSize, iXORArraySize-i-1, iRes, iXORValue);
		}
		return iRes;
	}

}


/*
 * https://practice.geeksforgeeks.org/problems/subsets-with-xor-value/0 
 * Subsets with XOR value 
 * Given an array arr[] of N integers and a integer K, find the
 * number of subsets of arr[] having XOR of elements as K.
 * 
 * Input:
 * 
 * The first line of input contains an integer T denoting the number of test
 * cases. Then T test cases follow. Each test case consists of two lines. The
 * first line of each test case contains two space separated integers N and K as
 * described in the problem statement. Second line of each test case contains N
 * space separated integers denoting the array arr[].
 * 
 * Output: Corresponding to each test case, print a single line containing an
 * integer denoting the total number of subsets of arr[] having XOR of thier
 * elements as K.
 * 
 * Constraints: 1<=T<=10 1<=N<=20 1<=K<=100 0<=arr[i]<=100
 * 
 * 
 * Example: Input: 
 * 1 
 * 4 6 
 * 6 9 4 2
 * 7 41 
 * 27 73 37 12 69 68 30
 * Output: 
 * 2
 * 2
 * 
 * Explanation: The subsets are {4,2} and {6}
 */


/**
 * 2 4 6 6 9 4 2 7 41 27 73 37 12 69 68 30 
 * Output: 2
 */




/*
 * Wrong Answer. !!!Wrong Answer
 * 
 * Possibly your code doesn't work correctly for multiple test-cases (TCs).
 * 
 * The first test case where your code failed:
 * 
 * Input: 7 41 27 73 37 12 69 68 30
 * 
 * Its Correct output is: 2
 * 
 * And Your Code's output is: 1
 */
