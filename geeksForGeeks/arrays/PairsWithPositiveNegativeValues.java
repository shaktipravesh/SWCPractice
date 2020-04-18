package arrays;

import java.util.Scanner;

public class PairsWithPositiveNegativeValues {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iSize = sc.nextInt();
			int[] iNumPositiveArray = new int[1001];
			int[] iNumNegativeArray = new int[1001];
			int[] iResult = new int[2001];
			for(int i = 0; i < iSize; i++) {
				int iNum = sc.nextInt();
				if(iNum < 0) {
					iNumNegativeArray[-iNum] = 1;
				}
				if(iNum > 0) {
					iNumPositiveArray[iNum] = 1;
				}
			}
			iResult = getPairs(iResult, iNumPositiveArray, iNumNegativeArray);
			for(int i = 1; i <= iResult[0]; i++) {
				System.out.print(iResult[i] + " ");
			}
			if(iResult[0] == 0)
				System.out.print(0);
			System.out.println();
		}
		sc.close();

	}

	private static int[] getPairs(int[] iResult, int[] iNumPositiveArray, int[] iNumNegativeArray) {

		for(int i = 1, j = 1; i <=1000; i++) {
			if(iNumPositiveArray[i] == 1 && iNumNegativeArray[i] == 1) {
				iResult[j++] = -i;
				iResult[j] = i;
				iResult[0] = j++;
			}
		}
		return iResult;
	}

}






/*
 * Given an array of distinct integers, print all the pairs having positive
 * value and negative value of a number that exists in the array.
 * 
 * NOTE: If there is no such pair in the array , print "0".
 * 
 * Input: The first line consists of an integer T i.e number of test cases. The
 * first line of each test case consists of an integer n.The next line of each
 * test case consists of n spaced integers.
 * 
 * Output: Print all the required pairs in the increasing order of their
 * absolute numbers.
 * 
 * Constraints: 1<=T<=100 1<=n<=1000 -1000<=a[i]<=1000
 * 
 * Example: 
 * Input: 
 * 2 
 * 6 
 * 1 -3 2 3 6 -1 
 * 8 
 * 4 8 9 -4 1 -1 -8 -9
 * 
 * Output: 
 * -1 1 -3 3 
 * -1 1 -4 4 -8 8 -9 9
 * 
 * Input
 * 2 
 * 9 
 * -241 76 137 -594 -367 -234 817 -438 -401 
 * 9 
 * -279 -188 -77 -461 -778 -179 -475 -581 -564 
 * Output
 * 0 
 * 0
 */


