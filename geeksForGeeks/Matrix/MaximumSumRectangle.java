package Matrix;

import java.util.Scanner;

public class MaximumSumRectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		sc.nextLine();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iRow = sc.nextInt();
			int iCol = sc.nextInt(); 
			int iMaxSumRectangle = 0;
			int[][] aMatrix = new int[iRow][iCol];
			for (int i = 0; i < iRow; i++) {
				for (int j = 0; j < iCol; j++) {
					aMatrix[i][j] = sc.nextInt();
				}
			}
			Solution S = new Solution();
			iMaxSumRectangle = S.getMaximumSumRectangle(aMatrix, iRow, iCol);
			System.out.println(iMaxSumRectangle);
		}
		sc.close();

	}

}

class Solution {
	int getMaximumSumRectangle(int[][] aMatrix, int iRow, int iCol) {
		int iMaxSumRectangle = 0;

		// int ileft = 0, iRight = 0, iTop = 0, iBot = 0;
		for (int lTemp = 0; lTemp < iCol; lTemp++) {
			int[] aKadaneMaxSumSubArray = new int[iRow];
			for (int rTemp = lTemp; rTemp < iCol; rTemp++) {
				
				for (int tTemp = 0; tTemp < iRow; tTemp++) {
					aKadaneMaxSumSubArray[tTemp] += aMatrix[tTemp][rTemp];
				}
				iMaxSumRectangle = getKadaneMaxSumSubArray(aKadaneMaxSumSubArray, iRow, iMaxSumRectangle);
			}
		}
		return iMaxSumRectangle;
	}

	private int getKadaneMaxSumSubArray(int[] aKadaneMaxSumSubArray, int iRow, int iMaxSumRectangle) {
		int iSum = 0;
		
		for(int rTemp = 0; rTemp < iRow; rTemp++) {
			if(iSum < 0) {
				iSum = aKadaneMaxSumSubArray[rTemp];
			} else {
				iSum += aKadaneMaxSumSubArray[rTemp];
			}
			if(iSum > iMaxSumRectangle)
				iMaxSumRectangle = iSum;
		}
		return iMaxSumRectangle;
	}
}



/*
 * https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle/0
 * 
 * 
 * Given a 2D array, find the maximum sum subarray in it. For example, in the
 * following 2D array, the maximum sum subarray is highlighted with blue
 * rectangle and sum of this subarray is 29.
 * 
 * 
 * 
 * Input: First line of every test case consists of T test case. First line of
 * every test case consists of 2 integers R and C , denoting number of rows and
 * columns. Second line consists of R*C spaced integers denoting number of
 * elements in array.
 * 
 * Output: Single line output, print the Max sum forming a rectangle in a 2-D
 * matrix
 * 
 * Example: Input: 1 4 5 1 2 -1 -4 -20 -8 -3 4 2 1 3 8 10 1 3 -4 -1 1 7 -6
 * Ouptut: 29
 * 
 */
//1
//4 5
// 1  2 -1 -4 -20 
//-8 -3  4  2  1 
// 3  8  10 1  3 
//-4 -1  1  7 -6

//For Input:
//2
//4 5
//1 2 -1 -4 -20 -8 -3 4 2 1 3 8 10 1 3 -4 -1 1 7 -6
//9 3
//-10 -21 5 -15 4 13 17 -16 -4 24 0 -7 -4 -22 -6 -20 -12 -12 12 24 18 -21 7 -9 -6 24 -11
//Your Output is:
//29
//55
