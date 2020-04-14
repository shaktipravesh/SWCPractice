package BitMagic;

import java.util.Scanner;

public class SumOfBitDifferences {

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
			iSum = getSumOfBitDifferences(iNumArray, iSize);
			System.out.println(iSum);
		}

		sc.close();
	}

	private static long getSumOfBitDifferences(int[] aNum, int iSize) {
		long iSum = 0;
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
			iSum += 2*x*(iSize-x);
		}
		return iSum;
	}

}

/*
 * https://practice.geeksforgeeks.org/problems/sum-of-bit-differences/0 Write a
 * program to find the sum of bit differences in all pairs that can be formed
 * from array elements n. Bit difference of a pair (x, y) is a count of
 * different bits at same positions in binary representations of x and y. For
 * example, bit difference for 2 and 7 is 2. Binary representation of 2 is 010
 * and 7 is 111 ( first and last bits differ in two numbers).
 * 
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. First line of the test case will contain an array of elements n.
 * 
 * Output: The sum of bit differences of all pairs that can be formed by given
 * array.
 * 
 * Constraints:
 * 
 * 1 <=T<= 100
 * 
 * 1 <=N<= 10
 * 
 * 1 <=a[i]<= 10
 * 
 * Example:
 * 
 * Input: 2 2 1 2 3 1 3 5
 * 
 * Output: 4 8
 * 
 * Note: (a, b) and (b, a) are considered two separate pairs.
 * 
 * Explanation: Test Case 1: 1: 01 2: 10 Bit difference in pair (1, 2): 2 Bit
 * difference in pair (2, 1): 2 Hence, total Bit difference = 2 + 2 = 4
 * 
 * Test Case 2: 1: 001 3: 011 5: 101 Bit difference in pair (1, 3): 1 Bit
 * difference in pair (3, 1): 1 Bit difference in pair (1, 5): 1 Bit difference
 * in pair (5, 1): 1 Bit difference in pair (3, 5): 2 Bit difference in pair (5,
 * 3): 2 Hence, total Bit difference = 1+1+1+1+2+2 = 8.
 */