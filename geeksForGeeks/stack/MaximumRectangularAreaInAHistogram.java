package stack;

import java.util.Scanner;

public class MaximumRectangularAreaInAHistogram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iSize = sc.nextInt();
			String aMaxHistogramArea = null;
			long[] aNum = new long[iSize];
			
			for(int i = 0; i < iSize; i++) {
				aNum[i] = sc.nextInt();
			}
			aMaxHistogramArea = getMaxHistogramArea(aNum, iSize); 
			System.out.println(aMaxHistogramArea);
		}
		sc.close();

	}

	private static String getMaxHistogramArea(long[] aNum, int iSize) {
		
		int[] aStackIndex = new int[iSize];
		long[] aStackValue = new long[iSize];
		String sMaxHistogramArea = null;
		long lMaxHistogramArea = 0, lArea = 0;
		aStackValue[0] = aNum[0];
		int i = 0, j = 0;
		for(i = 1, j = 0; i < iSize; i++) {
			if(aNum[i] > aStackValue[j]) {
				aStackIndex[++j] = i;
				aStackValue[j] = aNum[i];
			} else if(aNum[i] < aStackValue[j]) {
				while(j >=0 && (aNum[i] < aStackValue[j])) {
					lArea = getMultiplicationofLongNum(aStackValue[j], i-aStackIndex[j]);
					if(lArea > lMaxHistogramArea)
						lMaxHistogramArea = lArea;
					aStackValue[j] = aNum[i];
					j--;
				}
				j++;
			}
		}
		for(; j>=0; j--) {
			lArea = getMultiplicationofLongNum(aStackValue[j], i-aStackIndex[j]);
			if(lArea > lMaxHistogramArea)
				lMaxHistogramArea = lArea;
		}
		sMaxHistogramArea = "" + lMaxHistogramArea;
		return sMaxHistogramArea;
	}

	private static long getMultiplicationofLongNum(long l, int i) {
		long iMultiplication = l*i;
		return iMultiplication;
	}

}





/*
 * https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-
 * histogram/0
 * 
 * Find the largest rectangular area possible in a given histogram where the
 * largest rectangle can be made of a number of contiguous bars. For simplicity,
 * assume that all bars have same width and the width is 1 unit.
 * 
 * Input: The first line contains an integer 'T' denoting the total number of
 * test cases. T test-cases follow. In each test cases, the first line contains
 * an integer 'N' denoting the size of array. The second line contains N
 * space-separated integers A1, A2, ..., AN denoting the elements of the array.
 * The elements of the array represents the height of the bars.
 * 
 * Output: For each test-case, in a separate line, the maximum rectangular area
 * possible from the contiguous bars.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 106 1 <= A[i] <= 1018
 * 
 * Example: 
 * Input: 
 * 2 
 * 7 
 * 6 2 5 4 5 1 6 
 * 4 
 * 6 3 4 2 
 * Output: 
 * 12 
 * 9
 * 
 * Explanation: Testcase1:
 * 
 */